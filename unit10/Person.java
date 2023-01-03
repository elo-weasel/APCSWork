public class Person{
  public Person(String name, int pets){
    this.name = name;
    this.pets = pets;
  }

  public String getName(){
    return name;
  }

  public float getPets(){
    return pets;
  }

  private String name;
  private int pets;
}
