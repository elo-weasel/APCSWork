import processing.core.*;

public class Projectile{
  public Projectile(PApplet p, PVector pos, PVector vel, boolean facingRight, int c, float arc, int bird){
    pPos = new PVector(0,0);
    pPos.x = pos.x;
    pPos.y = pos.y;
    this.p = p;
    boolean placeholder = facingRight;
    pFacingRight = placeholder;
    this.c = c;
    this.arc = arc;
    this.bird = bird;

    if(pFacingRight == true){
      pVel = new PVector((float)1.5*(p.width/100/6*5), arc);
    }else{
      pVel = new PVector(-(float)1.5*(p.width/100/6*5), arc);
    }

    if(bird == 3){
      pVel.x *= 2;
    }
  }

  //updates and displays projectile
  public void update(){
    pVel.y -= arc/30;
    pPos.add(pVel);

    if(bird == 1){
      p.fill(255, 231, 110);
      p.ellipse(pPos.x,pPos.y,p.width/100,p.width/100);
    }else if(bird == 1){
      p.fill(173, 120, 21);
      p.ellipse(pPos.x,pPos.y,p.width/100,p.width/100);
    }else if(bird == 2){
      p.fill(21, 56, 173);
      p.ellipse(pPos.x,pPos.y,p.width/100,p.width/100);
    }else if(bird == 3){
      p.fill(232, 0, 0);
      p.ellipse(pPos.x,pPos.y,p.width/90,p.width/150);
    }
  }

  public boolean outOfScreen(){
    return pPos.x > p.width || pPos.x < 0 || pPos.y > p.height || pPos.y < 0;
  }

  public boolean touchingCharacter(Character character){
    if(pPos.x-(p.width/50) < character.getPos().x+(p.width/50) && pPos.x+(p.width/50) > character.getPos().x-(p.width/50) && pPos.y - (p.width/100) < character.getPos().y+(p.width/50) && pPos.y + (p.width/100) > character.getPos().y-(p.width/50)){
      return true;
    }else{
      return false;
    }
  }

  public int belongsTo(){return c;}
  public PVector getPos(){return pPos;}
  public float getSize(){return p.width/100;}

  private PApplet p;
  private PVector pPos;
  private PVector pVel;
  private boolean pFacingRight;
  private int c;
  private float arc;
  private int bird;
}
