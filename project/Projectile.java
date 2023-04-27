import processing.core.*;

public class Projectile{
  public Projectile(PApplet p, PVector pos, PVector vel, boolean facingRight, int c, float arc){
    pPos = new PVector(0,0);
    pPos.x = pos.x;
    pPos.y = pos.y;
    this.p = p;
    boolean placeholder = facingRight;
    pFacingRight = placeholder;
    this.c = c;
    this.arc = arc;

    if(pFacingRight == true){
      pVel = new PVector((float)1.5*(p.width/100/6*5), arc);
    }else{
      pVel = new PVector(-(float)1.5*(p.width/100/6*5), arc);
    }

  }

  //updates and displays projectile
  public void update(){
    pVel.y -= arc/30;
    pPos.add(pVel);

    p.fill(255);
    p.ellipse(pPos.x,pPos.y,p.width/100,p.width/100);
  }

  public boolean outOfScreen(){
    return pPos.x > p.width || pPos.x < 0 || pPos.y > p.height || pPos.y < 0;
  }

  public boolean touchingCharacter(Character character){
    if(pPos.x-(p.width/100) < character.getPos().x+(p.width/100) && pPos.x+(p.width/100) > character.getPos().x-(p.width/100) && pPos.y - (p.width/200) < character.getPos().y+(p.width/100) && pPos.y + (p.width/200) > character.getPos().y-(p.width/100)){
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
}
