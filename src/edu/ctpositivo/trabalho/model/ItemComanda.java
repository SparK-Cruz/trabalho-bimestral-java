package edu.ctpositivo.trabalho.model;

import edu.ctpositivo.trabalho.dao.ProdutoDAO;

public class ItemComanda implements IModel{
  private int id;
  private int idComanda;
  private int idProduto;
  private int quantidade;

  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }

  public int getIdComanda(){
    return idComanda;
  }
  public void setIdComanda(int idComanda){
    this.idComanda = idComanda;
  }

  public int getIdProduto(){
    return idProduto;
  }
  public void setIdProduto(int idProduto){
    this.idProduto = idProduto;
  }

  public int getQuantidade(){
    return quantidade;
  }
  public void setQuantidade(int quantidade){
    this.quantidade = quantidade;
  }

  public void copy(IModel model){
    ItemComanda local = (ItemComanda)model;
    this.id = local.getId();
    this.idComanda = local.getIdComanda();
    this.idProduto = local.getIdProduto();
    this.quantidade = local.getQuantidade();
  }
  public IModel clone(){
    ItemComanda model = new ItemComanda();
    model.setId(id);
    model.setIdComanda(idComanda);
    model.setIdProduto(idProduto);
    model.setQuantidade(quantidade);
    return model;
  }

  public Produto getProduto() throws Exception{
    ProdutoDAO produtoDao = new ProdutoDAO();
    return produtoDao.findById(getIdProduto());
  }

  public double getTotal() throws Exception{
    return getProduto().getValor() * getQuantidade();
  }
}