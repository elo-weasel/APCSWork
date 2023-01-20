import processing.core.*;

public class Character{
  public Character(PApplet p, int character){
    this.p = p;
    this.character = character;
    acc = new PVector(0,0);
    vel = new PVector(0,0);
    pos = new PVector(500,400);
    jumping = false;
    doubleJumping = false;
    goingDown = false;
    onPlatform = false;
  }

  public void display(){
    vel.add(acc);
    pos.add(vel);

    if(vel.y > 0){
      goingDown = true;
      jumping = true;
    }

    //limits x velocity
    if(vel.x > 5 || vel.x < -5){
      vel.x /= 2;
    }

    //applies and stops gravity
    if(pos.y < 400 && onPlatform == false){
      acc.y += 0.15;
    }else if(pos.y > 400){
      pos.y = 400;
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
    p.ellipse(pos.x, pos.y, 10, 10);
  }

  public boolean getJumpState(){
    return doubleJumping;
  }

  public void jump(){
    if(jumping == true){
      doubleJumping = true;
    }else{
      jumping = true;
    }
    vel.y = 0;
    acc.y = -(float)1.5;
    onPlatform = false;
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

  public void checkPlatform(Platform platform){
    if(goingDown == true && pos.x > platform.getXPos() - 5 && pos.x < platform.getXPos() + platform.getWidth() + 5 && pos.y + vel.y >= platform.getYPos() - 5 && pos.y <= platform.getYPos()){
      pos.y = platform.getYPos() - 5;
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

  public void setCharacter(int c){
    character = c;
  }

  private PApplet p;
  private int character;
  private boolean jumping;
  private boolean doubleJumping;
  private PVector acc;
  private PVector vel;
  private PVector pos;
  private boolean goingDown;
  private boolean onPlatform;
}
