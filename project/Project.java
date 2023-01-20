import processing.core.*;

public class Project extends PApplet{
  int gameState = 0;
  int p1Character = 0;
  int p2Character = 3;
  int map = 0;
  Character p1 = new Character(this, 4);
  Character p2 = new Character(this, 4);
  Platform p = new Platform(this, 500,300,100,10);

  public void settings(){
    //size(1000, 600);
    fullScreen();
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

      for(int i = 0; i <= 3; i += 1){
        strokeWeight(1);
        if(i == 0){
          fill(255);
          stroke(255);
        }else if(i == 1){
          fill(255,255,100);
          stroke(255,255,100);
        }else if(i == 2){
          fill(100,255,255);
          stroke(100,255,255);
        }else if(i == 3){
          fill(255,100,255);
          stroke(255,100,255);
        }
        ellipse(i*200 + 200, 200, 100, 100);

        if(p1Character == i){
          noFill();
          strokeWeight(3);
          stroke(255,0,0);
          ellipse(i*200+200,200,110,110);
        }else if(p2Character == i){
          noFill();
          strokeWeight(3);
          stroke(0,0,255);
          ellipse(i*200+200,200,110,110);
        }
      }
      //boxes
      /*
      drawRounded(360,120,120,120);
      drawRounded(360,280,120,120);
      drawRounded(360,440,120,120);
      drawRounded(520,120,120,120);
      drawRounded(520,280,120,120);
      drawRounded(520,440,120,120);
      */

      //p1 selection
      //drawRounded(60, 120, 220, 220);

      //p2 selection
      //drawRounded(700, 120, 220, 220);
    }


    //map selection
    else if (gameState == 2){
      background(0);
      text("map selection screen", 500, 50);

      fill(150);
      noStroke();
      rect(width/13, height/6, width*3/13, height*4/6);
      rect(width*5/13, height/6, width*3/13, height*4/6);
      rect(width*9/13, height/6, width*3/13, height*4/6);

      fill(255);
      if(map == 0){
        rect(width/19, height/8, width*5/19, height*3/4);
      }else if(map == 1){
        rect(width*7/19, height/8, width*5/19, height*3/4);
      }else if (map == 2){
        rect(width*13/19, height/8, width*5/19, height*3/4);
      }
    }


    //gameplay
    else if (gameState == 3){
      background(0);
      text("gameplay", 500, 500);

      p1.display();
      p2.display();
      p1.checkPlatform(p);
      p2.checkPlatform(p);

      p.display();
    }


    //win/lose
    else if (gameState == 4){
      background(0);
      text("win/lose", 500, 500);
    }
  }

  public void keyPressed(){
    //switching gamestates
    if (key == ' '){
      if (gameState == 4){
        gameState = 0;
      }else{
        gameState += 1;
      }
    }else if (key == 'b' && gameState < 0){
      gameState -= 1;
    }

    //character selection
    if(gameState == 1){
      if(key == 'a'){
        if(p1Character == 0){
          p1Character = 3;
        }else{
          p1Character -= 1;
        }

        if(p1Character == p2Character){
          if(p1Character == 0){
            p1Character = 3;
          }else{
            p1Character -= 1;
          }
        }
      }else if(key == 'd'){
        if(p1Character == 3){
          p1Character = 0;
        }else{
          p1Character += 1;
        }

        if(p1Character == p2Character){
          if(p1Character == 3){
            p1Character = 0;
          }else{
            p1Character += 1;
          }
        }
      }

      if(keyCode == LEFT){
        if(p2Character == 0){
          p2Character = 3;
        }else{
          p2Character -= 1;
        }

        if(p2Character == p1Character){
          if(p2Character == 0){
            p2Character = 3;
          }else{
            p2Character -= 1;
          }
        }
      }else if(keyCode == RIGHT){
        if(p2Character == 3){
          p2Character = 0;
        }else{
          p2Character += 1;
        }

        if(p2Character == p1Character){
          if(p2Character == 3){
            p2Character = 0;
          }else{
            p2Character += 1;
          }
        }
      }

      if(key == ' '){
        p1.setCharacter(p1Character);
        p2.setCharacter(p2Character);
      }
    }

    //map selection
    if(gameState == 2){
      if(keyCode == RIGHT){
        if(map != 2){
          map += 1;
        }else{
          map = 0;
        }
      }else if(keyCode == LEFT){
        if(map != 0){
          map -= 1;
        }else{
          map = 2;
        }
      }
    }

    //gameplay
    if (gameState == 3){
      if(key == 'w' && p1.getJumpState() == false){
        p1.jump();
      }else if(key == 'a'){
        p1.moveLeft();
      }else if(key == 'd'){
        p1.moveRight();
      }

      if(keyCode == UP && p2.getJumpState() == false){
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

  public static void main(String[] args){
    PApplet.main("Project");
  }
}
