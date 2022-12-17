/*
 * Copyright (C) 2022 Breno Vambaster C. L
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.mycompany.adotapet.gui;

import com.mycompany.adotapet.gui.CadastroPet;
import com.mycompany.adotapet.gui.CadastroVoluntario;
import com.mycompany.adotapet.voluntario.Voluntario;

/**
 *
 * @author Breno Vambaster C. L
 */
public class PrincipalVoluntario extends javax.swing.JFrame {

    private Voluntario voluntario;

    /**
     * Creates new form PrincipalVoluntario
     */
    public PrincipalVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
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

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuRequerimentos = new javax.swing.JMenu();
        mnuCadastroPet = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        mnuRequerimentos.setText("Requerimentos");
        mnuRequerimentos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuRequerimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuRequerimentosMouseClicked(evt);
            }
        });
        mnuRequerimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRequerimentosActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuRequerimentos);

        mnuCadastroPet.setText("Cadastrar Pet");
        mnuCadastroPet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuCadastroPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCadastroPetMouseClicked(evt);
            }
        });
        mnuCadastroPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastroPetActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuCadastroPet);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCadastroPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastroPetActionPerformed

    }//GEN-LAST:event_mnuCadastroPetActionPerformed

    private void mnuRequerimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRequerimentosActionPerformed

    }//GEN-LAST:event_mnuRequerimentosActionPerformed

    private void mnuRequerimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuRequerimentosMouseClicked
        Requerimento.getInstance(voluntario).setVisible(true);
    }//GEN-LAST:event_mnuRequerimentosMouseClicked

    private void mnuCadastroPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCadastroPetMouseClicked
        CadastroPet.getInstance(voluntario.getLarTemporario()).setVisible(true);
    }//GEN-LAST:event_mnuCadastroPetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mnuCadastroPet;
    private javax.swing.JMenu mnuRequerimentos;
    // End of variables declaration//GEN-END:variables
}