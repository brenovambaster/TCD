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

import com.mycompany.adotapet.credencial.Credencial;
import com.mycompany.adotapet.credencial.CredencialDAO;
import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.telefone.TelefoneDAO;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;
import com.mycompany.adotapet.voluntario.Voluntario;
import com.mycompany.adotapet.voluntario.VoluntarioDAO;
import java.awt.Component;
import java.awt.SystemColor;
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
public class CadastroVoluntario extends javax.swing.JFrame {

    private static CadastroVoluntario instance;
    private final DefaultComboBoxModel<TipoLogradouro> boxModel
            = new DefaultComboBoxModel<>();

    /**
     * Creates new form CadastrarTutor
     */
    public CadastroVoluntario() {
        initComponents();
        cboTipoLogradouro.setModel(boxModel);
        cboTipoLogradouro.setRenderer(new TipoLogradouroRender());
        boxModel.addAll(new TipoLogradouroDAO().findAll());

        try {
            cboTipoLogradouro.setSelectedIndex(0);
        } catch (Exception ex) {
            System.out.println(">> " + ex.getMessage());
        }
    }

    public static CadastroVoluntario getInstance() {
        if (instance == null) {
            instance = new CadastroVoluntario();
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

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblEndereco = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new com.mycompany.adotapet.repositorio.MyJTextField();
        cboTipoLogradouro = new javax.swing.JComboBox<>();
        lblTipoLogradouro = new javax.swing.JLabel();
        lblEnderecoNumero = new javax.swing.JLabel();
        txtBairro = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblBairro = new javax.swing.JLabel();
        txtEnderecoNumero = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblComplemento = new javax.swing.JLabel();
        txtComplemento = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblCep = new javax.swing.JLabel();
        txtCep = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblTelefone = new javax.swing.JLabel();
        lblDdd = new javax.swing.JLabel();
        txtDDD = new com.mycompany.adotapet.repositorio.MyJTextField();
        lblTelefoneNumero = new javax.swing.JLabel();
        txtTelefoneNumero = new com.mycompany.adotapet.repositorio.MyJTextField();
        ckbMensagem = new javax.swing.JCheckBox();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        txtNome.setText("a");

        lblEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setText("b");

        lblCpf.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblCpf.setText("CPF:");

        txtCpf.setText("1");

        lblSenha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSenha.setText("Senha:");

        txtSenha.setText("1");

        lblEndereco.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblLogradouro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblLogradouro.setText("Logradouro:");

        txtLogradouro.setText("c");

        lblTipoLogradouro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTipoLogradouro.setText("Tipo Logradouro:");

        lblEnderecoNumero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEnderecoNumero.setText("Número:");

        txtBairro.setText("d");

        lblBairro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblBairro.setText("Bairro:");

        txtEnderecoNumero.setText("4");

        lblComplemento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblComplemento.setText("Complemento:");

        txtComplemento.setText("e");

        lblEstado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEstado.setText("Estado:");

        txtEstado.setText("g");

        lblCidade.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblCidade.setText("Cidade:");

        txtCidade.setText("f");

        lblCep.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblCep.setText("CEP:");

        txtCep.setText("5");

        lblTelefone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone:");

        lblDdd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblDdd.setText("DDD:");

        txtDDD.setText("23");

        lblTelefoneNumero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTelefoneNumero.setText("Número:");

        txtTelefoneNumero.setText("45666");

        ckbMensagem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ckbMensagem.setText("Mensagem");

        btnCadastrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSenha)
                            .addComponent(lblCpf)
                            .addComponent(lblEmail)
                            .addComponent(lblNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLogradouro)
                                    .addComponent(lblBairro)
                                    .addComponent(lblComplemento)
                                    .addComponent(lblCidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblTipoLogradouro)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblEnderecoNumero))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(lblEstado))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(lblCep)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtEnderecoNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblDdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelefoneNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefoneNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ckbMensagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogradouro)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoLogradouro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnderecoNumero)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(txtEnderecoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTelefone)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDdd)
                    .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefoneNumero)
                    .addComponent(txtTelefoneNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbMensagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            Endereco endereco = new Endereco();
            endereco.setTipoLogradouro((TipoLogradouro) cboTipoLogradouro.getSelectedItem());
            endereco.setBairro(txtBairro.getText());
            endereco.setLogadouro(txtLogradouro.getText());
            endereco.setCep(Integer.parseInt(txtCep.getText()));
            endereco.setNumero(Integer.parseInt(txtEnderecoNumero.getText()));
            endereco.setCidade(txtCidade.getText());
            endereco.setComplemento(txtComplemento.getText());
            endereco.setEstado(txtEstado.getText());
            System.out.println("> " + endereco);

            Telefone telefone = new Telefone();
            telefone.setDDD(Short.parseShort(txtDDD.getText()));
            telefone.setNumero(Integer.parseInt(txtTelefoneNumero.getText()));
            telefone.setMensagem(ckbMensagem.isSelected());
            System.out.println("> " + telefone);

            Credencial credencial = new Credencial();
            credencial.setEmail(txtEmail.getText());
            credencial.setSenha(txtSenha.getText());
            System.out.println("> " + credencial);

            Voluntario voluntario = new Voluntario();
            voluntario.setNome(txtNome.getText());
            voluntario.setCpf(Long.parseLong(txtCpf.getText()));
            Voluntario.validarUsuario(voluntario);
            Telefone.validarTelefone(telefone);
            Credencial.validarCredencial(credencial);
            voluntario.setTelefone(telefone);;
            voluntario.setEndereco(endereco);
            voluntario.setCredencial(credencial);
            System.out.println("> " + voluntario);

            endereco.setId(new EnderecoDAO().saveOrUpdate(endereco));
            telefone.setId(new TelefoneDAO().saveOrUpdate(telefone));
            voluntario.setId(new VoluntarioDAO().saveOrUpdate(voluntario));
            credencial.setUsuario(voluntario);
            new CredencialDAO().SaveVoluntario(credencial, voluntario);

            dispose();
        } catch (Exception ex) {
            JComponent component = null;

            switch (ex.getStackTrace()[0].getMethodName()) {
                case "setBairro":
                    component = txtBairro;
                    break;
                case "setLogradouro":
                    component = txtLogradouro;
                    break;
                case "setCidade":
                    component = txtCidade;
                    break;
                case "setComplemento":
                    component = txtComplemento;
                    break;
                case "setEstado":
                    component = txtEstado;
                    break;
                case "setEmail":
                    component = txtEmail;
                    break;
                case "setNome":
                    component = txtLogradouro;
                    break;
                case "validarCredencial":
                    component = txtEmail;
                    break;
                case "validarTelefone":
                    component = txtTelefoneNumero;
                    break;
                case "validarUsuario":
                    component = txtCpf;
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

    private class TipoLogradouroRender
            extends JLabel
            implements ListCellRenderer<TipoLogradouro> {

        @Override
        public Component getListCellRendererComponent(
                JList<? extends TipoLogradouro> list, TipoLogradouro value,
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
            java.util.logging.Logger.getLogger(CadastroVoluntario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVoluntario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVoluntario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVoluntario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroVoluntario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<TipoLogradouro> cboTipoLogradouro;
    private javax.swing.JCheckBox ckbMensagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDdd;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEnderecoNumero;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefoneNumero;
    private javax.swing.JLabel lblTipoLogradouro;
    private com.mycompany.adotapet.repositorio.MyJTextField txtBairro;
    private com.mycompany.adotapet.repositorio.MyJTextField txtCep;
    private com.mycompany.adotapet.repositorio.MyJTextField txtCidade;
    private com.mycompany.adotapet.repositorio.MyJTextField txtComplemento;
    private com.mycompany.adotapet.repositorio.MyJTextField txtCpf;
    private com.mycompany.adotapet.repositorio.MyJTextField txtDDD;
    private com.mycompany.adotapet.repositorio.MyJTextField txtEmail;
    private com.mycompany.adotapet.repositorio.MyJTextField txtEnderecoNumero;
    private com.mycompany.adotapet.repositorio.MyJTextField txtEstado;
    private com.mycompany.adotapet.repositorio.MyJTextField txtLogradouro;
    private com.mycompany.adotapet.repositorio.MyJTextField txtNome;
    private com.mycompany.adotapet.repositorio.MyJTextField txtSenha;
    private com.mycompany.adotapet.repositorio.MyJTextField txtTelefoneNumero;
    // End of variables declaration//GEN-END:variables
}
