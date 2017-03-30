package com.route.www.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataController {

	@RequestMapping(value = "dataSet", method = RequestMethod.GET)
	public int[] dataSet() {
		int[] data = new int[12];
		for (int i = 0; i < data.length; i++) {
			int randomNumber = (int) Math.floor(Math.random() * 30);
			data[i] = randomNumber;
		}
		return data;
	}
	
	@RequestMapping(value = "scatterDataSet", method = RequestMethod.GET)
	public int[][] scatterDataSet() {
		int[][] data = new int[12][2];
		for (int i = 0; i < data.length; i++) {
			int[] array = data[i];
			array[0] = i;
			array[1] = (int) Math.floor(Math.random() * 1000);
		}
		return data;
	}
}
