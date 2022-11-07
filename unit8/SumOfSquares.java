import java.util.*;

class SumOfSquares{
  public static void main(String[] args){
    ArrayList<Double> n1 = new ArrayList<Double>();
    n1.add(1.0);
    n1.add(2.0);
    n1.add(3.0);
    n1.add(4.0);
    ArrayList<Double> n2 = new ArrayList<Double>();
    n2.add(9.0);
    n2.add(2.0);
    n2.add(0.0);
    ArrayList<Double> n3 = new ArrayList<Double>();
    n3.add(6.0);
    n3.add(2.0);

    test(n1, 30);
    test(n2, 85);
    test(n3, 40);
  }

  public static double sum(ArrayList<Double> nums){
    double result = 0;
    for (double n: nums){
      result += n*n;
    }
    return result;
  }

  public static void test(ArrayList<Double> nums, double expected){
    System.out.println("numbers: ");
    for(double n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + sum(nums));
    if(sum(nums) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
