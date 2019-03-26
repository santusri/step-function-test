package com.amazonaws.lambda.demo;

public class WeatherResponse {
	public CityWeatherResponse report;

	public WeatherResponse(CityWeatherResponse report) {
		super();
		this.report = report;
	}

	public WeatherResponse() {
		super();
	}

	public CityWeatherResponse getReport() {
		return report;
	}

	public void setReport(CityWeatherResponse report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "WeatherResponse [report=" + report + "]";
	}

	
	
}
