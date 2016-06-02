package edu.ctpositivo.trabalho.dao;

import java.util.List;
import java.util.ArrayList;
import edu.ctpositivo.trabalho.model.IModel;

@SuppressWarnings("unchecked")
public abstract class BaseDAO<T extends IModel>{
  protected abstract List<Object> getRecords();
  protected abstract void setRecords(List<Object> list);
  protected abstract int getNextId();

  public BaseDAO(){
    if(getRecords() != null)
      return;

    setRecords(new ArrayList<Object>());
  }

  public void create(T model){
    model.setId(getNextId());
    getRecords().add((Object)model.clone());
  }
  public void update(T model) throws Exception{
    if(model.getId() == 0)
      throw new Exception("Model not tracked (check id)");

    for(Object record : getRecords()){
      IModel local = (IModel)record;
      if(local.getId() != model.getId())
        continue;

      local.copy(model);

      break;
    }
  }
  public T findById(int id) throws Exception{
    for(Object record : getRecords()){
      IModel local = (IModel)record;
      if(local.getId() == id)
        return (T)local.clone();
    }
    throw new Exception("Record not found");
  }
  public ArrayList<T> all(){
    ArrayList<T> localRecords = new ArrayList<>();
    for(Object record : getRecords()){
      localRecords.add((T)((T)record).clone());
    }
    return localRecords;
  }
  public void delete(T model){
    delete(model.getId());
  }
  public void delete(int id){
    for(Object record : getRecords()){
      IModel local = (IModel)record;
      if(local.getId() != id)
        continue;

      getRecords().remove(record);
      break;
    }
  }

  public boolean isNew(T model){
    return model.getId() == 0;
  }
}