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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class Main {

    public static void main(String[] args) {
        List<Comida> menu = new ArrayList<>();
        menu.addAll(getMenu());
        Tela tela = new Tela();
        ViewUtil view = new ViewUtil();
        JogoController controller = new JogoController(menu, tela, view);
        controller.initController();
    }

    private static final List<String> COMIDAS
            = Arrays.asList(new String[]{"cachorro quente", "pizza"});
    private static final List<String> CATEGORIAS
            = Arrays.asList(new String[]{"doce", "massa"});
    private static final List<String> COMIDAS_CAT
            = Arrays.asList(new String[]{"sorvete", "panqueca"});
    private static final List<String[]> SUBCATEGORIAS
            = Arrays.asList(new String[][]{{"confeito", "bolacha"}, {"macarrão", "lasanha"}});
    private static final List<String[]> COMIDAS_SUB_CAT
            = Arrays.asList(new String[][]{
        {"bolo", "brigadeiro"}, {"bolacha recheada", "bolacha maizena"},
        {"macarrão bolonhesa", "macarrão alho e óleo"}, {"lasanha de queijo"}
    });

    /**
     * Monta Array de Comidas e Categorias com os Arrays estáticos declarados
     *
     * @return
     */
    private static List<Comida> getMenu() {
        List<Comida> comidas = new ArrayList<>();
        int i = 0, j = 0;
        for (String desc : CATEGORIAS) {
            Categoria cat = new Categoria(desc);
            
            for (String subDesc : SUBCATEGORIAS.get(i)) {
                Categoria subCat = new Categoria(subDesc);

                for (String descComidaSubCat : COMIDAS_SUB_CAT.get(j)) {
                    subCat.adicionaComida(new Comida(descComidaSubCat));
                }
                cat.adicionaComida(subCat);
                j++;
            }
            cat.adicionaComida(new Comida(COMIDAS_CAT.get(i)));
            comidas.add(cat);
            i++;
        }
        List<Comida> comidasSemCat = new ArrayList<>();
        for (String desc : COMIDAS) {
            comidasSemCat.add(new Comida(desc));
        }
        comidas.addAll(comidasSemCat);
        return comidas;
    }

}
