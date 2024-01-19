package com.example.SpringBoot.main;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class UrlToJson {

    private final String Response;

    public UrlToJson(String URL) {
        HttpResponse<String> response = Unirest.get(URL)
                .asString();
        Response = response.getBody();
    }

    public String getResponse() {
        return Response;
    }

}