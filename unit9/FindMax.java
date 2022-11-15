import java.util.*;

public class FindMax{
  public static void main(String args[]){
    ArrayList<Double> n1 = new ArrayList<Double>();
    n1.add(1.0);
    n1.add(2.7);
    n1.add(6.2);
    n1.add(7.1);
    ArrayList<Double> n2 = new ArrayList<Double>();
    n2.add(49.8);
    n2.add(2.7);
    n2.add(6.3);
    ArrayList<Double> n3 = new ArrayList<Double>();
    n3.add(9.0);
    n3.add(3.7);
    n3.add(5.3);

    testFindMax(n1, 7.1);
    testFindMax(n2, 49.8);
    testFindMax(n3, 9.0);
  }

  public static double findMax(ArrayList<Double> nums){
    double result = nums.get(0);
    for(double n: nums){
      if (n > result){
        result = n;
      }
    }
    return result;
  }

  public static void testFindMax(ArrayList<Double> nums, double expected){
    System.out.println("numbers: ");
    for(double n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + findMax(nums));
    if(findMax(nums) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
