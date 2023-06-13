
package babyfoot;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.image.Image;


public class Dou {
    private double posX;
    private double posY;
    private double oldY;
    private double height;
    private double width;
    private double speedX;
    private double speedY;
    private double space;
    private double longue;
    private double tete;
   // private Image douu0ar;
    private Image douu0av;
    //private Image douu1ar;
    private Image douu1av;
    //private Image douu2ar;
    private Image douu2av;
    public Dou(double y, double h, double w, double sx, double sy, double sp){
        posX = 335.5;
        posY = y;
        oldY = y;
        height = h;
        width = w;
        speedX = sx;
        speedY = sy;
        space = sp;
        longue = 70;
        tete = 16;
        //douu0ar = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu0ar.png");
        douu0av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu0av.png");
        //douu1ar = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu1ar.png");
        douu1av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu1av.png");
        //douu2ar = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu2ar.png");
        douu2av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu2av.png");
        
    }
    
    
    
    
    public void move(){
        posX += speedX;
        posY += speedY;
        
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getSpeedX() {
        return speedX;
    }
    
    public void speed(double rotation, double angle){
        speedY =( posY - oldY) * 0.01;
        speedX = longue * rotation * cos(angle) / 1000;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getSpace() {
        return space;
    }

    public void setPosY(double posY) {
        this.posY = 735 - 20 - space - (posY +35);
    }

    public void setPosX(double angle) {
        this.posX = 335.5 + (longue * sin(angle));
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public double getLongue() {
        return longue;
    }
    
    public Image getIm(double angle){
        if((angle >= (-Math.PI /180)) &&(angle <= (Math.PI / 36)) ){
            return douu0av;
        }
        else if((angle > (Math.PI / 36)) &&(angle <= (Math.PI / 9)) ){
            return douu2av;
            //return douu1av;
        }
        else if((angle > (Math.PI / 9)) &&(angle <= (Math.PI / 4)) ){
            return douu2av;
        }
        else if((angle >= (-Math.PI / 30)) &&(angle < (-Math.PI / 180)) ){
            //return douu0ar;
            return douu0av;
        }
        else if((angle >= (- 7 * Math.PI / 60)) &&(angle < (-Math.PI / 30)) ){
            //return douu1ar;
            //return douu1av;
            return douu2av;
        }
        else{
            //return douu2ar;
            return douu2av;
        }
    }
    public double getImWidth(double angle){
        //return width +  longue * sin(angle);
        if(angle >= 0){
            return (longue + tete) * sin(angle) + width;
        }
        else{
            return (longue + tete) * sin(angle) - width ;
        }
    }
    public double getPosXIm(double angle){
        
        if(angle >= 0){
            return posX - (tete + longue ) * sin(angle) ;
        }
        else{
            return posX + width - (tete + longue ) * sin(angle) ;
        }
        
    }
    
    
}
