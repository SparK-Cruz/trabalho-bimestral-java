package edu.ctpositivo.trabalho.controller;

import java.util.List;
import edu.ctpositivo.trabalho.model.Produto;
import edu.ctpositivo.trabalho.dao.ProdutoDAO;

public class ProdutosController{
  public static final void seed(){
    ProdutoDAO dao = new ProdutoDAO();

    Produto p1 = new Produto();
    p1.setNome("Batata");
    p1.setValor(12);
    p1.setTipo(Produto.Tipo.COMIDA);
    dao.create(p1);

    Produto p2 = new Produto();
    p2.setNome("Coca-cola");
    p2.setValor(6);
    p2.setTipo(Produto.Tipo.BEBIDA);
    dao.create(p2);

    Produto p3 = new Produto();
    p3.setNome("Hamburger");
    p3.setValor(15);
    p3.setTipo(Produto.Tipo.COMIDA);
    dao.create(p3);

    Produto p4 = new Produto();
    p4.setNome("Yogurte");
    p4.setValor(2.75);
    p4.setTipo(Produto.Tipo.SOBREMESA);
    dao.create(p4);
  }
  public static final void listar(){
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = dao.all();

    System.out.println("--- Produtos disponíveis ---");
    System.out.println(String.format("%s\t%10s\t%9s\t%s", "Código", "Nome", "Tipo", "Valor"));
    for(Produto produto : produtos){
      System.out.println(String.format("%d\t%10s\t%9s\t%.2f", produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor()));
    }
  }
}