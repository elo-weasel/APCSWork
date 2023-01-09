import java.util.*;

public class VehicleStats{
  public static void main(String[] args){
    ArrayList<Vehicle> vs = new ArrayList<Vehicle>();

    Car c1 = new Car();
    Car c2 = new Car();

    Motorcycle m1 = new Motorcycle();

    Bicycle b1 = new Bicycle();
    Bicycle b2 = new Bicycle();
    Bicycle b3 = new Bicycle();

    Unicycle u1 = new Unicycle();

    vs.add(c1);
    vs.add(c2);
    vs.add(m1);
    vs.add(b1);
    vs.add(b2);
    vs.add(b3);
    vs.add(u1);

    System.out.println("vehicles:");
    for(Vehicle v : vs){
      System.out.println("vehicle type: " + v.name() + " | # of wheels: " + v.wheelCount() + " | human powered? " + v.isHumanPowered());
    }
    System.out.println();
    testTotalWheelCount(17, totalWheelCount(vs));
    System.out.println();
    System.out.println("human powered vehicles:");
    ArrayList<Vehicle> hvs = humanPowered(vs);
    for (Vehicle v : hvs){
      System.out.println(v.name());
    }
  }

  public static int totalWheelCount(ArrayList<Vehicle> vs){
    int result = 0;
    for(Vehicle v : vs)
      result += v.wheelCount();
    return result;
  }

  public static void testTotalWheelCount(int expected, int result){
    System.out.println("total wheel count:");
    System.out.print("expected: " + expected + " | result: " + result);
    if(expected == result){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }

  public static ArrayList<Vehicle> humanPowered(ArrayList<Vehicle> vs){
    ArrayList<Vehicle> result = new ArrayList<Vehicle>();
    for(Vehicle v : vs){
      if(v.isHumanPowered() == true){
        result.add(v);
      }
    }
    return result;
  }
}
