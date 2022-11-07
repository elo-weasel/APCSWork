import java.util.*

class CountLucky{
  public static void main(String[] args){
    ArrayList<int> n1 = new ArrayList<int>();
    n1.add(3);
    n1.add(7);
    n1.add(14);
    ArrayList<int> n2 = new ArrayList<int>();
    n2.add(17);
    n2.add(-7);
    n2.add(0);
    ArrayList<int> n3 = new ArrayList<int>();
    n3.add(230487);
    n3.add(4);
    n3.add(2);

    test(n1, 2);
    test(n2, 2);
    test(n3, 1);
  }

  public static int count(ArrayList<int> nums){
    int result = 0;
    for (int n: nums){
      if((n%7 == 0 || n%10 == 7 || n%10 == -7) && n != 0){
        result += 1;
      }
    }
    return result;
  }

  public static void test(ArrayList<int> nums, int expected){
    System.out.println("numbers: ");
    for(int n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + count(nums));
    if(count(nums) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
