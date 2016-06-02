package edu.ctpositivo.trabalho.dao;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.trabalho.model.ItemComanda;

public class ItemComandaDAO extends BaseDAO<ItemComanda>{
  private static int nextId = 1;
  protected static List<Object> records;

  protected int getNextId(){
    return nextId++;
  }
  protected List<Object> getRecords(){
    return records;
  }
  protected void setRecords(List<Object> list){
    records = list;
  }

  public List<ItemComanda> findByIdComanda(int id){
    List<ItemComanda> localRecords = new ArrayList<ItemComanda>();
    for(Object record : getRecords()){
      ItemComanda local = (ItemComanda)record;
      if(local.getIdComanda() == id)
        localRecords.add((ItemComanda)local.clone());
    }
    return localRecords;
  }
}