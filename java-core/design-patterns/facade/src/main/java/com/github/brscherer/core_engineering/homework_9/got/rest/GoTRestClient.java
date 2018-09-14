package com.github.brscherer.core_engineering.homework_9.got.rest;

import com.github.brscherer.core_engineering.homework_9.got.rest.models.CharacterRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStreamReader;

public class GoTRestClient {
    private final static String URL_API = "https://anapioficeandfire.com/api";

    public CharacterRequest getByID(Long id) {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet(URL_API + "/characters/" + id);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(new InputStreamReader(entity.getContent()), CharacterRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot get response from API");
        }
    }

}
