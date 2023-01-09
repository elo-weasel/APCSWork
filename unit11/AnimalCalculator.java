import java.util.*;

public class AnimalCalculator{
  public static void main(String[] args){
    ArrayList<Animal> as = new ArrayList<Animal>();
    Hawk h = new Hawk("hawk", 2, false);
    Grasshopper gr = new Grasshopper("grasshopper", 6, false);
    Borzoi b = new Borzoi("borzoi", 4, true);
    Giraffe gi = new Giraffe("giraffe", 4, false);

    as.add(h);
    as.add(gr);
    as.add(b);
    as.add(gi);

    printAnimals(as);
    System.out.println();
    testAverageLegs(4, averageLegs(as));
    System.out.println();
    testFewestLegs("hawk", fewestLegs(as));
  }

  public static void printAnimals(ArrayList<Animal> as){
    for(Animal a : as){
      System.out.println("animal: " + a.getName() + " | legs: " + a.getLegCount() + " | furry? " + a.getFurriness());
    }
  }

  public static float averageLegs(ArrayList<Animal> as){
    float result = 0;
    for (Animal a : as){
      result += a.getLegCount();
    }
    return result/as.size();
  }

  public static void testAverageLegs(float expected, float result){
    System.out.println("average legs: ");
    System.out.print("expected: " + expected + " | result: " + result);
    if(expected == result){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }

  public static String fewestLegs(ArrayList<Animal> as){
    String fName = as.get(0).getName();
    int fLegs = as.get(0).getLegCount();
    for(Animal a : as){
      if(a.getLegCount() < fLegs){
        fLegs = a.getLegCount();
        fName = a.getName();
      }
    }
    return fName;
  }

  public static void testFewestLegs(String expected, String result){
    System.out.println("fewest legs: ");
    System.out.print("expected: " + expected + " | result: " + result);
    if(expected.equals(result)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
