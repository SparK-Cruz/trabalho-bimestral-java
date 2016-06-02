package edu.ctpositivo.trabalho.dao;

import java.util.List;
import edu.ctpositivo.trabalho.model.Comanda;

public class ComandaDAO extends BaseDAO<Comanda>{
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

  public int getLastId(){
    return nextId - 1;
  }
}