import processing.core.*;

public class Egg{
  public Egg(PApplet p, PImage e0, PImage e1, PImage e2, PImage e3, PImage e4, float x, float y, float width, float height){
    this.p = p;

    this.e0 = e0;
    this.e1 = e1;
    this.e2 = e2;
    this.e3 = e3;
    this.e4 = e4;

    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    level = 0;
  }

  public void advanceEgg(){
    if(level < 4){
      level += 1;
    }else if(level == 4){
      level = 4;
    }
  }

  public void disappear(){
    level = 5;
  }

  public void closeEgg(){
    if(level > 0 && level < 5){
      level -= 1;
    }else if (level == 0){
      level = 0;
    }
  }

  public void display(){
    p.imageMode(p.CENTER);

    if(level == 0){
      p.image(e0, x, y, width, height);
    }else if(level == 1){
      p.image(e1, x, y, width, height);
    }else if(level == 2){
      p.image(e2, x, y, width, height);
    }else if(level == 3){
      p.image(e3, x, y, width, height);
    }else if(level == 4){
      p.image(e4, x, y, width, height);
    }
  }

  private PApplet p;
  private int level = 0;
  private PImage e0;
  private PImage e1;
  private PImage e2;
  private PImage e3;
  private PImage e4;
  private float x;
  private float y;
  private float width;
  private float height;
}
