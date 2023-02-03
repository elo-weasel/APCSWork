public class Arrays{
  public static void main(String[] args){
    int[][] diagonal = new int[10][10];
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        if(i == j){
          diagonal[i][j] = 1;
        }else{
          diagonal[i][j] = 0;
        }
      }
    }

    for(int[] ints : diagonal){
      for(int i : ints){
        System.out.print(i + " ");
      }
      System.out.println();
    }

    System.out.println();

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
