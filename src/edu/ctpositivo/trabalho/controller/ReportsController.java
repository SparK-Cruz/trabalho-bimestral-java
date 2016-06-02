package edu.ctpositivo.trabalho.controller;

import java.util.List;
import edu.ctpositivo.trabalho.model.Comanda;
import edu.ctpositivo.trabalho.dao.ComandaDAO;

public class ReportsController{
  public static final void vendas(){
    int size = 0;
    int lastId = 0;
    double total = 0;

    ComandaDAO comandaDao = new ComandaDAO();
    List<Comanda> comandas = comandaDao.all();

    size = comandas.size();
    lastId = comandaDao.getLastId();

    for(Comanda comanda : comandas){
      total += comanda.getTotal();
    }

    System.out.println("------ Resumo geral ------");
    System.out.println(String.format("Vendas feitas: %d", size));
    System.out.println(String.format("Vendas canceladas: %d", lastId - size));
    System.out.println(String.format("Total de entrada: %.2f", total));
    System.out.println("--------------------------");
  }
}