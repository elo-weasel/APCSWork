public class Rectangle{
  private double base;
  private double height;

  public Rectangle(double b, double h){
    base = b;
    height = h;
  }

  public double getBase(){
    return base;
  }

  public double getHeight(){
    return height;
  }

  public double getArea(){
    return base*height;
  }

  public double getPerimeter(){
    return base*2+height*2;
  }

  public double getDiagonal(){
    return Math.sqrt(base*base+height*height);
  }
}
