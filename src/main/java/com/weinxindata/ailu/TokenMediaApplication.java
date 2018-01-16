package com.weinxindata.ailu;

import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication
public class TokenMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenMediaApplication.class, args);
	}

	// mybatis
	@Bean
	@Autowired
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.weinxindata.ailu.**.dto");
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(
				pathMatchingResourcePatternResolver.getResources("classpath*:mybatis/mapper/**/*.xml"));
		sqlSessionFactoryBean
				.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/mybatis.xml"));

		return sqlSessionFactoryBean.getObject();

	}

	// 事物
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(druidDataSource());
	}

	// druid 数据库连接池
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}

	// dao scan
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.weinxindata.ailu.**.dao");
	
		return mapperScannerConfigurer;
	}

	// 线程池
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(10);
		// executor.setRejectedExecutionHandler(new
		// ThreadPoolExecutor.CallerRunsPolicy()); // 对拒绝task的处理策略
		executor.setKeepAliveSeconds(2);
		executor.initialize();
		return executor;
	}
}
