import processing.core.*;
import java.util.*;

public class MouseTrail extends PApplet{
  int time;
  ArrayList<Shape> shapes;

  public void settings(){
    size(500,500);
  }

  public void setup(){
    background(0);
    shapes = new ArrayList<Shape>();
    time = 0;
  }

  public void draw(){
    background(0);

    for (Shape s : shapes){
      s.display();
    }

    for (int i = 0; i < shapes.size(); i++){
      if(shapes.get(i).getTime() == 255){
        shapes.remove(shapes.get(i));
      }
    }

    time += 1;

    if(time == 7){
      makeShape();
      time = 0;
    }
  }

  public void makeShape(){
    Shape s = new Shape(this, mouseX, mouseY, 4, random(10,20));
    shapes.add(s);
  }

  public static void main(String[] args)
    {
        PApplet.main("MouseTrail");
    }
}
