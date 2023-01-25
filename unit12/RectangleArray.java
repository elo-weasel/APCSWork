public class RectangleArray{
  public static void main(String[] args){
    Rectangle[][] rects = new Rectangle[2][3];

    rects[0][0] = new Rectangle("r1", 6, 2.5);
    rects[0][1] = new Rectangle("r2", 3.4, 90);
    rects[0][2] = new Rectangle("r3", 23, 8.7);
    rects[1][0] = new Rectangle("r4", 0, 0);
    rects[1][1] = new Rectangle("r5", 8, 2);
    rects[1][2] = new Rectangle("r6", 1, 2.5);

    System.out.println("rectangle array: ");
    for(Rectangle[] rectangles : rects){
      for(Rectangle r : rectangles){
        System.out.print(r.getName() + "- p:" + r.getPerimeter() + " a: " + r.getArea() + "   ");
      }
      System.out.println();
    }

    System.out.println();
    System.out.println("average perimeter: " + avgPerimeter(rects));
    Rectangle r = greatestArea(rects);
    System.out.println("greatest area: " + r.getName() + ", " + r.getArea());
  }

  public static double avgPerimeter(Rectangle[][] rects){
    double total = 0;
    int i = 0;
    for(Rectangle[] rectangles : rects){
      for (Rectangle r : rectangles){
        total += r.getPerimeter();
        i += 1;
      }
    }
    return total/i;
  }

  public static Rectangle greatestArea(Rectangle[][] rects){
    Rectangle result = rects[0][0];
    for(Rectangle[] rectangles : rects){
      for (Rectangle r : rectangles){
        if(r.getArea() > result.getArea()){
          result = r;
        }
      }
    }
    return result;
  }
}
