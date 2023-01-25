public class Computations{
  public static void main(String[] args){
    int[][] is = {{423, 234, 34}, {3, 345, 23}, {6, 20}};
    float[][] fs = {{4.2f, 5.3f, 2.4f, 2.0f}, {3.4f, 6.5f}};
    String[][] ss = {{"Apple", "alligator", "brown"}, {"panda", "Able"}, {"Are"}};

    System.out.println("2D int array: ");
    for(int[] ints : is){
      for(int i : ints){
        System.out.print(i + " ");
      }
      System.out.println();
    }
    System.out.println("smallest int: " + findSmallest(is));
    System.out.println();

    System.out.println("2D float array: ");
    for(float[] floats : fs){
      for(float f : floats){
        System.out.print(f + " ");
      }
      System.out.println();
    }
    System.out.println("sum : " + sum(fs));
    System.out.println();

    System.out.println("2D String array: ");
    for(String[] strings : ss){
      for(String s : strings){
        System.out.print(s + " ");
      }
      System.out.println();
    }
    System.out.println("words that start with 'A': " + startsWithA(ss));
    System.out.println();
  }

  public static int findSmallest(int[][] is){
    int result = is[0][0];
    for (int i = 0; i < is.length; i++){
      for (int j = 0; j < is[i].length; j++){
        if(is[i][j] < result){result = is[i][j];}
      }
    }
    return result;
  }

  public static float sum(float [][] fs){
    float result = 0;
    for (int i = 0; i < fs.length; i++){
      for (int j = 0; j < fs[i].length; j++){
        result += fs[i][j];
      }
    }
    return result;
  }

  public static int startsWithA(String[][] ss){
    int result = 0;
    for (int i = 0; i < ss.length; i++){
      for (int j = 0; j < ss[i].length; j++){
        if(ss[i][j].substring(0,1).equals("A")){result += 1;}
      }
    }
    return result;
  }
}
