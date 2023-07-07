package com.qa.tests;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.restclient;
import com.qa.util.TestUtil;

import java.util.HashMap;
import java.util.Properties;

public class GetAPITest extends TestBase {
	
	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	restclient restclient;
	CloseableHttpResponse closeablehttpresponse;
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException{
		//super();
		testbase=new TestBase();
		
		serviceurl=prop.getProperty("URL");
		apiurl=prop.getProperty("serviceURL");
		url=serviceurl+apiurl;
	}
	
	@Test
	public void getapitestwithoutheaders() throws ClientProtocolException, IOException {
		
		restclient = new restclient();
		closeablehttpresponse = restclient.get(url);
		
		//ststu code
		int statuscode=closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("Status code"+statuscode);
		Assert.assertEquals(statuscode,response_SC_200,"Status code is not 200");
		
		//b. json String
		String responsestring=EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		JSONObject responsejson=new JSONObject(responsestring);
		System.out.println("Response json"+responsejson);
		String perpagevalue=TestUtil.getValueByJpath(responsejson,"/per_page");
		System.out.println(perpagevalue);
		Assert.assertEquals(perpagevalue,3);
		
		String totalvalue=TestUtil.getValueByJpath(responsejson,"/total");
		System.out.println(totalvalue);
		Assert.assertEquals(totalvalue,12);
		
		//single value assertion
		//perp page
		String perpagevalue=testUtil.getValuebyJpath(responsejson,"/perpage");
		System.out.println("value of per page is "+perpagevalue);
		Assert.assertEquals(Integer.parseInt(perpagevalue),3);
		
		//total:
		String totalvalue=testUtil.getValuebyJpath(reponsejson,"/total");
		System.out.println("value of per page is "+totalvalue);
		Assert.assertEquals(Integer.parseInt(totalvalue),12);
		
		//get the value from json array
		String lastname=testUtil.getValuebyJpath(responsejson,"/data[0]/last_name");
		String id=testUtil.getValuebyJpath(responsejson,"/data[0]/id");
		String avatar=testUtil.getValuebyJpath(responsejson,"/data[0]/avatar");
		String firstname=testUtil.getValuebyJpath(responsejson,"/data[0]/first_name");
		
		//All headers
		Header[] headersArray=closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allheaders=new HashMap<String, String>();
		for(Header header:headersArray) {
			allheaders.put(header.getName(), header.getValue());
			
		}
		System.out.println("headers Array"+allheaders);
		
	}
	
	@Test(priority=2)
	public void getapitestwithheaders() throws ClientProtocolException, IOException {
	
		restclient = new restclient();
		
		HashMap<String,String> headermap=new HashMap<String,String>();
		headermap.put("content-type", "application/json");
		headermap.put("Username", "test@boa.com");
		headermap.put("password", "test123");
		headermap.put("Auth_token", "12345");
		
		
		
		closeablehttpresponse = restclient.get(url,headermap);
		
		
		
	
		
	}
	

}
