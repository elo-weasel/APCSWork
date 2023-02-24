import processing.core.*;
import java.util.*;

public class Project extends PApplet{
  int gameState = 3;
  int p1Character = 0;
  int p2Character = 3;
  int map = 0;
  Character p1 = new Character(this, true);
  Character p2 = new Character(this, false);
  ArrayList<Platform> platforms = new ArrayList<Platform>();
  Platform platform1 = new Platform(this, 500,300,100,10);
  Platform platform2 = new Platform(this, 700,200,50,10);
  ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

  public void settings(){
    //size(1000, 600);
    fullScreen();
  }

  public void setup(){
    platforms.add(platform1);
    platforms.add(platform2);
  }

  public void draw(){
    //controlling # of projectiles
    for(int i = 0; i < projectiles.size(); i++){
      if(projectiles.get(i).outOfScreen() == true){
        projectiles.remove(i);
        i -= 1;
      }else if(projectiles.get(i).touchingCharacter(p1) && projectiles.get(i).belongsTo() == 2){
        p1.hit();
        projectiles.remove(i);
        i -= 1;
      }else if(projectiles.get(i).touchingCharacter(p2) && projectiles.get(i).belongsTo() == 1){
        p2.hit();
        projectiles.remove(i);
        i -= 1;
      }
    }

    //menu
    if (gameState == 0){
      background(0);
      fill(255);
      text("press space to start", 500, 500);
    }


    //character selection
    else if (gameState == 1){
      background(0);
      fill(255);
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
    }


    //map selection
    else if (gameState == 2){
      background(0);
      fill(255);
      text("map selection screen", 500, 50);

      noStroke();
      fill(0, 70, 84, 100);
      rect(width/13, height/6, width*3/13, height*4/6);
      fill(44, 74, 32, 100);
      rect(width*5/13, height/6, width*3/13, height*4/6);
      fill(110, 0, 16, 100);
      rect(width*9/13, height/6, width*3/13, height*4/6);

      fill(255);
      if(map == 0){
        fill(0, 70, 84);
        rect(width/19, height/8, width*5/19, height*3/4);
      }else if(map == 1){
        fill(44, 74, 32);
        rect(width*7/19, height/8, width*5/19, height*3/4);
      }else if (map == 2){
        fill(110, 0, 16);
        rect(width*13/19, height/8, width*5/19, height*3/4);
      }
    }


    //gameplay
    else if (gameState == 3){
      background(0);
      fill(255);
      text("gameplay", 500, 500);

      for(Platform p: platforms){
        p.display(map);
        p1.checkPlatform(p);
        p2.checkPlatform(p);
      }

      for(Projectile p: projectiles){
        p.update();
        //System.out.println(p.pVel);
      }

      p1.display(p1Character);
      p2.display(p2Character);

      text("p1 health: " + p1.getHealth(), 30,30);
      text("p2 health: " + p2.getHealth(),30,50);
    }


    //win/lose
    else if (gameState == 4){
      background(0);
      fill(255);
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
      //p1 movement
      if(key == 'w' && p1.getJumpState() == false){
        p1.jump();
      }else if(key == 'a'){
        p1.moveLeft();
      }else if(key == 'd'){
        p1.moveRight();
      }

      //p1 attacks
      if(key == 'q'){
        Projectile projectile = new Projectile(this, p1.getPos(), p1.getVel(), p1.getFacingRight(), 1, -1);
        projectiles.add(projectile);
      }

      //p2 movement
      if(keyCode == UP && p2.getJumpState() == false){
        p2.jump();
      }else if(keyCode == LEFT){
        p2.moveLeft();
      }else if(keyCode == RIGHT){
        p2.moveRight();
      }

      //p2 attacks
      if(key == 'l'){
        Projectile projectile = new Projectile(this, p2.getPos(), p1.getVel(), p2.getFacingRight(), 2, 0);
        projectiles.add(projectile);
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

  public static void main(String[] args){
    PApplet.main("Project");
  }
}
