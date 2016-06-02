package edu.ctpositivo.trabalho;

import edu.ctpositivo.scanner.Input;
import edu.ctpositivo.trabalho.dao.*;
import edu.ctpositivo.trabalho.controller.*;

class Main{
  private static ProdutoDAO produtoDao;

  public static final void main(String[] args){
    Input entrada = new Input();

    ProdutosController.seed();

    while(true){
      imprimirMenu();
      try{
        escolherOpcao(entrada.readInt("Digite uma opção:"), entrada);
      }catch(CanceladoPeloUsuarioException e){
        break;
      }
    }
    System.out.println("Tchau!");
  }

  public static final void escolherOpcao(int indice, Input entrada) throws CanceladoPeloUsuarioException{
    switch(indice){
      case 0: //Sair
        throw new CanceladoPeloUsuarioException();
      case 1: //Nova comanda
        ProdutosController.listar();
        ComandasController.nova(entrada);
        break;
      case 2: //Listar comandas
        ComandasController.listar();
        break;
      case 3: //Detalhes da comanda
        ComandasController.mostrar(entrada.readInt("Digite o número da comanda para exibir"));
        break;
      case 4: //Cancelar comanda
        ComandasController.excluir(entrada.readInt("Digite o número da comanda para cancelar"));
        break;
      case 5: //Total de vendas
        ReportsController.vendas();
        break;
      default:
        System.out.println("Opção inválida");
    }
    entrada.pause("Pressione <enter> para continuar");
  }

  public static final void imprimirMenu(){
    System.out.println("------ MENU PRINCIPAL ------");
    System.out.println("1. Nova comanda");
    System.out.println("2. Listar comandas");
    System.out.println("3. Detalhes da comanda");
    System.out.println("4. Cancelar comanda");
    System.out.println("5. Total de vendas");
    System.out.println("");
    System.out.println("0. Sair");
    System.out.println("----------------------------");
  }
}