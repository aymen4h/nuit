package babyfoot;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.image.Image;

public class Lass {
    private double posX;
    private double posY;
    private double oldY;
    private double height;
    private double width;
    private double speedX;
    private double speedY;
    
    private double longue;
    private double tete;
   
    private Image douu0av;
    
    private Image douu1av;
   
    private Image douu2av;
    public Lass(){
        posX = 165.5;
        posY = 300;
        oldY = 300;
        height = 52.5;
        width = 27;
        speedX = 0;
        speedY = 0;
        longue = 70;
        tete = 16;
        douu0av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu0av.png");
        douu1av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu1av.png");
        douu2av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu2av.png");
    }
    public void speed(double rotation, double angle){
        speedY =( posY - oldY) * 0.01;
        speedX = longue * rotation * cos(angle) / 1000;
    }
    public void setPosY(double posY) {
        this.posY = 601.25 - (posY +35);
        
    }
    public void setPosX(double angle) {
        this.posX = 165.5 + (longue * sin(angle));
    }
    public void setOldY(double oldY) {
        this.oldY = oldY + 113.75;
        
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

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getOldY() {
        return oldY;
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

    public double getSpeedY() {
        return speedY;
    }

    public double getTete() {
        return tete;
    }
    
}
