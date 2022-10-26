class TestRectangle{
  public static void main(String[] args){
    Rectangle r1 = new Rectangle(3,4);
    Rectangle r2 = new Rectangle(1,1);
    Rectangle r3 = new Rectangle (965, 450);

    testRectangle(r1);
    testRectangle(r2);
    testRectangle(r3);
  }

  public static void testRectangle(Rectangle r){
    System.out.println();
    System.out.println("base: " + r.getBase() + " height: " + r.getHeight());
    System.out.println("area: " + r.getArea());
    System.out.println("perimeter: " + r.getPerimeter());
    System.out.println("diagonal length: " + r.getDiagonal());
  }
}
