package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClientWrapper {
    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder().url("https://pokeapi.co/api/v2/pokemon/" + url)
                                               .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
