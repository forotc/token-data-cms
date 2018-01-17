package com.ailu.tokenmedia.manage.schedule;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PullData {
	private final static Logger log = LoggerFactory.getLogger(PullData.class);

	public static void main(String[] args) {

		String json = "{\"id\":1,\"name\":\"test\"}";

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			System.out.println("ID:" + map.get("id") + "  " + "name:" + map.get("name"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 每周一 0点0分0秒 执行
	@Scheduled(cron = "0 0 0 ? * MON ")
	private void overdue() {
		log.debug(".......卡过期check start");
		// TODO
		log.debug("卡过期check end.........");
	}
}