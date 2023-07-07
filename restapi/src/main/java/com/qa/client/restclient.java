package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class restclient {
	
	
	//GET method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient=HttpClients.createDefault();// create a http client
		HttpGet httpget=new HttpGet(url);//http get request
		CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);//hit the get url
		return closeableHttpResponse;
		}
	
	/*public CloseableHttpResponse get(String url,HashMap<String, String> headermap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient=HttpClients.createDefault();// create a http client
		HttpGet httpget=new HttpGet(url);//http get request
		
		for(Map.Entry<String,String> entry:headermap.entrySet()) {
			httpget.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);//hit the get url
		return closeableHttpResponse;
		}
	
		//a.status code
		
		System.out.println(closeableHttpResponse);
		
		
		
		//C. All headers
		Header[] headersArray=closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allheaders=new HashMap<String, String>();
		for(Header header:headersArray) {
			allheaders.put(header.getName(), header.getValue());
			
		}
		System.out.println("headers Array"+allheaders);
		
		
				
	}*/

}
