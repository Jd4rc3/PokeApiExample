package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import org.jboss.logging.Logger;

public class HttpCustomClient {
    public void run() throws URISyntaxException, IOException, InterruptedException {
        Gson gson = new Gson();
        Logger log = Logger.getLogger(HttpCustomClient.class);

        var bulbasaur = gson.fromJson(getPokemonById(1), Pokemon.class);
        var charmander = gson.fromJson(getPokemonById(4), Pokemon.class);
        var squirtle = gson.fromJson(getPokemonById(7), Pokemon.class);

        log.info(bulbasaur.toString());
        log.info(charmander.toString());
        log.info(squirtle.toString());
    }

    private String getPokemonById(int id) throws URISyntaxException, IOException,
            InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                                            .uri(new URI("https://pokeapi.co/api/v2/pokemon/" + id))
                                            .header("Accept", "application/json")
                                            .GET()
                                            .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        return httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString()).body();
    }
}
