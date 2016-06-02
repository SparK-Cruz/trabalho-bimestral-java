package edu.ctpositivo.trabalho.controller;

import java.util.List;
import edu.ctpositivo.scanner.Input;
import edu.ctpositivo.trabalho.dao.*;
import edu.ctpositivo.trabalho.model.*;

public class ComandasController{
  private static ComandaDAO comandaDao = new ComandaDAO();
  private static ItemComandaDAO itemDao = new ItemComandaDAO();
  private static ProdutoDAO produtoDao = new ProdutoDAO();

  public static final void nova(Input entrada){
    Comanda model = new Comanda();

    int idProduto = 0;
    while((idProduto = entrada.readInt("Digite um código de produto ou 0 para finalizar o pedido")) != 0){
      Produto produto = null;
      try{
        produto = produtoDao.findById(idProduto);
      }catch(Exception e){
        System.out.println("Produto inválido");
        continue;
      }

      ItemComanda item = new ItemComanda();
      item.setIdProduto(idProduto);
      System.out.println(produto.getNome());

      int quantidade = 0;
      while((quantidade = entrada.readInt("Digite uma quantidade")) <= 0){
        System.out.println("A quantidade deve ser maior que 0");
      }
      item.setQuantidade(quantidade);

      if(comandaDao.isNew(model))
        comandaDao.create(model);

      item.setIdComanda(model.getId());
      itemDao.create(item);
      System.out.println(item.getQuantidade() * produto.getValor());
    }

    System.out.println("----------------");
    System.out.println(String.format("Comanda número: %d", model.getId()));
    System.out.println("----------------");
  }

  public static final void listar(){
    List<Comanda> comandas = comandaDao.all();

    String idList = "";
    System.out.println("--- Comandas ---");
    System.out.println(String.format("%s\t%s\t%s",
      "Código", "Itens", "Total"));
    for(Comanda comanda : comandas){
      mostrarLinha(comanda);
    }
    System.out.println(String.format("Total de comandas: %d", comandas.size()));
  }

  public static final void mostrar(int id){
    Comanda model = null;
    try{
      model = comandaDao.findById(id);
    }catch(Exception e){
      System.out.println("Comanda inválida");
      return;
    }

    int indice = 1;
    double total = 0;
    List<ItemComanda> itens = itemDao.findByIdComanda(id);

    System.out.println(String.format("------ Comanda nº %d ------", model.getId()));
    System.out.println(String.format("%3s\t%s\t%10s\t%9s\t%s\t%s\t%s",
      "", "código", "nome", "tipo", "preço", "qtd", "total"));
    for(ItemComanda item : itens){
      mostrarItem(indice++, item);
      try{
        total += item.getTotal();
      }catch(Exception e){
        //Produto inválido?
      }
    }
    System.out.println("--------------------------");
    System.out.println(String.format("Total: %.2f",
      total));
  }
  public static final void excluir(int id){
    Comanda model = null;
    try{
      model = comandaDao.findById(id);
    }catch(Exception e){
      System.out.println("Comanda inválida");
      return;
    }

    comandaDao.delete(id);
    System.out.println("Comanda cancelada com sucesso");
  }

  //private

  private static final void mostrarLinha(Comanda comanda){
    System.out.println(String.format("%d\t%d\t%.2f",
      comanda.getId(), comanda.getItens().size(), comanda.getTotal()));
  }
  private static final void mostrarItem(ItemComanda item){
    mostrarItem(0, item);
  }
  private static final void mostrarItem(int indice, ItemComanda item){
    Produto produto = null;
    try{
      produto = item.getProduto();

      if(indice <= 0){
        System.out.println(String.format("%d\t%10s\t%9s\t%.2f\t%d\t%.2f",
          produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor(), item.getQuantidade(), item.getTotal()));
        return;
      }

      System.out.println(String.format("%d\t%d\t%10s\t%9s\t%.2f\t%d\t%.2f",
        indice, produto.getId(), produto.getNome(), produto.getTipo().getDescricao(), produto.getValor(), item.getQuantidade(), item.getTotal()));

    }catch(Exception e){
      System.out.println("Produto inválido");
      return;
    }
  }
}