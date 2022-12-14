/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.adotapet.repositorio;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * Classe MyJTextField
 * @author pedro
 */
public class MyJTextField extends JTextField{
    private Color corPadrao;
    private Color corFoco;

    public MyJTextField(Color corPadrao, Color corFoco) {
        this.corPadrao = corPadrao;
        this.corFoco = corFoco;
        addFocusListener(new FocusHandler());
    }

    public MyJTextField() {
        this(new Color(255,255,255),new Color(255,255,175));
    }

    public Color getCorPadrao() {
        return corPadrao;
    }

    public void setCorPadrao(Color corPadrao) {
        this.corPadrao = corPadrao;
    }

    public Color getCorFoco() {
        return corFoco;
    }

    public void setCorFoco(Color corFoco) {
        this.corFoco = corFoco;
    }
    
    public void alternarCor(){
        this.setBackground(this.getBackground() == corFoco ? corPadrao : corFoco);
    }
    
    //classe interna
    class FocusHandler implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            selectAll();
            alternarCor();
        }

        @Override
        public void focusLost(FocusEvent e) {
            alternarCor();
        }
        
    }
}
