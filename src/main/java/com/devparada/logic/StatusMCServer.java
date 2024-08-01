/*
 * This file is part of StatusMCServerTool.
 *
 * StatusMCServerTool is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * StatusMCServerTool is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with StatusMCServerTool. If not, see <https://www.gnu.org/licenses/>.
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

    public JsonObject fetchData(String ipServer) {
        if (!ipServer.isEmpty()) {
            String urlJSON = "https://api.mcstatus.io/v2/status/java/" + ipServer;  // URL of the remote JSON
            try {
                URL url = new URL(urlJSON);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    StringBuilder sb = new StringBuilder();
                    String output;
                    while ((output = br.readLine()) != null) {
                        sb.append(output);
                    }

                    conn.disconnect();

                    JsonObject jsonReceived = JsonParser.parseString(sb.toString()).getAsJsonObject();
                    return jsonReceived;
                }
            } catch (JsonSyntaxException | IOException e) {
            }
        }
        return null;
    }

    public JsonObject obtainDataJSON(String ipServer) {
        return fetchData(ipServer);
    }

    public String obtainData(String ipServer) {
        return showData(fetchData(ipServer));
    }

    public String showData(JsonObject jsonReceived) {
        String textResult = "";

        if (jsonReceived != null) {
            for (String key : jsonReceived.keySet()) {
                JsonElement value = jsonReceived.get(key);

                if ("online".equals(key)) {
                    String statusServerOnline = "offline";

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
        }
        return textResult;
    }

    public String showDataSection(String ipServer, String section) {
        JsonObject jsonReceived = obtainDataJSON(ipServer);
        String textResult = "N/A";

        if (jsonReceived != null) {
            for (String key : jsonReceived.keySet()) {
                JsonElement value = jsonReceived.get(key);

                switch (section) {
                    case "online" -> {
                        String statusServerOnline;
                        if (section.equals(key)) {
                            statusServerOnline = "Offline";
                            if ("true".equals(value.getAsString())) {
                                statusServerOnline = "Online";
                            }
                            textResult = statusServerOnline;
                        }
                    }
                    case "version" -> {
                        if (section.equals(key)) {
                            String nameClean = value.getAsJsonObject().get("name_clean").getAsString();
                            textResult = nameClean;
                        }
                    }
                    case "players" -> {
                        if (section.equals(key)) {
                            String playersNumber = value.getAsJsonObject().get("online").getAsString();
                            String maxPlayers = value.getAsJsonObject().get("max").getAsString();
                            textResult = playersNumber + "/" + maxPlayers + " players";
                        }
                    }
                    case "icon" -> {
                        if (section.equals(key)) {
                            String icon = value.getAsString();

                            if (icon.contains(",")) {
                                icon = icon.split(",")[1];
                            }

                            textResult = icon;
                        }
                    }
                }
            }
        }
        return textResult;
    }
}
