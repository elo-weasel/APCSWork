import processing.core.*;

public class Platform{
  public Platform(PApplet p, float xPos, float yPos, float width, float height){
    this.p = p;
    this.xPos = xPos;
    this.yPos = yPos;
    this.width = width;
    this.height = height;
  }

  public void display(int map){
    p.noStroke();
    if(map == 0){
      p.fill(0, 70, 84);
    }else if(map == 1){
      p.fill(44, 74, 32);
    }else{
      p.fill(110, 0, 16);
    }
    p.rect(xPos, yPos, width, height);
  }

  public float getXPos(){return xPos;}
  public float getYPos(){return yPos;}
  public float getWidth(){return width;}
  public float getHeight(){return height;}

  private PApplet p;
  private float xPos;
  private float yPos;
  private float width;
  private float height;
}
