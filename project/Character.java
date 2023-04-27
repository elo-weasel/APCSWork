import processing.core.*;

public class Character{
  public Character(PApplet p, boolean facingRight){
    this.p = p;
    acc = new PVector(0,0);
    vel = new PVector(0,0);
    pos = new PVector(p.width/2,p.height/3*2);
    jumping = false;
    doubleJumping = false;
    goingDown = false;
    onPlatform = false;
    health = 10;
    this.facingRight = facingRight;
  }

  //updates and draws character
  public void display(int character){
    vel.add(acc);
    pos.add(vel);

    if(vel.y > 0){
      goingDown = true;
      jumping = true;
    }

    //limits x velocity
    if(vel.x > (p.width/100/6*5) || vel.x < -(p.width/100/6*5)){
      vel.x /= 2;
    }

    //applies and stops gravity
    if(pos.y < p.height/3*2 && onPlatform == false){
      acc.y += (p.height/(float)6000);

    }else if(pos.y > p.height/3*2){
      pos.y = p.height/3*2;
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

    //character color and draw
    if (character == 0){
      p.fill(255);
      p.stroke(255);
    }else if (character == 1){
      p.fill(255,255,100);
      p.stroke(255,255,100);
    }else if (character == 2){
      p.fill(100,255,255);
      p.stroke(100,255,255);
    }else if (character == 3){
      p.fill(255,100,255);
      p.stroke(255,100,255);
    }
    if(facingRight == true){
      p.triangle(pos.x-(p.width/100), pos.y-(p.width/100/3*4), pos.x-(p.width/100), pos.y+(p.width/100/3*4), pos.x+(p.width/100), pos.y);
    }else{
      p.triangle(pos.x+(p.width/100), pos.y-(p.width/100/3*4), pos.x+(p.width/100), pos.y+(p.width/100/3*4), pos.x-(p.width/100), pos.y);
    }
  }

  public boolean getJumpState(){return doubleJumping;}
  public PVector getPos(){return pos;}
  public PVector getVel(){return vel;}
  public boolean getFacingRight(){return facingRight;}
  public int getHealth(){return health;}

  public void resetHealth(){
    health = 10;
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
    if(goingDown == true && pos.x > platform.getXPos() - (p.width/100/6*5) && pos.x < platform.getXPos() + platform.getWidth() + (p.width/100/6*5) && pos.y + vel.y >= platform.getYPos() - (p.width/100/6*5) && pos.y <= platform.getYPos()){
      pos.y = platform.getYPos() - (p.width/100/6*5);
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
}
