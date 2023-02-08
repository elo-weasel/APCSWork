import java.util.*;

public class ShapeCollection{
  public ShapeCollection(){
    shapes = new ArrayList<Shape>();
  }

  public ArrayList<Shape> getShapes(){return shapes;}

  public void addShape(String name, int sides){
    shapes.add(new Shape(name, sides));
  }

  public int numberOfSides(String name){
    for(Shape s : shapes){
      if(s.getName().equals(name)){
        return s.getSides();
      }
    }
    return 0;
  }

  public float avgSides(){
    float total = 0;
    for(Shape s : shapes){
      total += s.getSides();
    }
    return total/shapes.size();
  }

  public ArrayList<Shape> evenSides(){
    ArrayList<Shape> result = new ArrayList<Shape>();
    for(Shape s : shapes){
      if(s.getSides()%2 == 0){
        result.add(s);
      }
    }
    return result;
  }

  private ArrayList<Shape> shapes;
}
