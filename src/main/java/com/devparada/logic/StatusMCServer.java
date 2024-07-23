/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devparada.logic;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author devparada
 */
public class StatusMCServer {

    public String host;
    public int port;

    public StatusMCServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String obtainData(String ipServer) {
        if (!ipServer.isEmpty()) {
            String urlJSON = "https://api.mcstatus.io/v2/status/java/" + ipServer;  // URL of the remote JSON
            try {
                URL url = new URL(urlJSON);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
                    return "0";
                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    StringBuilder sb = new StringBuilder();
                    String output;
                    while ((output = br.readLine()) != null) {
                        sb.append(output);
                    }

                    conn.disconnect();

                    JsonObject jsonReceived = JsonParser.parseString(sb.toString()).getAsJsonObject();
                    return showData(jsonReceived);
                }
            } catch (JsonSyntaxException | IOException e) {
            }
        } else {
            return "0";
        }
        return "0";
    }

    public String showData(JsonObject jsonReceived) {
        String textResult = "";

        for (String key : jsonReceived.keySet()) {
            JsonElement value = jsonReceived.get(key);

            String statusServerOnline;

            if ("online".equals(key)) {
                statusServerOnline = "offline";
                if ("true".equals(value.getAsString())) {
                    statusServerOnline = "online";
                }
                textResult = "The server is " + statusServerOnline + "\n";
            }

            if ("version".equals(key)) {
                String nameClean = value.getAsJsonObject().get("name_clean").getAsString();
                textResult += "Server version " + nameClean + "\n";
            }

            if ("players".equals(key)) {
                String playersNumber = value.getAsJsonObject().get("online").getAsString();
                textResult += "Players playing " + playersNumber + "\n";
            }

        }
        return textResult;
    }

}
