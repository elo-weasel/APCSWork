import processing.core.*;

public class Projectile{
  public Projectile(PApplet p, PVector pos, PVector vel, boolean facingRight){
    pPos = new PVector(0,0);
    pPos.x = pos.x;
    pPos.y = pos.y;
    this.p = p;
    boolean placeholder = facingRight;
    pFacingRight = placeholder;

    /*if(facingRight == true){
      pVel = new PVector(2, 0);
    }else{
      pVel = new PVector(-2, 0);
    }
    pAcc = new PVector(0, 0.15f);*/

    if(pFacingRight == true){
      pVel = new PVector(10 + 10 * vel.x,-1);
    }else{
      pVel = new PVector(-10 + 10 * vel.x,-1);
    }

  }

  //updates and displays projectile
  public void update(){
    pVel.y += 0.02;
    pPos.add(pVel);

    p.ellipse(pPos.x,pPos.y,8,8);
  }

  public boolean outOfScreen(){
    return pPos.x > p.width || pPos.x < 0 || pPos.y > p.height || pPos.y < 0;
  }

  private PApplet p;
  private PVector pPos;
  private PVector pVel;
  private boolean pFacingRight;
  private int c;
}
