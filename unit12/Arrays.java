public class Arrays{
  public static void main(String[] args){
    String[][] words = new String[4][2];

    double[][] ds = new double[5][5];
    for (int i = 0; i < ds.length; i++){
      for (int j = 0; j < ds[i].length; j++){
        ds[i][j] = 10 + 10*i + 1 + 1*j;
      }
    }

    for(double[] doubles : ds){
      for(double d : doubles){
        System.out.print(d + " ");
      }
      System.out.println();
    }

    System.out.println();

    int[][] is = new int[6][5];
    for (int i = 0; i < is.length; i++){
      for (int j = 0; j < is[i].length; j++){
        is[i][j] = i+1;
      }
    }

    for(int[] ints : is){
      for(int i : ints){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
