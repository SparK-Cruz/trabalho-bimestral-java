package edu.ctpositivo.scanner;

import java.util.Scanner;

public class Input{
  private Scanner scanner;

  public Input(){
    this.scanner = new Scanner(System.in);
  }
  public Input(Scanner scanner){
    this.scanner = scanner;
  }

  public String read(String prompt){
    System.out.println(prompt);
    return this.scanner.nextLine();
  }
  public double readDouble(String prompt){
    while(true){
      System.out.println(prompt);
      try{
        return Double.parseDouble(this.scanner.nextLine());
      }catch(NumberFormatException ex){
        //loop
      }
    }
  }
  public int readInt(String prompt){
    while(true){
      System.out.println(prompt);
      try{
        return Integer.parseInt(this.scanner.nextLine());
      }catch(NumberFormatException ex){
        //loop
      }
    }
  }
  public void pause(String prompt){
    System.out.println(prompt);
    this.scanner.nextLine();
  }
}
