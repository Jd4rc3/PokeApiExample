package org.example;

import com.google.gson.Gson;
import org.jboss.logging.Logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        var client = new HttpClientWrapper();
        Logger log = Logger.getLogger(Main.class);

        Pokemon bulbasaur = gson.fromJson(client.run("1"), Pokemon.class);

        log.info(bulbasaur.toString());
    }
}