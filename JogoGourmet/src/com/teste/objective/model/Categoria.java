/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.objective.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class Categoria extends Comida {

    private List<Comida> comidas;

    public Categoria(String descricao) {
        super(descricao);
        comidas = new ArrayList<>();
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public boolean adicionaComida(Comida item) {
        if (!comidas.contains(item)) { //TODO
            comidas.add(item);
            return true;
        }
        return false;
    }
}
