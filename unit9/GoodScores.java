import java.util.*;

public class GoodScores{
  public static void main(String args[]){
    ArrayList<Integer> n1 = new ArrayList<Integer>();
    n1.add(40);
    n1.add(60);
    n1.add(92);
    n1.add(100);
    ArrayList<Integer> n2 = new ArrayList<Integer>();
    n2.add(634);
    n2.add(25);
    n2.add(95);
    ArrayList<Integer> n3 = new ArrayList<Integer>();
    n3.add(93);
    n3.add(90);
    n3.add(97);

    ArrayList<Integer> e1 = new ArrayList<Integer>();
    e1.add(92);
    e1.add(100);
    ArrayList<Integer> e2 = new ArrayList<Integer>();
    e2.add(634);
    e2.add(95);
    ArrayList<Integer> e3 = new ArrayList<Integer>();
    e3.add(93);
    e3.add(97);

    testGoodScores(n1, e1);
    testGoodScores(n2, e2);
    testGoodScores(n3, e3);
  }

  public static ArrayList<Integer> goodScores(ArrayList<Integer> nums){
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int n: nums){
      if (n > 90){
        result.add(n);
      }
    }
    return result;
  }

  public static void testGoodScores(ArrayList<Integer> nums, ArrayList<Integer> expected){
    System.out.println("numbers: ");
    for(int n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.print("expected: ");
    for (int n: expected){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.print(" result: ");
    for (int n :goodScores(nums)){
      System.out.print(n + " ");
    }
    System.out.println();
    if(goodScores(nums).equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
