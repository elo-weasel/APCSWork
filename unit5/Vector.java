public class Vector{
  private double x;
  private double y;

  public Vector(double xIn, double yIn){
    x = xIn;
    y = yIn;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public double getMag(){
    return Math.sqrt(x*x+y*y);
  }

  public double getDir(){
    return Math.atan2(y, x);
  }

  public void add(Vector u){
    System.out.println("x: " + (x + u.getX()) + " y: " + (y + u.getY()));
  }

  public void scalarMultiply(double k){
    System.out.println("x: " + x * k + " y: " + y * k);
  }

  public double dotProduct(Vector u){
    return x*u.getX()+y*u.getY();
  }

  public double angle(Vector u){
    return Math.acos(this.dotProduct(u)/(this.getMag()*u.getMag()));
  }
}
