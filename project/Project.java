import processing.core.*;

public class Project extends PApplet{
  int gameState = 0;
  Character p1 = new Character(this, "red");
  Character p2 = new Character(this, "blue");

  public void settings(){
    size(1000, 600);
  }

  public void setup(){

  }

  public void draw(){
    //menu
    if (gameState == 0){
      background(0);
      text("press space to start", 500, 500);
    }


    //character selection
    else if (gameState == 1){
      background(0);
      text("character selection screen", 500, 100);

      //boxes
      drawRounded(360,120,120,120);
      drawRounded(360,280,120,120);
      drawRounded(360,440,120,120);
      drawRounded(520,120,120,120);
      drawRounded(520,280,120,120);
      drawRounded(520,440,120,120);

      //p1 selection
      drawRounded(60, 120, 220, 220);

      //p2 selection
      drawRounded(700, 120, 220, 220);
    }


    //map selection
    else if (gameState == 2){
      background(0);
      text("map selection screen", 500, 500);
    }


    //gameplay
    else if (gameState == 3){
      background(0);
      text("gameplay", 500, 500);

      p1.display();
      p2.display();
    }


    //win/lose
    else if (gameState == 4){
      background(0);
      text("win/lose", 500, 500);
    }
  }

  public void keyPressed(){
    if (key == ' '){
      if (gameState == 4){
        gameState = 0;
      }else{
        gameState += 1;
      }
    }else if (key == 'b' && gameState < 0){
      gameState -= 1;
    }

    if (gameState == 3){
      if(key == 'w'){
        p1.jump();
      }else if(key == 'a'){
        p1.moveLeft();
      }else if(key == 'd'){
        p1.moveRight();
      }

      if(keyCode == UP){
        p2.jump();
      }else if(keyCode == LEFT){
        p2.moveLeft();
      }else if(keyCode == RIGHT){
        p2.moveRight();
      }
    }
  }

  public void keyReleased(){
    if (gameState == 3){
      if(key == 'a'){
        p1.stopLeft();
      }else if(key == 'd'){
        p1.stopRight();
      }

      if(keyCode == LEFT){
        p2.stopLeft();
      }else if(keyCode == RIGHT){
        p2.stopRight();
      }
    }
  }

  //drawing character selection  boxes
  public void drawRounded(float xPos, float yPos, float width, float height){
    noStroke();
    rect(xPos + width/8, yPos + height/8, width*3/4, height*3/4);
    ellipse(xPos + width/8, yPos + height/8, width/4, height/4);
    ellipse(xPos + width/8, yPos + height*7/8, width/4, height/4);
    ellipse(xPos + width*7/8, yPos + height/8, width/4, height/4);
    ellipse(xPos + width*7/8, yPos + height*7/8, width/4, height/4);

    rect(xPos + width/8, yPos, width*3/4, height/4);
    rect(xPos + width/8, yPos + height*3/4, width*3/4, height/4);
    rect(xPos, yPos + height/8, width/4, height*3/4);
    rect(xPos + width*3/4, yPos + height/8, width/4, height*3/4);
  }

  public static void main(String args[]){
    PApplet.main("Project");
  }
}
