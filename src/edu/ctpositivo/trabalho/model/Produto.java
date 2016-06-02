package edu.ctpositivo.trabalho.model;

public class Produto implements IModel{
  public enum Tipo{
    BEBIDA, COMIDA, SOBREMESA;

    public String getDescricao(){
      switch(this){
        case BEBIDA:
          return "Bebida";
        case COMIDA:
          return "Comida";
        case SOBREMESA:
          return "Sobremesa";
      }
      return "Outros";
    }
  }

  private int id;
  private String nome;
  private Tipo tipo;
  private double valor;

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }

  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }

  public Tipo getTipo(){
    return tipo;
  }
  public void setTipo(Tipo tipo){
    this.tipo = tipo;
  }

  public double getValor(){
    return valor;
  }
  public void setValor(double valor){
    this.valor = valor;
  }

  public void copy(IModel model){
    Produto local = (Produto)model;
    this.id = local.getId();
    this.nome = local.getNome();
    this.tipo = local.getTipo();
    this.valor = local.getValor();
  }
  public IModel clone(){
    Produto model = new Produto();
    model.setId(id);
    model.setNome(nome);
    model.setTipo(tipo);
    model.setValor(valor);
    return model;
  }
}