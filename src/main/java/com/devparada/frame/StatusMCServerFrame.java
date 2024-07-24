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

import com.devparada.logic.StatusMCServer;
import java.awt.event.ActionEvent;

/**
 *
 * @author devparada
 */
public class StatusMCServerFrame extends javax.swing.JFrame {

    /**
     * Creates new form StatusMCServerFrame
     */
    public StatusMCServerFrame() {
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

        JSclPnl = new javax.swing.JScrollPane();
        jTxtArResult = new javax.swing.JTextArea();
        jLblNameServer = new javax.swing.JLabel();
        jBtnCheck = new javax.swing.JButton();
        jTxtNameServer = new javax.swing.JTextField();
        jLblTxtArResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StatusMCServerTool");

        jTxtArResult.setEditable(false);
        jTxtArResult.setColumns(20);
        jTxtArResult.setRows(5);
        JSclPnl.setViewportView(jTxtArResult);

        jLblNameServer.setText("Server IP (with port if different port):");

        jBtnCheck.setText("Check status");

        jLblTxtArResult.setText("Server status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSclPnl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblTxtArResult, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblNameServer, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNameServer, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jBtnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNameServer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNameServer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jBtnCheck)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLblTxtArResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JSclPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatusMCServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusMCServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusMCServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusMCServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StatusMCServerFrame frame = new StatusMCServerFrame();
                frame.setVisible(true);
                frame.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSclPnl;
    private javax.swing.JButton jBtnCheck;
    private javax.swing.JLabel jLblNameServer;
    private javax.swing.JLabel jLblTxtArResult;
    private javax.swing.JTextArea jTxtArResult;
    private javax.swing.JTextField jTxtNameServer;
    // End of variables declaration//GEN-END:variables

    private void start() {
        final StatusMCServer[] statusServerArrayFinal = new StatusMCServer[1];
        final String[] ipServerArrayFinal = new String[1];

        // Add Listener of the click in the boton JBtnCheck
        jBtnCheck.addActionListener((ActionEvent e) -> {
            if (jTxtNameServer.getText().length() != 0) {
                System.out.println("Test jBtnCheck");
                String[] ipServerArray = jTxtNameServer.getText().split(":");

                String ipServer = ipServerArray[0];
                ipServerArrayFinal[0] = ipServer;

                int port;

                if (ipServerArray.length != 2) {
                    port = 25565; // Default port of the servers
                } else {
                    port = Integer.parseInt(ipServerArray[1]);
                }

                StatusMCServer statusServer = new StatusMCServer(ipServer, port);
                statusServerArrayFinal[0] = statusServer;

                showDataFrame(statusServerArrayFinal[0], ipServerArrayFinal[0]);
            }
        });
    }

    private void showDataFrame(StatusMCServer statusServer, String ipServer) {
        System.out.println("Test showDataFrame");
        if ("0".equals(statusServer.obtainData(ipServer))) {
            jLblTxtArResult.setText("Server status:");
            jTxtArResult.setText("ERROR: Not found this server");
        } else {
            jLblTxtArResult.setText("Server status: " + ipServer);
            jTxtArResult.setText(statusServer.obtainData(ipServer));
        }
    }
}
