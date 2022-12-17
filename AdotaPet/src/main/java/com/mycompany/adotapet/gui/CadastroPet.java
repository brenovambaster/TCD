/*
 * Copyright (C) 2022 Pedro Dias
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

import com.mycompany.adotapet.larTemporario.LarTemporario;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.pet.PetDAO;
import com.mycompany.adotapet.raca.Raca;
import com.mycompany.adotapet.raca.RacaDAO;
import java.awt.Component;
import java.awt.SystemColor;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

/**
 *
 * @author pedro
 */
public class CadastroPet extends javax.swing.JFrame {

    private static CadastroPet instance;
    private LarTemporario lartemporario;
    private final DefaultComboBoxModel<Raca> boxModel
            = new DefaultComboBoxModel<>();

    /**
     * Creates new form CadastroPet
     */
    public CadastroPet(LarTemporario lartemporario) {
        initComponents();
        cboRaca.setModel(boxModel);
        this.lartemporario = lartemporario;
        cboRaca.setRenderer(new CadastroPet.racaRender());
        boxModel.addAll(new RacaDAO().findAll());

        try {
            cboRaca.setSelectedIndex(0);
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }

    public static CadastroPet getInstance(LarTemporario lar) {
        if (instance == null) {
            instance = new CadastroPet(lar);
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblRaca = new javax.swing.JLabel();
        cboRaca = new javax.swing.JComboBox<>();
        lbl = new javax.swing.JLabel();
        txtNascimento = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblComentario = new javax.swing.JLabel();
        txtComentario = new com.mycompany.adotapet.repositorio.MyJTextField();
        cbkMacho = new javax.swing.JCheckBox();
        cbkCastrado = new javax.swing.JCheckBox();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblRaca.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblRaca.setText("Raca:");

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl.setText("Nascimento:");

        lblPeso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblPeso.setText("Peso:");

        lblComentario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblComentario.setText("Comentario:");

        cbkMacho.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbkMacho.setText("Macho");

        cbkCastrado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbkCastrado.setText("Castrado");

        btnCadastrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastrar)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRaca)
                            .addComponent(lbl)
                            .addComponent(lblNome)
                            .addComponent(lblPeso)
                            .addComponent(lblComentario))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(cboRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbkMacho)
                                .addGap(18, 18, 18)
                                .addComponent(cbkCastrado)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComentario)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRaca)
                        .addComponent(cboRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbkMacho))
                    .addComponent(cbkCastrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            Pet pet = new Pet();
            pet.setNome(txtNome.getText());
            pet.setComentario(txtComentario.getText());
            pet.setCastrado(cbkCastrado.isSelected());
            pet.setMacho(cbkMacho.isSelected());
            pet.setPeso(Float.parseFloat(txtPeso.getText()));
            pet.setNascimento(LocalDate.parse(txtNascimento.getText()));
            pet.setLarTemporario(lartemporario);
            pet.setRaca((Raca) cboRaca.getSelectedItem());
            new PetDAO().saveOrUpdate(pet);
            dispose();
        } catch (Exception ex) {
            JComponent component = null;

            switch (ex.getStackTrace()[0].getMethodName()) {
                case "setNome":
                    component = txtNome;
                    break;
                case "setComentario":
                    component = txtComentario;
                    break;
                default:
                    throw new AssertionError();
            }
            JOptionPane.showMessageDialog(this, ex.getMessage());

            if (component instanceof JTextField) {
                ((JTextField) component).selectAll();
                component.requestFocus();
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private class racaRender
            extends JLabel
            implements ListCellRenderer<Raca> {

        @Override
        public Component getListCellRendererComponent(
                JList<? extends Raca> list, Raca value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (value == null) {
                return this;
            }

            setOpaque(true);
            setForeground(SystemColor.textText);
            setBackground(SystemColor.text);
            if (isSelected) {
                setForeground(SystemColor.textHighlightText);
                setBackground(SystemColor.textHighlight);
            }

            // The value to be rendered on the combo box
            setText(value.getNome());

            setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 1));
            return this;
        }

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JCheckBox cbkCastrado;
    private javax.swing.JCheckBox cbkMacho;
    private javax.swing.JComboBox<Raca> cboRaca;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JPanel pnlPrincipal;
    private com.mycompany.adotapet.repositorio.MyJTextField txtComentario;
    private com.mycompany.adotapet.repositorio.MyJTextField txtNascimento;
    private com.mycompany.adotapet.repositorio.MyJTextField txtNome;
    private com.mycompany.adotapet.repositorio.MyJTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
