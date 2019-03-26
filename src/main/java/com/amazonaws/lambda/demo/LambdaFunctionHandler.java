package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<CityWeatherRequest,String> {

    @Override
    public String handleRequest(CityWeatherRequest weatherRequest, Context context) {
        context.getLogger().log("Input: " + weatherRequest);
        
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
//			HttpHost proxy = new HttpHost("proxy.cat.com", 80);
			RequestConfig config = RequestConfig.custom().build();
//					.setProxy(proxy)
					
			HttpGet httpget = new HttpGet("https://samples.openweathermap.org/data/2.5/weather?q="+weatherRequest.getCity()+","+weatherRequest.getCountry()+"&appid=2298e05626685ac1029c5b14a07df095");
			httpget.setConfig(config);
			System.out.println("Executing request "+httpget.getRequestLine());
			
			ResponseHandler<String> responseHandler = response ->{
    				int status = response.getStatusLine().getStatusCode();
    				System.out.println("Status==>"+status);
    				if(status >=200 && status <300){
    					HttpEntity entity = response.getEntity();
    					System.out.println("Entity==>"+entity);
    					return entity != null? EntityUtils.toString(entity):null;
    				}else {
    					throw new ClientProtocolException("unexpected response status: "+ status);
    				}
			};
			String responseBody = httpClient.execute(httpget, responseHandler);
			System.out.println("---------------");
			System.out.println(responseBody);
//			String resp = StringEscapeUtils.unescapeJava(responseBody); 
//			JSONParser parser = new JSONParser();
//			JSONObject json =(JSONObject)parser.parse(resp);
				
			return responseBody;
		
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException";
		} 
       
    }

}
