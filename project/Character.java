import processing.core.*;

public class Character{
  public Character(PApplet p, String name){
    this.p = p;
    this.name = name;
    acc = new PVector(0,0);
    vel = new PVector(0,0);
    pos = new PVector(500,200);
    jumping = false;
  }

  public void display(){
    vel.add(acc);
    pos.add(vel);

    if(vel.x > 5 || vel.x < -5){
      vel.x /= 2;
    }
    if(pos.y < 200){
      acc.y += 0.15;
    }else if(pos.y > 200){
      pos.y = 200;
      acc.y = 0;
      vel.y = 0;
    }

    if (name.equals("red")){
      p.fill(255,0,0);
    }else if (name.equals("blue")){
      p.fill(0,0,255);
    }
    p.ellipse(pos.x, pos.y, 10, 10);
  }

  public boolean getJumpState(){
    return jumping;
  }

  public void jump(){
    acc.y -= 1.5;
  }

  public void moveLeft(){
    vel.x = -5;
  }

  public void moveRight(){
    vel.x = 5;
  }

  public void stopLeft(){
    vel.x += 5;
  }

  public void stopRight(){
    vel.x -= 5;
  }

  public void celebrate(){

  }

  public void weep(){

  }

  private PApplet p;
  private String name;
  private boolean jumping;
  private PVector acc;
  private PVector vel;
  private PVector pos;
}
