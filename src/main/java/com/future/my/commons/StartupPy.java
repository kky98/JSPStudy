package com.future.my.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class StartupPy {
	private static final Logger logger = LoggerFactory.getLogger(StartupPy.class);
	
	Runtime rt = Runtime.getRuntime();
	public StartupPy() throws ParseException {
		logger.info("python start");
		System.out.println("python start");
//		test();
//		try {
//			Process proc = rt.exec("C:\\dev\\anaconda3\\envs\\bigdata\\python C:\\dev\\pythonProject\\test.py");
			
			 // 결과를 읽기 위한 BufferedReader 생성
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

            // 표준 출력 읽기
//            String s;
//            System.out.println("Here is the standard output of the command:\n");
//            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
//            }
//		} catch (IOException e) {
//			logger.error(e.toString());
//			e.printStackTrace();
//		}
		
	}
	
//	public void test() throws ParseException {
//		String api_key = "RGAPI-434e8c55-a713-416b-9c4e-e7ed4f8b8f38";
//		String team_name = "잡초아저씨";
//	    String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+team_name+"?api_key="+api_key;
//        RestTemplate restTemplate = new RestTemplate();
//        
//        String response = restTemplate.getForObject(url, String.class);
//        System.out.println(response);
//        JSONParser parser = new JSONParser();
//        JSONObject jsonObject = (JSONObject) parser.parse(response);
//        String id_code = (String) jsonObject.get("id");
//        
//        String url_two = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id_code+"?api_key="+api_key;
//        String response2 = restTemplate.getForObject(url_two, String.class);
//        System.out.println(response2);
//        JSONArray jsonArray = (JSONArray) parser.parse(response2);
//        
//        for(Object item : jsonArray) {
//            JSONObject obj = (JSONObject) item;
//            String tier = (String) obj.get("tier");
//            System.out.println("tier: " + tier);
//        }
//        
//	}
}
