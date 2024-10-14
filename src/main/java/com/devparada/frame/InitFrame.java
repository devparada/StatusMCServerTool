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
package com.devparada.frame;

import com.devparada.logic.ImageServer;
import com.devparada.logic.StatusMCServer;
import com.devparada.persistency.DBManager;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author devparada
 */
public class InitFrame extends javax.swing.JFrame {

    /**
     * Database connection for use methods of DBManager class
     */
    protected final DBManager database = new DBManager();

    /**
     * Creates new form InitFrame
     */
    public InitFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jPnlMain = new javax.swing.JPanel();
        jPnlIntro = new javax.swing.JPanel();
        jPnlInfo = new javax.swing.JPanel();
        jPnlIntroInfo = new javax.swing.JPanel();
        jBtnIntroAdd = new javax.swing.JButton();
        jLblLoading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StatusMCServerTool");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(759, 403));
        setName("initFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(759, 403));
        setResizable(false);

        jScrollPane.setBackground(new java.awt.Color(27, 38, 59));
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPnlMain.setBackground(new java.awt.Color(27, 38, 59));
        jPnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPnlMain.setLayout(new javax.swing.BoxLayout(jPnlMain, javax.swing.BoxLayout.Y_AXIS));

        jPnlIntro.setBackground(new java.awt.Color(27, 38, 59));
        jPnlIntro.setLayout(new javax.swing.BoxLayout(jPnlIntro, javax.swing.BoxLayout.PAGE_AXIS));
        jPnlMain.add(jPnlIntro);

        jPnlInfo.setBackground(new java.awt.Color(27, 38, 59));
        jPnlInfo.setMinimumSize(new java.awt.Dimension(720, 120));
        jPnlInfo.setPreferredSize(new java.awt.Dimension(480, 60));
        jPnlInfo.setLayout(new javax.swing.BoxLayout(jPnlInfo, javax.swing.BoxLayout.Y_AXIS));

        jPnlIntroInfo.setBackground(new java.awt.Color(27, 38, 59));
        jPnlIntroInfo.setMinimumSize(new java.awt.Dimension(390, 93));

        jBtnIntroAdd.setBackground(new java.awt.Color(127, 255, 0));
        jBtnIntroAdd.setForeground(new java.awt.Color(0, 0, 0));
        jBtnIntroAdd.setText("Add server");
        jBtnIntroAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnIntroAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnIntroAdd.setMaximumSize(new java.awt.Dimension(150, 40));
        jBtnIntroAdd.setMinimumSize(new java.awt.Dimension(150, 40));
        jBtnIntroAdd.setPreferredSize(new java.awt.Dimension(150, 40));
        jBtnIntroAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIntroAddActionPerformed(evt);
            }
        });

        jLblLoading.setBackground(new java.awt.Color(222, 222, 222));
        jLblLoading.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblLoading.setText("Loading...");
        jLblLoading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLblLoading.setMaximumSize(new java.awt.Dimension(66, 20));
        jLblLoading.setMinimumSize(new java.awt.Dimension(66, 20));

        javax.swing.GroupLayout jPnlIntroInfoLayout = new javax.swing.GroupLayout(jPnlIntroInfo);
        jPnlIntroInfo.setLayout(jPnlIntroInfoLayout);
        jPnlIntroInfoLayout.setHorizontalGroup(
            jPnlIntroInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlIntroInfoLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(jPnlIntroInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnIntroAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(170, 170, 170))
        );
        jPnlIntroInfoLayout.setVerticalGroup(
            jPnlIntroInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlIntroInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIntroAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPnlInfo.add(jPnlIntroInfo);

        jPnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        jPnlMain.add(jPnlInfo);

        jScrollPane.setViewportView(jPnlMain);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIntroAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIntroAddActionPerformed
        AddServerDialog jDlgAdd = new AddServerDialog(this, true);
        jDlgAdd.setLocationRelativeTo(null);
        jDlgAdd.setVisible(true);
    }//GEN-LAST:event_jBtnIntroAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            /*
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            InitFrame initFrame = new InitFrame();
            initFrame.setLocationRelativeTo(null);
            initFrame.setBackground(new java.awt.Color(27, 38, 59));
            initFrame.setVisible(true);
            initFrame.start();
        });
    }

    private void start() {
        if (!database.checkTable()) {
            database.createTable();
        }

        ArrayList<Object[]> dataServers = database.collectData();

        for (Object[] dataServer : dataServers) {
            for (Object data : dataServer) {
                String[] ipServer = data.toString().split(":");

                // Used SwingUtilities to prevent concurrence problems
                SwingUtilities.invokeLater(() -> {
                    jLblLoading.setVisible(false);
                    addPanel(ipServer[0], Integer.parseInt(ipServer[1]));
                });
            }
        }
    }

    private void deletePanelServer(JPanel panel) {
        jPnlInfo.remove(panel);
        jPnlInfo.revalidate();
        jPnlInfo.repaint();
    }

    /**
     * Add a panel with the server status with a given layout
     *
     * @param ipServer server ip
     * @param port server port
     */
    protected void addPanel(String ipServer, int port) {
        StatusMCServer statusServer = new StatusMCServer(ipServer, port);
        String ipServerPort = ipServer + ":" + port;

        JPanel jPanelServer = new JPanel(new java.awt.GridBagLayout());
        jPanelServer.setBackground(new Color(27, 38, 59));
        JLabel jTxtIMG = new JLabel();
        JTextField jTxtHostIp = new JTextField(ipServerPort);
        JTextField jTxtOnline = new JTextField(statusServer.showDataSection(ipServerPort, "online"));
        JTextField jTxtVersion = new JTextField(statusServer.showDataSection(ipServerPort, "version"));
        JTextField jTxtPlayers = new JTextField(statusServer.showDataSection(ipServerPort, "players"));

        JButton jBtnEdit = new JButton("Edit");
        jBtnEdit.setBackground(new Color(0, 119, 182));
        jBtnEdit.setForeground(new Color(0, 0, 0));
        jBtnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JButton jBtnDelete = new JButton("Delete");
        jBtnDelete.setBackground(new Color(255, 107, 107));
        jBtnDelete.setForeground(new Color(0, 0, 0));
        jBtnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // inset jPanel -> top, left, bottom, right
        jPanelServer.setBorder(new EmptyBorder(0, 100, 0, 100));

        jTxtIMG.setHorizontalAlignment(JTextField.RIGHT);
        jTxtIMG.setBorder(null);
        jTxtIMG.setMinimumSize(new java.awt.Dimension(64, 64));
        jTxtIMG.setPreferredSize(new java.awt.Dimension(64, 64));

        ImageServer image = new ImageServer();
        BufferedImage imageServer = image.showImage(statusServer.showDataSection(ipServerPort, "icon"));
        if (image.checkImage(imageServer)) {
            // Create ImageIcon with base64 Image without "data:image/png;base64"
            ImageIcon imageIcon = new ImageIcon(imageServer);
            jTxtIMG.setIcon(imageIcon);
        }
        GridBagConstraints gridBagConstraintsIMG = new GridBagConstraints();
        gridBagConstraintsIMG.gridx = 0;
        gridBagConstraintsIMG.gridy = 0;
        gridBagConstraintsIMG.fill = GridBagConstraints.BOTH;
        jPanelServer.add(jTxtIMG, gridBagConstraintsIMG);

        jTxtVersion.setEditable(false);
        jTxtVersion.setForeground(new Color(240, 240, 240));
        jTxtVersion.setBackground(new Color(27, 38, 59));
        jTxtVersion.setHorizontalAlignment(JTextField.CENTER);
        jTxtVersion.setBorder(null);
        GridBagConstraints gridBagConstraintsVersion = new GridBagConstraints();
        gridBagConstraintsVersion.gridx = 1;
        gridBagConstraintsVersion.gridy = 0;
        gridBagConstraintsVersion.gridwidth = 2;
        gridBagConstraintsVersion.fill = GridBagConstraints.BOTH;
        jPanelServer.add(jTxtVersion, gridBagConstraintsVersion);

        jTxtHostIp.setEditable(false);
        jTxtHostIp.setForeground(new Color(240, 240, 240));
        jTxtHostIp.setBackground(new Color(27, 38, 59));
        jTxtHostIp.setHorizontalAlignment(JTextField.RIGHT);
        jTxtHostIp.setBorder(null);
        GridBagConstraints gridBagConstraintsHostIp = new GridBagConstraints();
        gridBagConstraintsHostIp.gridx = 0;
        gridBagConstraintsHostIp.gridy = 1;
        gridBagConstraintsHostIp.weightx = 1.0;
        gridBagConstraintsHostIp.fill = GridBagConstraints.BOTH;
        jPanelServer.add(jTxtHostIp, gridBagConstraintsHostIp);

        jTxtOnline.setEditable(false);
        jTxtOnline.setForeground(new Color(240, 240, 240));
        jTxtOnline.setBackground(new Color(27, 38, 59));
        jTxtOnline.setHorizontalAlignment(JTextField.CENTER);
        jTxtOnline.setBorder(null);
        GridBagConstraints gridBagConstraintsOnline = new GridBagConstraints();
        gridBagConstraintsOnline.gridx = 1;
        gridBagConstraintsOnline.gridy = 1;
        gridBagConstraintsOnline.weightx = 1.0;
        gridBagConstraintsOnline.fill = GridBagConstraints.BOTH;
        jPanelServer.add(jTxtOnline, gridBagConstraintsOnline);

        jTxtPlayers.setEditable(false);
        jTxtPlayers.setForeground(new Color(240, 240, 240));
        jTxtPlayers.setBackground(new Color(27, 38, 59));
        jTxtPlayers.setHorizontalAlignment(JTextField.CENTER);
        jTxtPlayers.setBorder(null);
        GridBagConstraints gridBagConstraintsPlayers = new GridBagConstraints();
        gridBagConstraintsPlayers.gridx = 2;
        gridBagConstraintsPlayers.gridy = 1;
        gridBagConstraintsPlayers.weightx = 1.0;
        gridBagConstraintsPlayers.fill = GridBagConstraints.BOTH;
        jPanelServer.add(jTxtPlayers, gridBagConstraintsPlayers);

        GridBagConstraints gridBagConstraintsEdit = new GridBagConstraints();
        gridBagConstraintsEdit.gridx = 3;
        gridBagConstraintsEdit.gridy = 0;
        gridBagConstraintsEdit.fill = GridBagConstraints.HORIZONTAL;
        jBtnEdit.setHorizontalAlignment(JTextField.CENTER);
        jPanelServer.add(jBtnEdit, gridBagConstraintsEdit);

        jBtnDelete.addActionListener((java.awt.event.ActionEvent evt) -> {
            jBtnDeleteActionPerformed(ipServerPort, jPanelServer);
        });
        jBtnDelete.setHorizontalAlignment(JTextField.CENTER);
        GridBagConstraints gridBagConstraintsDelete = new GridBagConstraints();
        gridBagConstraintsDelete.gridx = 3;
        gridBagConstraintsDelete.gridy = 1;
        gridBagConstraintsDelete.fill = GridBagConstraints.HORIZONTAL;
        jPanelServer.add(jBtnDelete, gridBagConstraintsDelete);

        jPnlInfo.add(jPanelServer);
        jPnlInfo.revalidate();
        jPnlInfo.repaint();
    }

    private void jBtnDeleteActionPerformed(String ipString, JPanel panel) {
        if (!database.deleteRow(ipString)) {
            JOptionPane.showMessageDialog(null, "Non Server Found", "An error occurred", JOptionPane.WARNING_MESSAGE);
        } else {
            deletePanelServer(panel);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIntroAdd;
    private javax.swing.JLabel jLblLoading;
    private javax.swing.JPanel jPnlInfo;
    private javax.swing.JPanel jPnlIntro;
    private javax.swing.JPanel jPnlIntroInfo;
    private javax.swing.JPanel jPnlMain;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
