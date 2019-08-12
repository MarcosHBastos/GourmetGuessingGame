/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.objective.view;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class ViewUtil {

    public ViewUtil() {
    }

    public boolean confirmacao(String mensagem, String titulo) {
        String[] opt = {"Sim", "Não"};
        int resp = JOptionPane.showOptionDialog(null, mensagem, titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opt, opt[0]);
        return resp == 0;
    }

    public void adivinhou() {
        JOptionPane.showMessageDialog(null, "Acertei!");
    }

    public String getEntrada(String mensagem, String titulo) {
        return JOptionPane.showInputDialog(null, mensagem, titulo, 0);
    }
    
}
