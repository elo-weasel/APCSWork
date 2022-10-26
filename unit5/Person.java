public class Person{
  private String name;
  private int pets;

  public Person(String nameIn, int petsIn){
    name = nameIn;
    pets = petsIn;
  }

  public String getName(){
    return name;
  }

  public int getPets(){
    return pets;
  }

  public String greeting(){
    return "Hello, my name is " + name + " and I have " + pets + " pet(s).";
  }
}
