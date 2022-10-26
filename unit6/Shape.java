import processing.core.*;

public class Shape{
    public Shape(PApplet p, int posX, int posY, int color, float size){
        this.p = p;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.size = size;

        random = (int)(Math.random()*3);
        tilt = p.random((float)(2*Math.PI));
        time = 0;
    }

    public void display(){
      p.stroke(255, 255, 255, 255 - time);
      p.noFill();
      p.strokeWeight(5);

      if (random == 1){
        p.ellipse(posX, posY, size*2, size*2);
      }else if (random == 2){
        p.pushMatrix();
        p.translate(posX, posY);
        p.rotate(tilt);
        p.rect(- size, - size, size*2, size*2);
        p.popMatrix();
      }else{
        p.pushMatrix();
        p.translate(posX, posY);
        p.rotate(tilt);
        p.triangle(0, - size, size, size, - size, size);
        p.popMatrix();
      }

      time += 3;
    }

    public int getTime(){
      return time;
    }

    private PApplet p;
    private float posX;
    private float posY;
    private int color;
    private float size;
    private int random;
    private float tilt;
    private int time;
}
