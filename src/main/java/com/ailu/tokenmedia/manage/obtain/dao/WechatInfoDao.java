package com.ailu.tokenmedia.manage.obtain.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author liu zhenming
 * @version V1.0
 * @date 2018/1/17
 */
public interface WechatInfoDao {

    void save(@Param("wechatId") String wechatId, @Param("fans") int fans,
              @Param("firstAvgRead") int firstAvgRead, @Param("secondAvgRead") int secondAvgRead,
              @Param("thirdMoreAvgRead") int thirdMoreAvgRead, @Param("articleCount") int articleCount,
              @Param("createTime")Date createTime);

}
