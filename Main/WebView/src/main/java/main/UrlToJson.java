package main;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class UrlToJson {

    private final String response;

    public UrlToJson(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response httpResponse = client.newCall(request).execute()) {
            if (!httpResponse.isSuccessful()) {
                throw new IOException("Unexpected response code: " + httpResponse);
            }
            response = httpResponse.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Error making HTTP request", e);
        }
    }

    public String getResponse() {
        return response;
    }
}
