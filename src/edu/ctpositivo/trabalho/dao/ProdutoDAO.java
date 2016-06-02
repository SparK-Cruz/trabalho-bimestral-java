package edu.ctpositivo.trabalho.dao;

import java.util.List;
import edu.ctpositivo.trabalho.model.Produto;

public class ProdutoDAO extends BaseDAO<Produto>{
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
}