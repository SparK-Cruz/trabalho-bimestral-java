package edu.ctpositivo.trabalho.model;

public interface IModel{
  void setId(int id);
  int getId();
  IModel clone();
  void copy(IModel model);
}