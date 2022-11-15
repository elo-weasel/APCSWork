import processing.core.*;

public class Character{
  public PVector acc;
  public PVector vel;
  public PVector pos;

  public Character(PApplet p, String name){
    this.p = p;
    this.name = name;
    acc = new PVector(0,0);
    vel = new PVector(0,0);
    pos = new PVector(500,200);
  }

  public void display(){
    if(vel.x > 5 || vel.x < -5){
      vel.x /= 2;
    }
    if(pos.y < 200){
      acc.y += 0.2;
    }else if(pos.y > 200){
      pos.y = 200;
      acc.y = 0;
      vel.y = 0;
    }

    vel.add(acc);
    pos.add(vel);

    if (name.equals("red")){
      p.fill(255,0,0);
    }else if (name.equals("blue")){
      p.fill(0,0,255);
    }
    p.ellipse(pos.x, pos.y, 10, 10);
  }

  public void update(){

  }

  public void celebrate(){

  }

  public void weep(){

  }

  private PApplet p;
  private String name;
}
