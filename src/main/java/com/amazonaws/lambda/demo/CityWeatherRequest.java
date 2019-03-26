package com.amazonaws.lambda.demo;

public class CityWeatherRequest {
	private String city;
	private String country;
	public CityWeatherRequest(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
	public CityWeatherRequest(){
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CityWeatherRequest [city=" + city + ", country=" + country + "]";
	}
	

}
