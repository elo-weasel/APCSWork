import processing.core.*;
import java.util.*;

public class Project extends PApplet{
  int gameState = 0;
  int p1Character = -1;
  int p2Character = -1;
  int map = 0;
  Character p1;
  Character p2;
  ArrayList<Platform> platforms = new ArrayList<Platform>();
  Platform platform1;
  Platform platform2;
  Platform platform3;
  Platform platform4;
  ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
  //menu pimages
  PImage logo;
  PImage play;
  PImage pplay;
  PImage tutorial;
  PImage ptutorial;
  PImage menubg;
  PImage tut;
  PImage p1win;
  PImage p2win;
  PImage again;

  //character pimages
  PImage chickenWhole;
  PImage chickenCracked;
  PImage chickenBroken;
  PImage chickenAjar;
  PImage chickenOpen;

  PImage dodoWhole;
  PImage dodoCracked;
  PImage dodoBroken;
  PImage dodoAjar;
  PImage dodoOpen;

  PImage peacockWhole;
  PImage peacockCracked;
  PImage peacockBroken;
  PImage peacockAjar;
  PImage peacockOpen;

  PImage roboWhole;
  PImage roboCracked;
  PImage roboBroken;
  PImage roboAjar;
  PImage roboOpen;

  PImage grass;

  PImage chicken;
  PImage dodo;
  PImage peacock;
  PImage robo;

  PImage chickend;
  PImage dodod;
  PImage peacockd;
  PImage robod;

  //eggs
  int eggTimer = 0;
  Egg chickenEgg;
  Egg dodoEgg;
  Egg peacockEgg;
  Egg roboEgg;
  ArrayList<Egg> eggs = new ArrayList<Egg>();

  int p1JumpTimer = 0;
  int p2JumpTimer = 0;
  int p1AttackTimer = 0;
  int p2AttackTimer = 0;
  int p1runTimer = 0;
  int p2runTimer = 0;

  boolean paused = false;

  int grassLower = 0;

  //gameplay animations
  PImage chickenrun1;
  PImage chickenrun2;
  PImage chickenshoot;

  PImage dodorun1;
  PImage dodorun2;
  PImage dodoshoot;

  PImage peacockrun1;
  PImage peacockrun2;
  PImage peacockshoot;

  PImage roborun1;
  PImage roborun2;
  PImage roboshoot;

  public void settings(){
    fullScreen();
  }

  public void setup(){
    textSize(width/50);

    platform1 = new Platform(this, width/6,height*5/7,width/10,height/20);
    platform2 = new Platform(this, width/2,height/2,width/5,height/20);
    platform3 = new Platform(this, width/3,height/4,width/10,height/20);
    platform4 = new Platform(this, width*4/5,height*3/4,width/15,height/20);
    p1 = new Character(this, true, 1);
    p2 = new Character(this, false, 2);

    platforms.add(platform1);
    platforms.add(platform2);
    platforms.add(platform3);
    platforms.add(platform4);

    //menu pimages
    logo = loadImage("logo.png");
    play = loadImage("play.png");
    pplay = loadImage("pressed_play.png");
    tutorial = loadImage("tutorial.png");
    ptutorial = loadImage("pressed_tutorial.png");
    menubg = loadImage("menu_bg.png");
    tut = loadImage("tut.png");
    p1win = loadImage("p1win.png");
    p2win = loadImage("p2win.png");
    again = loadImage("again.png");

    //character selection pimages
    chickenWhole = loadImage("chicken_whole.png");
    chickenCracked = loadImage("chicken_cracked.png");
    chickenBroken = loadImage("chicken_broken.png");
    chickenAjar = loadImage("chicken_ajar.png");
    chickenOpen = loadImage("chicken_open.png");

    dodoWhole = loadImage("dodo_whole.png");
    dodoCracked = loadImage("dodo_cracked.png");
    dodoBroken = loadImage("dodo_broken.png");
    dodoAjar = loadImage("dodo_ajar.png");
    dodoOpen = loadImage("dodo_open.png");

    peacockWhole = loadImage("peacock_whole.png");
    peacockCracked = loadImage("peacock_cracked.png");
    peacockBroken = loadImage("peacock_broken.png");
    peacockAjar = loadImage("peacock_ajar.png");
    peacockOpen = loadImage("peacock_open.png");

    roboWhole = loadImage("robo_whole.png");
    roboCracked = loadImage("robo_cracked.png");
    roboBroken = loadImage("robo_broken.png");
    roboAjar = loadImage("robo_ajar.png");
    roboOpen = loadImage("robo_open.png");

    grass = loadImage("grass.png");

    chicken = loadImage("Chicken.png");
    dodo = loadImage("Dodo.png");
    peacock = loadImage("Peacock.png");
    robo = loadImage("Robobird.png");

    chickend = loadImage("chickend.png");
    dodod = loadImage("dodod.png");
    peacockd = loadImage("peacockd.png");
    robod = loadImage("robod.png");

    chickenEgg = new Egg(this, chickenWhole, chickenCracked, chickenBroken, chickenAjar, chickenOpen, width/5, height/3, width/10, height/4);
    eggs.add(chickenEgg);
    dodoEgg = new Egg(this, dodoWhole, dodoCracked, dodoBroken, dodoAjar, dodoOpen, width*2/5, height/3, width/10, height/4);
    eggs.add(dodoEgg);
    peacockEgg = new Egg(this, peacockWhole, peacockCracked, peacockBroken, peacockAjar, peacockOpen, width*3/5, height/3, width/10, height/4);
    eggs.add(peacockEgg);
    roboEgg = new Egg(this, roboWhole, roboCracked, roboBroken, roboAjar, roboOpen, width*4/5, height/3, width/10, height/4);
    eggs.add(roboEgg);

    //gameplay animation
    chickenrun1 = loadImage("chickenrun1.png");
    chickenrun2 = loadImage("chickenrun2.png");
    chickenshoot = loadImage("chickenshoot.png");

    dodorun1 = loadImage("dodorun1.png");
    dodorun2 = loadImage("dodorun2.png");
    dodoshoot = loadImage("dodoshoot.png");

    peacockrun1 = loadImage("peacockrun1.png");
    peacockrun2 = loadImage("peacockrun2.png");
    peacockshoot = loadImage("peacockshoot.png");

    roborun1 = loadImage("roborun1.png");
    roborun2 = loadImage("roborun2.png");
    roboshoot = loadImage("roboshoot.png");
  }

  public void draw(){
    if(paused == true){
      rect(width/8, height/8, width*3/4, height*3/4);
    }else if (paused == false){
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
        background(71, 134, 191);
        fill(255);
        text("press space to start", width/2, height/2);

        imageMode(CENTER);
        image(logo, width/2 - width/50, height/2 - height/10, width/2, height/(float)1.18);
        if(mouseX > width/2 - width/12 && mouseX < width/2 + width/12 && mouseY < height*3/4+height/12+height/24 && mouseY > height*3/4+height/12-height/24){
          image(play, width/2-width/1000, height*3/4, width/(float)4.5, height/(float)2.8);
          image(ptutorial, width/2, height*3/4+height/12, width/(float)4.5, height/(float)2.8);
        }else if(mouseX > width/2 - width/18 && mouseX < width/2 + width/18 && mouseY < height*3/4+height/24 && mouseY > height*3/4-height/24){
          image(pplay, width/2-width/1000, height*3/4, width/(float)4.5, height/(float)2.8);
          image(tutorial, width/2, height*3/4+height/12, width/(float)4.5, height/(float)2.8);
        }else{
          image(play, width/2-width/1000, height*3/4, width/(float)4.5, height/(float)2.8);
          image(tutorial, width/2, height*3/4+height/12, width/(float)4.5, height/(float)2.8);
        }
      }


      //character selection
      else if (gameState == 1){
        background(132, 195, 224);
        fill(44, 168, 30);
        noStroke();
        //rect(0, height/3 + height/30, width, height);

        imageMode(CORNER);
        image(grass, 0, height/6, width, height*5/6);

        imageMode(CENTER);

        if(eggTimer - millis() < -20){
          if(mouseX > width/5 - width/20 && mouseX < (width/5) + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
            chickenEgg.advanceEgg();
            eggTimer = millis();
            image(chickend, width/2, height*3/4, width*7/8, height/8);
          }else if(mouseX > width*2/5 - width/20 && mouseX < width*2/5 + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
            dodoEgg.advanceEgg();
            eggTimer = millis();
            image(peacockd, width/2, height*3/4, width*7/8, height/8);
          }else if(mouseX > width*3/5 - width/20 && mouseX < width*3/5 + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
            peacockEgg.advanceEgg();
            eggTimer = millis();
            image(dodod, width/2, height*3/4, width*7/8, height/8);
          }else if(mouseX > width*4/5 - width/20 && mouseX < width*4/5 + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
            roboEgg.advanceEgg();
            eggTimer = millis();
            image(robod, width/2, height*3/4, width*7/8, height/8);
          }else{
            for(Egg e : eggs){
              e.closeEgg();
              eggTimer = millis();
            }
          }
        }

        for(Egg e:eggs){
          e.display();
        }

        if(p1Character > -1){
          fill(204, 0, 0);
          ellipse(width/5 + width*p1Character/5, height/4 + height/6, width/10, height/25);
          fill(245, 32, 32);
          ellipse(width/5 + width*p1Character/5, height/4 + height/6, width/10-10, height/25-5);
        }
        if(p2Character > -1){
          fill(0, 14, 209);
          ellipse(width/5 + width*p2Character/5, height/4 + height/6, width/10, height/25);
          fill(32, 46, 245);
          ellipse(width/5 + width*p2Character/5, height/4 + height/6, width/10-10, height/25-5);
        }

        if(p1Character == 0 || p2Character == 0){
          image(chicken, width/5, height/3, width/8, width/8 + width/50);
        }if(p1Character == 1 || p2Character == 1){
          image(dodo, width/5 + width/5, height/3, width/8, width/8 + width/50);
        }if(p1Character == 2 || p2Character == 2){
          image(peacock, width/5 + width*2/5, height/3, width/8, width/8 + width/50);
        }if(p1Character == 3 || p2Character == 3){
          image(robo, width/5 + width*3/5, height/3, width/8, width/8 + width/50);
        }

        if(p1Character == 2){
          p1.setHealth(6);
        }if(p2Character == 2){
          p2.setHealth(6);
        }

        if(p1Character > -1 && p2Character > -1){
          //button appears to move forward
        }


      }


      //transition
      else if (gameState == 2){
        background(132, 195, 224);

        imageMode(CORNER);
        if(grassLower < height*8/15){
          grassLower += 30;
        }else{
          gameState = 3;
        }
        image(grass, 0, height/6 + grassLower, width, height*5/6);

        if(p2Character == 1){
          p2.higherJumps();
        }
        if(p1Character == 1){
          p1.higherJumps();
        }
      }


      //gameplay
      else if (gameState == 3){

        background(132, 195, 224);
        //image(sky, 0, -height*7/15 + grassLower, width, height);
        imageMode(CORNER);
        image(grass, 0, height/6 + grassLower, width, height*5/6);


        for(Platform p: platforms){
          p.display(map);
          p1.checkPlatform(p);
          p2.checkPlatform(p);
        }

        for(Projectile p: projectiles){
          p.update();
        }

        if(p1runTimer < 0){
          if(p1Character == 0){
            p1.display(chickenshoot);
          }else if(p1Character == 1){
            p1.display(dodoshoot);
          }else if(p1Character == 2){
            p1.display(peacockshoot);
          }else if(p1Character == 3){
            p1.display(roboshoot);
          }
          p1runTimer += 1;
        }else if(p1.running() == true && millis()%20 < 10){
          if(p1Character == 0){
            p1.display(chickenrun1);
          }else if(p1Character == 1){
            p1.display(dodorun1);
          }else if(p1Character == 2){
            p1.display(peacockrun1);
          }else if(p1Character == 3){
            p1.display(roborun1);
          }
        }else if(p1.running() == true){
          if(p1Character == 0){
            p1.display(chickenrun2);
          }else if(p1Character == 1){
            p1.display(dodorun2);
          }else if(p1Character == 2){
            p1.display(peacockrun2);
          }else if(p1Character == 3){
            p1.display(roborun2);
          }
        }else if(p1.jumps() == true){
          if(p1Character == 0){
            p1.display(chickenrun1);
          }else if(p1Character == 1){
            p1.display(dodorun1);
          }else if(p1Character == 2){
            p1.display(peacockrun1);
          }else if(p1Character == 3){
            p1.display(roborun1);
          }
        }else{
          if(p1Character == 0){
            p1.display(chickenrun1);
          }else if(p1Character == 1){
            p1.display(dodorun1);
          }else if(p1Character == 2){
            p1.display(peacockrun1);
          }else if(p1Character == 3){
            p1.display(roborun1);
          }
        }

        if(p2runTimer < 0){
          if(p2Character == 0){
            p2.display(chickenshoot);
          }else if(p2Character == 1){
            p2.display(dodoshoot);
          }else if(p2Character == 2){
            p2.display(peacockshoot);
          }else if(p2Character == 3){
            p2.display(roboshoot);
          }
          p2runTimer += 1;
        }else if(p2.running() == true && millis()%20 < 10){
          if(p2Character == 0){
            p2.display(chickenrun1);
          }else if(p2Character == 1){
            p2.display(dodorun1);
          }else if(p2Character == 2){
            p2.display(peacockrun1);
          }else if(p2Character == 3){
            p2.display(roborun1);
          }
        }else if(p2.running() == true){
          if(p2Character == 0){
            p2.display(chickenrun2);
          }else if(p2Character == 1){
            p2.display(dodorun2);
          }else if(p2Character == 2){
            p2.display(peacockrun2);
          }else if(p2Character == 3){
            p2.display(roborun2);
          }
        }else if(p2.jumps() == true){
          if(p2Character == 0){
            p2.display(chickenrun1);
          }else if(p2Character == 1){
            p2.display(dodorun1);
          }else if(p2Character == 2){
            p2.display(peacockrun1);
          }else if(p2Character == 3){
            p2.display(roborun1);
          }
        }else{
          if(p2Character == 0){
            p2.display(chickenrun1);
          }else if(p2Character == 1){
            p2.display(dodorun1);
          }else if(p2Character == 2){
            p2.display(peacockrun1);
          }else if(p2Character == 3){
            p2.display(roborun1);
          }
        }

        if(p1.getHealth() <= 0){
          gameState += 1;
        }else if(p2.getHealth() <= 0){
          gameState += 2;
        }

        text("p1 health: " + p1.getHealth(), width/20,height/20);
        text("p2 health: " + p2.getHealth(),width/20,height/10);
      }


      //p2 win
      else if (gameState == 4){
        background(71, 134, 191);
        fill(255);

        imageMode(CENTER);
        image(p2win, width/2, height/10, width/2, height/8);
        image(again, width/2, height*9/10, width/2, height/8);

        fill(150);
        ellipse(width*2/3, height*2/3, width/4, height/15);

        if(p1Character == 0){
          image(chicken, width/3, height/2, width/4, width/4);
        }else if(p1Character == 1){
          image(dodo, width/3, height/2, width/4, width/4);
        }else if(p1Character == 2){
          image(peacock, width/3, height/2, width/4, width/4);
        }else if(p1Character == 3){
          image(robo, width/3, height/2, width/4, width/4);
        }

        if(p2Character == 0){
          image(chicken, width*2/3, height/2, width/4, width/4);
        }else if(p2Character == 1){
          image(dodo, width*2/3, height/2, width/4, width/4);
        }else if(p2Character == 2){
          image(peacock, width*2/3, height/2, width/4, width/4);
        }else if(p2Character == 3){
          image(robo, width*2/3, height/2, width/4, width/4);
        }

        noStroke();
        fill(255, 150);
        quad(width*2/3+width/20, 0, width*2/3 - width/20, 0, width*2/3 - width/8, height*2/3, width*2/3 + width/8, height*2/3);
      }

      //p1 win
      else if(gameState == 5){
        background(71, 134, 191);
        fill(255);

        imageMode(CENTER);
        image(p2win, width/2, height/10, width/2, height/8);
        image(again, width/2, height*9/10, width/2, height/8);

        fill(150);
        ellipse(width/3, height*2/3, width/4, height/15);

        if(p1Character == 0){
          image(chicken, width/3, height/2, width/4, width/4);
        }else if(p1Character == 1){
          image(dodo, width/3, height/2, width/4, width/4);
        }else if(p1Character == 2){
          image(peacock, width/3, height/2, width/4, width/4);
        }else if(p1Character == 3){
          image(robo, width/3, height/2, width/4, width/4);
        }

        if(p2Character == 0){
          image(chicken, width*2/3, height/2, width/4, width/4);
        }else if(p2Character == 1){
          image(dodo, width*2/3, height/2, width/4, width/4);
        }else if(p2Character == 2){
          image(peacock, width*2/3, height/2, width/4, width/4);
        }else if(p2Character == 3){
          image(robo, width*2/3, height/2, width/4, width/4);
        }

        noStroke();
        fill(255, 150);
        quad(width/3+width/20, 0, width/3 - width/20, 0, width/3 - width/8, height*2/3, width/3 + width/8, height*2/3);
      }

      //tutorial
      else if(gameState == 6){
        imageMode(CORNER);
        image(tut, 0, 0, width, height);
      }
    }
  }

  public void keyPressed(){
    //switching gamestates
    if (key == ' '){
      if (gameState == 5 || gameState == 4){
        gameState = 0;
      }else if(gameState == 2){
        p1.resetHealth();
        p2.resetHealth();
        gameState = 3;
      }else if(gameState == 3){
      }else if(gameState == 6){
        gameState = 0;
      }else{
        gameState += 1;
      }
    }else if (key == 'b' && gameState < 0){
      gameState -= 1;
    }

    //gameplay
    if (gameState == 3){
      //p1 movement
      if((key == 'w' || key == 'W') && p1.getJumpState() == false && millis() - p1JumpTimer >= 1){
        p1.jump();
        p1JumpTimer = millis();
      }else if(key == 'a' || key == 'A'){
        p1.moveLeft();
      }else if(key == 'd' || key == 'D'){
        p1.moveRight();
      }

      //p1 attacks
      if((key == 'q' || key == 'Q') && millis() - p1AttackTimer >= 250){
        Projectile projectile = new Projectile(this, p1.getPos(), p1.getVel(), p1.getFacingRight(), 1, 0, p1Character);
        projectiles.add(projectile);
        p1AttackTimer = millis();

        p1runTimer = -3;
      }

      //p2 movement
      if(keyCode == UP && p2.getJumpState() == false && millis() - p2JumpTimer >= 1){
        p2.jump();
        p2JumpTimer = millis();
      }else if(keyCode == LEFT){
        p2.moveLeft();
      }else if(keyCode == RIGHT){
        p2.moveRight();
      }

      //p2 attacks
      if((key == 'l' || key == 'L') && millis() - p2AttackTimer >= 250){
        Projectile projectile = new Projectile(this, p2.getPos(), p1.getVel(), p2.getFacingRight(), 2, 0, p2Character);
        projectiles.add(projectile);
        p2AttackTimer = millis();

        p2runTimer = -3;
      }
    }
  }

  public void keyReleased(){
    if (gameState == 3){
      if(key == 'a' || key == 'A'){
        p1.stopLeft();
      }else if(key == 'd' || key == 'D'){
        p1.stopRight();
      }

      if(keyCode == LEFT){
        p2.stopLeft();
      }else if(keyCode == RIGHT){
        p2.stopRight();
      }
    }
  }

  public void mouseClicked(){
    if(gameState == 0 && mouseX > width/2 - width/12 && mouseX < width/2 + width/12 && mouseY < height*3/4+height/12+height/24 && mouseY > height*3/4+height/12-height/24){
      gameState = 6;
    }else if(gameState == 0 && mouseX > width/2 - width/18 && mouseX < width/2 + width/18 && mouseY < height*3/4+height/24 && mouseY > height*3/4-height/24){
      gameState += 1;
    }

    if(gameState == 2){
      if(mouseX > width/19 && mouseY > height/8 && mouseX < width/19 + width*5/19 && mouseY < height/8 + height*3/4){
        gameState += 1;
        map = 0;
      }else if(mouseX > width*7/19 && mouseY > height/8 && mouseX < width*7/19 + width*5/19 && mouseY < height/8 + height*3/4){
        gameState += 1;
        map = 1;
      }else if (mouseX > width*13/19 && mouseY > height/8 && mouseX < width*13/19 + width*5/19 && mouseY < height/8 + height*3/4){
        gameState += 1;
        map = 2;
      }
    }

    if(gameState == 1){
      if(mouseX > width/5 - width/20 && mouseX < (width/5) + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
        if(p1Character == 0){
          p2Character = -1;
        }else if(p1Character > -1){
          p2Character = 0;
          chickenEgg.disappear();
        }else{
          p1Character = 0;
          chickenEgg.disappear();
        }
      }else if(mouseX > width*2/5 - width/20 && mouseX < width*2/5 + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
        if(p1Character == 1){
          p2Character = -1;
        }else if(p1Character > -1){
          p2Character = 1;
          dodoEgg.disappear();
        }else{
          p1Character = 1;
          dodoEgg.disappear();
        }
      }else if(mouseX > width*3/5 - width/20 && mouseX < width*3/5 + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
        if(p1Character == 2){
          p2Character = -1;
        }else if(p1Character > -1){
          p2Character = 2;
          peacockEgg.disappear();
        }else{
          p1Character = 2;
          peacockEgg.disappear();
        }
      }else if(mouseX > width*4/5 - width/20 && mouseX < width*4/5 + width/20 && mouseY > height/3 - height/8 && mouseY < height/3 + height/8){
        if(p1Character == 3){
          p2Character = -1;
        }else if(p1Character > -1){
          p2Character = 3;
          roboEgg.disappear();
        }else{
          p1Character = 3;
          roboEgg.disappear();
        }
      }
    }

    if(mouseX > width - width/20 - width/80 && mouseY > width/20 - width/80 && mouseX < width - width/20 + width/80 && mouseY < width/20 + width/80){
      paused = true;
    }

    if(paused == true){
      /*
      add code on different buttons
      */
    }
  }

  public static void main(String[] args){
    PApplet.main("Project");
  }
}
