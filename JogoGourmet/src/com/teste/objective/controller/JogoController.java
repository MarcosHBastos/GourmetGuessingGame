/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.objective.controller;

import com.teste.objective.model.Categoria;
import com.teste.objective.model.Comida;
import com.teste.objective.view.Tela;
import com.teste.objective.view.ViewUtil;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class JogoController {

    private final Tela tela;
    private final ViewUtil view;
    private List<Comida> menu;

    public JogoController(List<Comida> menu, Tela tela, ViewUtil view) {
        this.tela = tela;
        this.view = view;
        this.menu = menu;
    }

    public void initController() {
        tela.getComecarButton().addActionListener((ActionEvent evt) -> comecar());
        initView();
    }

    public void initView() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });
    }

    public void comecar() {
        iteraListaComida(menu, "(Sem categoria)");
    }

    public void iteraListaComida(List<Comida> comidas, String categoria) {
        Comida nova = null;
        for (Comida c : comidas) {
            if (view.confirmacao("A comida que você pensou é " + c.getDescricao() + "?", "Acertei?")) {
                if (c instanceof Categoria) {
                    iteraListaComida(((Categoria) c).getComidas(), c.getDescricao());
                } else {
                    view.adivinhou();
                }
                return;
            } else {
                if (comidas.indexOf(c) == comidas.size() - 1) { //Se é a última opção
                    nova = (novaComida(categoria));
                }
            }
        }
        if (nova != null) {
            comidas.add(nova);
        }
    }

    private Comida novaComida(String categoria) {
        String com = view.getEntrada("Qual a comida que você pensou?", "Errei :(");
        if (!view.confirmacao(categoria + " é uma boa classificação para " + com + "?", "O que é?")) {
            String catDesc = view.getEntrada(com + " é um tipo de?", "O que é?");
            Categoria cat = new Categoria(catDesc);
            cat.adicionaComida(new Comida(com));
            return cat;
        } else {
            return new Comida(com);
        }
    }
}
