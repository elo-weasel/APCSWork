import processing.core.*;

public class Character{
  public Character(PApplet p, boolean facingRight, int c){
    this.p = p;
    acc = new PVector(0,0);
    vel = new PVector(0,0);
    if(c == 1){
      pos = new PVector(p.width/7,p.height*10/11);
    }else if(c == 2){
      pos = new PVector(p.width*6/7,p.height*10/11);
    }
    jumping = false;
    doubleJumping = false;
    goingDown = false;
    onPlatform = false;
    health = 5;
    this.facingRight = facingRight;

    gravity = (p.height/(float)6000);
  }

  //updates and draws character
  public void display(PImage i){
    vel.add(acc);
    pos.add(vel);

    if(vel.y > 0){
      goingDown = true;
    }

    //limits x velocity
    if(vel.x > (p.width/100/6*5) || vel.x < -(p.width/100/6*5)){
      vel.x /= 2;
    }

    //applies and stops gravity
    if(pos.y < p.height*10/11 && onPlatform == false){
      acc.y += gravity;

    }else if(pos.y > p.height*10/11){
      pos.y = p.height*10/11;
      acc.y = 0;
      vel.y = 0;
      jumping = false;
      doubleJumping = false;
      goingDown = false;
    }

    //edges of screen
    if(pos.x < 0){
      pos.x = 0;
    }else if(pos.x > p.width){
      pos.x = p.width;
    }

    p.imageMode(p.CENTER);
    if(facingRight == true){
      p.image(i, pos.x, pos.y, p.width/15, p.width/15);
    }else{
      p.pushMatrix();
      p.translate(pos.x, pos.y);
      p.scale(-1, 1);
      p.image(i, 0, 0, p.width/15, p.width/15);
      p.popMatrix();
    }
  }

  public boolean running(){
    return goingDown == false && vel.x != 0 && jumping == false;
  }

  public boolean jumps(){
    return jumping;
  }

  public void higherJumps(){
    gravity = p.height/(float)8000;
  }

  public boolean getJumpState(){return doubleJumping;}
  public PVector getPos(){return pos;}
  public PVector getVel(){return vel;}
  public boolean getFacingRight(){return facingRight;}
  public int getHealth(){return health;}

  public void resetHealth(){
    health = 5;
  }

  public void jump(){
    if(jumping == true){
      doubleJumping = true;
    }else{
      jumping = true;
    }
    vel.y = -(float)(p.height/(float)50);
    acc.y = 0;
    onPlatform = false;
  }

  public void moveLeft(){
    vel.x = -(p.width/100/6*5);
    facingRight = false;
  }

  public void moveRight(){
    vel.x = (p.width/100/6*5);
    facingRight = true;
  }

  public void stopLeft(){
    vel.x += (p.width/100/6*5);
  }

  public void stopRight(){
    vel.x -= (p.width/100/6*5);
  }

  public void checkPlatform(Platform platform){
    if(goingDown == true && pos.x > platform.getXPos() - (p.width/50/6*5) && pos.x < platform.getXPos() + platform.getWidth() + (p.width/50/6*5) && pos.y + vel.y >= platform.getYPos() - (p.width/50/6*5) && pos.y <= platform.getYPos()){
      pos.y = platform.getYPos() - (p.width/50/6*5);
      acc.y = 0;
      vel.y = 0;
      onPlatform = true;
      jumping = false;
      doubleJumping = false;
      goingDown = false;
    }else{
      onPlatform = false;
    }
  }

  public void hit(){
    health -= 1;
  }

  public void setHealth(int h){
    health = h;
  }

  private PApplet p;
  private boolean jumping;
  private boolean doubleJumping;
  private PVector acc;
  private PVector vel;
  private PVector pos;
  private boolean goingDown;
  private boolean onPlatform;
  private int health;
  private boolean facingRight;
  private float gravity;
}
