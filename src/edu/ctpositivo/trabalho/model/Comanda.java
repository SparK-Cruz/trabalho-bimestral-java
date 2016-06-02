package edu.ctpositivo.trabalho.model;

import java.util.List;
import edu.ctpositivo.trabalho.dao.ItemComandaDAO;

public class Comanda implements IModel{
  private int id;
  private double total;

  public void setId(int id){
    this.id = id;
  }
  public int getId(){
    return id;
  }

  public List<ItemComanda> getItens(){
    ItemComandaDAO itemDao = new ItemComandaDAO();
    return itemDao.findByIdComanda(getId());
  }
  public double getTotal(){
    if(total > 0)
      return total;

    List<ItemComanda> itens = getItens();
    for(ItemComanda item : itens){
      try{
        total += item.getTotal();
      }catch(Exception e){
        //Produto inválido?
      }
    }
    return total;
  }

  public void copy(IModel model){
    Comanda local = (Comanda)model;
    this.id = local.getId();
  }
  public IModel clone(){
    Comanda model = new Comanda();
    model.setId(id);
    return model;
  }
}