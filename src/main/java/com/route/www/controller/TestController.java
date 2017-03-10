package com.route.www.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {

	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	private static AtomicBoolean exists = new AtomicBoolean(false);
	
	@SuppressWarnings("finally")
	@RequestMapping("/testMultiThread")
	public @ResponseBody AsyncResult<Map<String,Integer>> testMultiThread() {
		Map<String, Integer> result = new HashMap<>();
		String writeFileThreadName = "write file to disk Thread";
		if (exists.compareAndSet(false, true)) {  //当第一个线程设置为true后，另外的线程是进不来的
			try{
				//write();
				Task t = new Task();
				Thread thread = new Thread(t);
				thread.setName(writeFileThreadName);
				thread.start();
				LOG.info("Thread " + writeFileThreadName + " start...");
			}catch(Exception e){
				LOG.debug("Thread" + writeFileThreadName + "start error: " + e.getMessage());
			}finally{
				exists.set(false);
				result.put("result", 0);
				return new AsyncResult<Map<String,Integer>>(result);
			}
		}else{
			result.put("result", -1);
			return new AsyncResult<Map<String,Integer>>(result);
		}
	};
	class Task implements Runnable {

		@Override
		public void run() {
			if(exists.compareAndSet(false, true)) {
				LOG.info("write start");
				write();
				exists.set(false);
				LOG.info("write end");
			}
		}
		
	}
	public void write() {
			//写入文件地址 
		FileWriter writer;
		try {
			writer = new FileWriter("D:/a.txt");
			BufferedWriter buffer = new BufferedWriter(writer); 
			StringBuilder sb = new StringBuilder(); 
			//每次写入50kb 
			for (int j = 0; j < 50; j++) { 
				sb.append("1"); 
			} 

			int max = 1 * 1024 * 1024 * 1024;//1G 
			long start = System.currentTimeMillis(); 
			//写入1M文件所有时间 
			int time = max/50; 
			for (int i = 0; i < time; i++) { 
				buffer.write(sb.toString()); 
			} 
			buffer.flush(); 
			buffer.close(); 
			long end = System.currentTimeMillis(); 
			LOG.info("write end cost:" + (end - start) / 1000 + "s"); 
		} catch (IOException e) {
			LOG.debug("write error, message: " + e.getMessage());
		}
	}
}
