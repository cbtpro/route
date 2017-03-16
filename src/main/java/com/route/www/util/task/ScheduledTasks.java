package com.route.www.util.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.route.www.common.Constants;

@Component
public class ScheduledTasks {
	
	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.HHmmSS);
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		LOG.info("The time is now {}", dateFormat.format(new Date()));
	}
}
