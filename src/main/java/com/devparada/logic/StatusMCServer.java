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
 * You should have received showDataFrame copy of the GNU General Public License
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
