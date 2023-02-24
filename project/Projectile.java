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

    /*if(facingRight == true){
      pVel = new PVector(2, 0);
    }else{
      pVel = new PVector(-2, 0);
    }
    pAcc = new PVector(0, 0.15f);*/

    if(pFacingRight == true){
      pVel = new PVector(7 + 10 * vel.x, arc);
      //pVel = new PVector(10 + 10 * vel.x,-1);
    }else{
      //pVel = new PVector(-10 + 10 * vel.x,-1);
      pVel = new PVector(-7 + 10 * vel.x, arc);
    }

  }

  //updates and displays projectile
  public void update(){
    pVel.y -= arc/30;
    pPos.add(pVel);

    p.ellipse(pPos.x,pPos.y,8,8);
  }

  public boolean outOfScreen(){
    return pPos.x > p.width || pPos.x < 0 || pPos.y > p.height || pPos.y < 0;
  }

  public boolean touchingCharacter(Character character){
    if(pPos.x-6 < character.getPos().x+6 && pPos.x+6 > character.getPos().x-6 && pPos.y - 4 < character.getPos().y+6 && pPos.y + 4 > character.getPos().y-6){
      return true;
    }else{
      return false;
    }
  }

  public int belongsTo(){return c;}

  public PVector getPos(){return pPos;}
  public float getSize(){return 8;}

  private PApplet p;
  private PVector pPos;
  private PVector pVel;
  private boolean pFacingRight;
  private int c;
  private float arc;
}
