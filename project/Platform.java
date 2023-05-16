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
    p.fill(255);
    p.rect(xPos, yPos, width, height);
    p.ellipse(xPos, yPos + height/2, height, height);
    p.ellipse(xPos + width, yPos + height/2, height, height);
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
