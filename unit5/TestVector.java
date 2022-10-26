class TestVector{
  public static void main(String[] args){
    Vector v = new Vector(3,4);
    Vector u = new Vector(5,6);

    System.out.println("Vector V");
    System.out.println("x: " + v.getX() + " y: " + v.getY());
    System.out.println("magnitude: " + v.getMag() + " direction: " + v.getDir());
    System.out.println();

    System.out.println("Vector U");
    System.out.println("x: " + u.getX() + " y: " + u.getY());
    System.out.println("magnitude: " + u.getMag() + " direction: " + u.getDir());
    System.out.println();

    System.out.println("U + V");
    v.add(u);
    System.out.println();

    System.out.println("2U");
    v.scalarMultiply(2);
    System.out.println();

    System.out.println("dot product U*V");
    System.out.println(v.dotProduct(u));
    System.out.println();

    System.out.println("Angle between");
    System.out.println(v.angle(u));
  }
}
