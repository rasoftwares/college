package com.rablion.college.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Base {
	public static void main(String a[]) throws Exception {
	
	}
	/*
	 * Download URL contents as HTML response   
	 */
	public String getURLContent(String url, Map<String,String> nvPair) throws Exception {
		HttpClient client = new DefaultHttpClient();
		System.out.println("URL " + url + ":" + nvPair);
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        Set<String> keys = nvPair.keySet();
        
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
        	String key = it.next();
        	String value = nvPair.get(key);
        	nameValuePairs.add(new BasicNameValuePair(key, value));
        }
        
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = client.execute(post);
        System.out.println("Response Code ->" + response.getStatusLine().getStatusCode());
        String out = IOUtils.toString(response.getEntity().getContent());
        
        return out;
	}
	
	/*
	 * 
	 */
	public JsonArray parseHtmlTAGToJsonArray(String out,String tag) {
		
		 Document doc = Jsoup.parse(out);
	        Elements e = doc.getAllElements();
	        Iterator<Element> it = e.listIterator();
	        
	        JsonArray jarray = new JsonArray();
	        while(it.hasNext()) {
	        	Element el = it.next();
	        	if(tag.equals(el.tagName())) {
		        	
	        		
	        		if(el.attr("value") != null && el.attr("value")!=""){
	        			//System.out.println(el.attr("value") + ":" + el.text());
	        			JsonObject jo = new JsonObject();
	        			
	        			jo.addProperty("code", el.attr("value"));
	        			jo.addProperty("name", el.text());
	        			jarray.add(jo);
	        		}
	        	}
	        }
	        return jarray;
	}
	
}
