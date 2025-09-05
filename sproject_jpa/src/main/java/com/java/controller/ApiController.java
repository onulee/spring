package com.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApiController {
	
	@Value("${api.service_key}")
	private String service_key;
	
	@GetMapping("/api/list") //api페이지 열기
	public String list(Model model) { //페이지로 열때는 json파싱으로 해줘야 함.
		return "api/list";
	}
	
	@ResponseBody
	@GetMapping("/api/jsonAPI") //공공데이터 가져오기
	public String jsonAPI(
			@RequestParam(name="page",defaultValue = "1") String page
			) throws Exception  {
		//api 호출 : 공공데이터포털에서 제공하는 소스 -----------------------
		
		//String service_key = "918RE13GA7OY7ZEmUzApgbOeAcQoZ%2FaHsXWcqPAKQ9YNNPj83KOstRMRIUrCFIAcm9qj2R6b7NFZjp%2FYsYzJLg%3D%3D";
		//String page = "1"; //하단넘버링 페이지
		String web_url = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1";
		StringBuilder urlBuilder = new StringBuilder(web_url); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+service_key); /*Service Key*/
		//주석처리해야 함.
		//urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*이부분 주석처리 : 공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)*/
		urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명(어플명)*/
		urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*정렬구분 : A=촬영일, B=제목, C=수정일*/
		urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		 rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
		 rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
		sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//---------------------
		System.out.println("데이터 출력 :");
		System.out.println(sb.toString());
			
		return sb.toString();
	}
	
	@ResponseBody
	@GetMapping("/api/xmlAPI") //공공데이터 가져오기
	public String xmlAPI(
			@RequestParam(name="page",defaultValue = "1") String page
			) throws Exception  {
		//api 호출 : 공공데이터포털에서 제공하는 소스 -----------------------
		
		//String service_key = "918RE13GA7OY7ZEmUzApgbOeAcQoZ%2FaHsXWcqPAKQ9YNNPj83KOstRMRIUrCFIAcm9qj2R6b7NFZjp%2FYsYzJLg%3D%3D";
		//String page = "1"; //하단넘버링 페이지
		String web_url = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1";
		StringBuilder urlBuilder = new StringBuilder(web_url); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+service_key); /*Service Key*/
		//주석처리해야 함.
		//urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*이부분 주석처리 : 공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)*/
		urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명(어플명)*/
		urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*정렬구분 : A=촬영일, B=제목, C=수정일*/
		urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*요청자료형식(XML/JSON)*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//---------------------
		System.out.println("데이터 출력 :");
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	

}
