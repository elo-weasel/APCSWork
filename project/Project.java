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
      text("character selection screen", 500, 500);
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
        p1.acc.y -= 2;
      }else if(key == 'a'){
        p1.vel.x = -5;
      }else if(key == 'd'){
        p1.vel.x = 5;
      }

      if(keyCode == UP){
        p2.acc.y -= 2;
      }else if(keyCode == LEFT){
        p2.vel.x = -5;
      }else if(keyCode == RIGHT){
        p2.vel.x = 5;
      }
    }
  }

  public void keyReleased(){
    if (gameState == 3){
      if(key == 'a'){
        p1.vel.x += 5;
      }else if(key == 'd'){
        p1.vel.x -= 5;
      }

      if(keyCode == LEFT){
        p2.vel.x += 5;
      }else if(keyCode == RIGHT){
        p2.vel.x -= 5;
      }
    }
  }

  public static void main(String args[]){
    PApplet.main("Project");
  }
}
