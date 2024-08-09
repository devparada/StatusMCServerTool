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

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author devparada
 */
public class ImageServer {

    public BufferedImage showImage(String base64Image) {
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        BufferedImage img = null;
        try {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes)) {
                img = ImageIO.read(bis);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
        }

        return img;
    }

    /**
     * Check if the server have a image
     *
     * @param imageServer image of the server
     * @return Return true if image is not null
     */
    public boolean checkImage(BufferedImage imageServer) {
        return imageServer != null;
    }
}
