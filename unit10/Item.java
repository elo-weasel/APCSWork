public class Item{
  public Item(String name, float price){
    this.name = name;
    this.price = price;
  }

  public String getName(){
    return name;
  }

  public float getPrice(){
    return price;
  }

  private String name;
  private float price;
}
