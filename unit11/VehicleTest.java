import java.util.*;

public class VehicleTest{
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

    for(Vehicle v : vs){
      System.out.println("vehicle type: " + v.name() + " | # of wheels: " + v.wheelCount() + " | human powered? " + v.isHumanPowered());
    }
  }
}
