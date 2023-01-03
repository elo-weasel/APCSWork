import java.util.*;

class ItemCalculator{
  public static void main(String[] args){
    ArrayList<Item> items = new ArrayList<Item>();
    Item i1 = new Item("milk", (float)5.99);
    items.add(i1);
    Item i2 = new Item("bread", (float)11.45);
    items.add(i2);
    Item i3 = new Item("cheese", (float)13.55);
    items.add(i3);
    Item i4 = new Item("candle", (float)8.99);
    items.add(i4);

    System.out.println("ITEMS:");
    printItems(items);
    System.out.println();
    System.out.println("average price: " + avgPrices(items));
    System.out.println("highest price: " + highPrice(items));
  }

  public static void printItems(ArrayList<Item> items){
    for(Item i : items){
      System.out.println(i.getName() + " | price: " + i.getPrice());
    }
  }

  public static float avgPrices(ArrayList<Item> items){
    float sum = 0;
    for(Item i : items){
      sum += i.getPrice();
    }
    return sum/items.size();
  }

  public static String highPrice(ArrayList<Item> items){
    float currentHigh = 0;
    String highName = "";
    for(Item i : items){
      if(i.getPrice() > currentHigh){
        currentHigh = i.getPrice();
        highName = i.getName();
      }
    }
    return highName;
  }
}
