
package babyfoot;

import javafx.scene.image.Image;


public class Dou2 {
    private double posX;
    private double posY;
    private double height;
    private double width;
    
    private double space;
    private double longue;
    private double tete;
    private Image douu0ar;
    private Image douu1av;
    public Dou2(){
        posX = 955.5;
        posY = 100;
        height = 52.5;
        width = 27;
        space = 227.5;
        longue = 70;
        tete = 16;
        douu0ar = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu0ar.png");
        douu1av = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\douu1av.png");
        
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public double getLongue() {
        return longue;
    }

    public void setLongue(double longue) {
        this.longue = longue;
    }

    public double getTete() {
        return tete;
    }

    public void setTete(double tete) {
        this.tete = tete;
    }

    public Image getDouu0ar() {
        return douu0ar;
    }

    public void setDouu0ar(Image douu0ar) {
        this.douu0ar = douu0ar;
    }

    public Image getDouu1av() {
        return douu1av;
    }

    public void setDouu1av(Image douu1av) {
        this.douu1av = douu1av;
    }
    
}
