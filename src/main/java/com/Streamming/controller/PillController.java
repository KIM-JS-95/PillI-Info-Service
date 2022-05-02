package com.Streamming.controller;


import com.Streamming.Entity.NoticeEntity;
import com.Streamming.Entity.QueryEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


@RestController
public class PillController {

    @Value("${medic.client.Encoding}")
    private String Encodingkey;

    @Value("${medic.client.Decoding}")
    private String Decodingkey;

    @Value("${pillUrl}")
    private String PillUrl;


    @PostMapping("/mypill")
    public JSONObject Search(@RequestBody @Valid QueryEntity queryEntity) throws IOException, ParseException {
        StringBuilder urlBuilder = new StringBuilder(PillUrl); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + Encodingkey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("item_name", "UTF-8") + "=" + URLEncoder.encode(queryEntity.getPillName(), "UTF-8")); /*품목명*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(queryEntity.getNumOfRows(), "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(sb.toString());
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

    @GetMapping("/")
    public JSONObject notice() throws ParseException, JsonProcessingException {
        NoticeEntity noticeEntity = new NoticeEntity("공지사항입니다.");
        String jsonstring = new ObjectMapper().writeValueAsString(noticeEntity);

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonstring);
        JSONObject jsonObj = (JSONObject) obj;

        return jsonObj;
    }

}

