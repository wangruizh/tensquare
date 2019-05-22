package com.eloan.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 实名认证工具类
 * @author 37647
 *
 */
public class IdCardUtil {
	
	public ResultJSON realAuth(String name,String idCard){
		ResultJSON jsons = new ResultJSON();
		try {
			String host = "https://checkid.market.alicloudapi.com";
		    String path = "/IDCard";
	        String appcode = "ebf058f9925b4f1da3a181cc36e84765";
	        String urlSend = host + path + "?idCard=" + idCard + "&name=" + name;
	        URL url = new URL(urlSend);
	        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
	        int httpCode = httpURLConnection.getResponseCode();
	        String json = read(httpURLConnection.getInputStream());
	        JSONObject jsonObject = JSON.parseObject(json);
	        if (jsonObject.getString("status").equals("01")){
	        	jsons.setSuccess(true);
	        	jsons.setMsg(jsonObject.getString("msg"));
	        } else {
	        	jsons.setSuccess(false);
	        	jsons.setMsg(jsonObject.getString("msg"));
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return jsons;
	}
	
	
	 public static void main(String[] args) throws  Exception{
		
	    	String host = "https://checkid.market.alicloudapi.com";
		    String path = "/IDCard";
	        String appcode = "8b878c3399354c24a891bfefe325372c";
	        String idCard = "130106198703201837";
	        String name = "仵志松"; 
	        String urlSend = host + path + "?idCard=" + idCard + "&name=" + name;
			
	        URL url = new URL(urlSend);
	        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
	        int httpCode = httpURLConnection.getResponseCode();
	        String json = read(httpURLConnection.getInputStream());
	        System.out.println("/* 获取服务器响应状态码 200 正常；400 权限错误 ； 403 次数用完； */ ");
	        System.out.println(httpCode);
	        System.out.println("/* 获取返回的json   */ ");
	        System.out.print(json);
	    }
	    /*
	        读取返回结果
	     */
	    private static String read(InputStream is) throws IOException {
	        StringBuffer sb = new StringBuffer();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String line = null;
	        while ((line = br.readLine()) != null) {
	            line = new String(line.getBytes(), "utf-8");
	            sb.append(line);
	        }
	        br.close();
	        return sb.toString();
	    }
	
}
