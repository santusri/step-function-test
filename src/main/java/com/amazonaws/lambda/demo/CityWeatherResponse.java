package com.amazonaws.lambda.demo;

public class CityWeatherResponse {
	
	private String WeatherReport;

	public CityWeatherResponse(String weatherReport) {
		super();
		WeatherReport = weatherReport;
	}
	public CityWeatherResponse(){
		
	}
	public String getWeatherReport() {
		return WeatherReport;
	}
	public void setWeatherReport(String weatherReport) {
		WeatherReport = weatherReport;
	}
	

}
