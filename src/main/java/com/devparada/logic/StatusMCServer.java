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

import com.devparada.model.StatusMCModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author devparada
 */
public class StatusMCServer {

    private final StatusMCModel statusMC;
    private final String ipServer;
    /**
     * The value is OK in HTTPConnection
     */
    public static final int HTTP_OK = 200;

    public StatusMCServer(StatusMCModel statusMC) {
        this.statusMC = statusMC;
        ipServer = this.statusMC.getHost() + ":" + this.statusMC.getPort();
    }

    private JsonObject fetchData() {
        if (!ipServer.isEmpty()) {
            String url = "https://api.mcstatus.io/v2/status/java/" + ipServer;  // URL of the remote JSON
            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("Accept", "application/json")
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == HTTP_OK) {
                    // Parse the JSON response body
                    JsonObject jsonReceived = JsonParser.parseString(response.body()).getAsJsonObject();
                    return jsonReceived;
                } else {
                    JOptionPane.showMessageDialog(null, "Not data", "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            } catch (JsonSyntaxException | IOException | InterruptedException e) {
                JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }

    public String showDataSection(String ipServer, String section) {
        JsonObject jsonReceived = fetchData();
        String textResult = "N/A";

        if (jsonReceived != null) {
            for (String key : jsonReceived.keySet()) {
                if (section.equals(key)) {
                    JsonElement value = jsonReceived.get(key);
                    switch (section) {
                        case "online" -> {
                            String statusServerOnline;
                            statusServerOnline = "Offline";
                            if ("true".equals(value.getAsString())) {
                                statusServerOnline = "Online";
                            }
                            textResult = statusServerOnline;
                        }
                        case "version" -> {
                            String nameClean = value.getAsJsonObject().get("name_clean").getAsString();
                            String versionName = nameClean;

                            if (nameClean.isEmpty()) {
                                versionName = "Unknown";
                            }
                            textResult = "Version: " + versionName;
                        }
                        case "players" -> {
                            String playersNumber = value.getAsJsonObject().get("online").getAsString();
                            String maxPlayers = value.getAsJsonObject().get("max").getAsString();
                            textResult = playersNumber + "/" + maxPlayers + " players";
                        }
                        case "icon" -> {
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
