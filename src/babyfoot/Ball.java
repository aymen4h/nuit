
package babyfoot;

import javafx.scene.paint.Color;


public class Ball {
    private double ballX;
    private double ballY;
    private double speedX;
    private double speedY;
    private double radius;
    private Color ballColor;
    public Ball(double x,double y,double sx,double sy,Color c,double r){
        ballX = x;
        ballY = y;
        speedX = sx;
        speedY = sy;
        ballColor = c;
        radius = r;
    }
    public void moveball(Dou dou , Dou2 dou2 , Lass lass, Lass2 lass2){
        ballX += speedX;
        ballY += speedY;
        //lorsque la ball touche le coté haut et bas du canvas
        if(ballY <= 35 ){
            speedY *= -1;
            ballY = 35;
        }
        else if(ballY+radius >= BabyFoot.getHeight() - 35){
            speedY *= -1;
            ballY = BabyFoot.getHeight() - 35 - radius;
        }
        //lorsque la ball touche le coté gauche et droit du canvas
        if(ballX <= 120|| ballX+radius >= 1180){
            if(((ballY + (1/4) * radius) < 295) ||((ballY + (3/4) * radius) > 476) ){
                speedX *= -1;
                
            }
        }
        if(((ballY + (1/4) * radius) >= 295) &&((ballY + (3/4) * radius) <= 476) ){
            if(ballX <= 120 - (radius / 2)){
                BabyFoot.setStart(false);
                BabyFoot.setScoree2();
                BabyFoot.setScore2(BabyFoot.getScoree2());
            }
            if((ballX+(radius / 2) >= 1180)){
                BabyFoot.setStart(false);
                BabyFoot.setScoree1();
                BabyFoot.setScore1(BabyFoot.getScoree1());
            }
        }
        touchDou(dou);
        touchDou2(dou2);
        touchLass(lass);
        touchLass2(lass2);
    
    }
    
    
    public void touchDou(Dou dou){
        //lorsque la ball touche les cotés verticale du dou
        if(((ballY + radius/2)>= (dou.getPosY() - 2) && ((ballY + radius/2)<= (dou.getPosY() + dou.getHeight() + 2 ))) ||((ballY + radius/2)>= (dou.getPosY() + dou.getSpace() - 2) && ((ballY + radius/2)<= (dou.getPosY() + dou.getHeight() + dou.getSpace() + 2 )))  ) {
            if((ballX <= (dou.getPosX() +dou.getWidth()))&& (ballX > dou.getPosX()) ) {
                ballX = dou.getPosX() + dou.getWidth();
                if(speedX <= (dou.getSpeedX())){
                    
                    speedX = dou.getSpeedX();
                    speedY = dou.getSpeedY() * 0.1;
                }
            }
            else if(  (ballX+radius >= dou.getPosX()) && ((ballX + radius) <  (dou.getPosX() + dou.getWidth()) ) ){
                ballX = dou.getPosX() - radius;
                if(speedX >= (dou.getSpeedX())){
                    
                    speedX = dou.getSpeedX();
                    speedY = dou.getSpeedY() * 0.1;
                }
            }
        }
        
        //lorsque la ball touche les cotés horizontales du dou
        if(((ballX + radius/2) >= (dou.getPosX() - 2)) &&((ballX + radius/2) <= (dou.getPosX() + dou.getWidth() + 2))){
            /*if(((ballY <= (dou.getPosY() + dou.getHeight()) ) &&(ballY > dou.getPosY())) || ((ballY <= (dou.getPosY() + dou.getSpace() + dou.getHeight()) ) &&(ballY > (dou.getPosY() + dou.getSpace() )))){
                if(speedY <= dou.getSpeedY()){
                    speedY = dou.getSpeedY();
                    speedX = dou.getSpeedX() * 0.01;
                }
            }*/
            
            
            if((ballY <= (dou.getPosY() + dou.getHeight()) ) &&(ballY > dou.getPosY())){
                ballY = dou.getPosY() + dou.getHeight();
                if(speedY <= dou.getSpeedY()){
                    speedY = dou.getSpeedY();
                    speedX = dou.getSpeedX() * 0.1;
                }
            }
            else if ((ballY <= (dou.getPosY() + dou.getSpace() + dou.getHeight()) ) &&(ballY > (dou.getPosY() + dou.getSpace() ))){
                ballY = dou.getPosY() + dou.getHeight() + dou.getSpace();
                if(speedY <= dou.getSpeedY()){
                    speedY = dou.getSpeedY();
                    speedX = dou.getSpeedX() * 0.1;
                }
            }
            
            
            
            else if(((ballY + radius) >= dou.getPosY() ) && ((ballY + radius) < (dou.getPosY() + dou.getHeight())) ) {
                ballY = dou.getPosY() - radius;
                if(speedY >= dou.getSpeedY()){
                    speedY = dou.getSpeedY();
                    speedX = dou.getSpeedX() * 0.1;
                }
            }
            else if(((ballY + radius ) >= (dou.getPosY() + dou.getSpace() ) ) &&((ballY + radius ) < (dou.getPosY() + dou.getSpace() + dou.getHeight() ))){
                ballY = dou.getPosY() + dou.getSpace() - radius;
                if(speedY >= dou.getSpeedY()){
                    speedY = dou.getSpeedY();
                    speedX = dou.getSpeedX() * 0.1;
                }
            }
            
        }
        //lorsque la ball entre dou et coté du canvas
        if(((ballX + radius/2) >= dou.getPosX() - 2) &&((ballX + radius/2) <= (dou.getPosX() + dou.getWidth() + 2))){
            
            if(ballY < dou.getPosY() ){
                
                if( dou.getPosY() <= radius + 35){
                    ballY = dou.getPosY() + dou.getHeight() + 3;
                   
                }
                
            }
            else if(ballY >= (dou.getPosY() + dou.getSpace()) ){
                if((dou.getPosY() + dou.getSpace() + dou.getHeight() + radius) >= BabyFoot.getHeight() - 35){
                    ballY = dou.getPosY() + dou.getSpace() - radius- 3;
                }
            }
        }
    }
    public void touchDou2(Dou2 dou2){
        //lorsque la ball touche les cotés verticale du dou2
        if(((ballY + radius/2)>= (dou2.getPosY() - 2) && ((ballY + radius/2)<= (dou2.getPosY() + dou2.getHeight() + 2 ))) ||((ballY + radius/2)>= (dou2.getPosY() + dou2.getSpace() - 2) && ((ballY + radius/2)<= (dou2.getPosY() + dou2.getHeight() + dou2.getSpace() + 2 )))  ) {
            if((ballX <= (dou2.getPosX() +dou2.getWidth()))&& (ballX > dou2.getPosX()) ) {
                ballX = dou2.getPosX() + dou2.getWidth();
                speedX *= -1;
                
            }
            else if(  (ballX+radius >= dou2.getPosX()) && ((ballX + radius) <  (dou2.getPosX() + dou2.getWidth()) ) ){
                ballX = dou2.getPosX() - radius;
                speedX *= -1;
            }
        }
        
        //lorsque la ball touche les cotés horizontales du dou2
        if(((ballX + radius/2) >= (dou2.getPosX() - 2)) &&((ballX + radius/2) <= (dou2.getPosX() + dou2.getWidth() + 2))){
            
            if((ballY <= (dou2.getPosY() + dou2.getHeight()) ) &&(ballY > dou2.getPosY())){
                ballY = dou2.getPosY() + dou2.getHeight();
                speedY *= -1;
            }
            else if ((ballY <= (dou2.getPosY() + dou2.getSpace() + dou2.getHeight()) ) &&(ballY > (dou2.getPosY() + dou2.getSpace() ))){
                ballY = dou2.getPosY() + dou2.getHeight() + dou2.getSpace();
                speedY *= -1;
            }
            
            
            
            else if(((ballY + radius) >= dou2.getPosY() ) && ((ballY + radius) < (dou2.getPosY() + dou2.getHeight())) ) {
                ballY = dou2.getPosY() - radius;
                speedY *= -1;
            }
            else if(((ballY + radius ) >= (dou2.getPosY() + dou2.getSpace() ) ) &&((ballY + radius ) < (dou2.getPosY() + dou2.getSpace() + dou2.getHeight() ))){
                ballY = dou2.getPosY() + dou2.getSpace() - radius;
                speedY *= -1;
            }
            
        }
        //lorsque la ball entre dou2 et coté du canvas
        if(((ballX + radius/2) >= dou2.getPosX() - 2) &&((ballX + radius/2) <= (dou2.getPosX() + dou2.getWidth() + 2))){
            
            if(ballY < dou2.getPosY() ){
                
                if( dou2.getPosY() <= radius + 35){
                    ballY = dou2.getPosY() + dou2.getHeight() + 3;
                   
                }
                
            }
            else if(ballY >= (dou2.getPosY() + dou2.getSpace()) ){
                if((dou2.getPosY() + dou2.getSpace() + dou2.getHeight() + radius) >= BabyFoot.getHeight() - 35){
                    ballY = dou2.getPosY() + dou2.getSpace() - radius- 3;
                }
            }
        }
    }
    public void touchLass(Lass lass){
        //lorsque la ball touche les cotés verticale du lass
        if((ballY + radius/2)>= (lass.getPosY() - 2) && ((ballY + radius/2)<= (lass.getPosY() + lass.getHeight() + 2 )))   {
            if((ballX <= (lass.getPosX() +lass.getWidth()))&& (ballX > lass.getPosX()) ) {
                ballX = lass.getPosX() + lass.getWidth();
                if(speedX <= (lass.getSpeedX())){
                    
                    speedX = lass.getSpeedX();
                    speedY = lass.getSpeedY() * 0.1;
                }
            }
            else if(  (ballX+radius >= lass.getPosX()) && ((ballX + radius) <  (lass.getPosX() + lass.getWidth()) ) ){
                ballX = lass.getPosX() - radius;
                if(speedX >= (lass.getSpeedX())){
                    
                    speedX = lass.getSpeedX();
                    speedY = lass.getSpeedY() * 0.1;
                }
            }
        }
        
        //lorsque la ball touche les cotés horizontales du lass
        if(((ballX + radius/2) >= (lass.getPosX() - 2)) &&((ballX + radius/2) <= (lass.getPosX() + lass.getWidth() + 2))){
            
            
            if((ballY <= (lass.getPosY() + lass.getHeight()) ) &&(ballY > lass.getPosY())){
                ballY = lass.getPosY() + lass.getHeight();
                if(speedY <= lass.getSpeedY()){
                    speedY = lass.getSpeedY();
                    speedX = lass.getSpeedX() * 0.1;
                }
            }
            
            
            else if(((ballY + radius) >= lass.getPosY() ) && ((ballY + radius) < (lass.getPosY() + lass.getHeight())) ) {
                ballY = lass.getPosY() - radius;
                if(speedY >= lass.getSpeedY()){
                    speedY = lass.getSpeedY();
                    speedX = lass.getSpeedX() * 0.01;
                }
            }
            
            
        }
        //lorsque la ball entre dou et coté du canvas
        /*if(((ballX + radius/2) >= dou.getPosX() - 2) &&((ballX + radius/2) <= (dou.getPosX() + dou.getWidth() + 2))){
            
            if(ballY < dou.getPosY() ){
                
                if( dou.getPosY() <= radius + 35){
                    ballY = dou.getPosY() + dou.getHeight() + 3;
                   
                }
                
            }
            else if(ballY >= (dou.getPosY() + dou.getSpace()) ){
                if((dou.getPosY() + dou.getSpace() + dou.getHeight() + radius) >= BabyFoot.getHeight() - 35){
                    ballY = dou.getPosY() + dou.getSpace() - radius- 3;
                }
            }
        }*/
    }
    public void touchLass2(Lass2 lass2){
        //lorsque la ball touche les cotés verticale du dou
        if((ballY + radius/2)>= (lass2.getPosY() - 2) && ((ballY + radius/2)<= (lass2.getPosY() + lass2.getHeight() + 2 )))   {
            if((ballX <= (lass2.getPosX() +lass2.getWidth()))&& (ballX > lass2.getPosX()) ) {
                ballX = lass2.getPosX() + lass2.getWidth();
                speedX *= -1;
            }
            else if(  (ballX+radius >= lass2.getPosX()) && ((ballX + radius) <  (lass2.getPosX() + lass2.getWidth()) ) ){
                ballX = lass2.getPosX() - radius;
                speedX *= -1;
            }
        }
        
        //lorsque la ball touche les cotés horizontales du dou
        if(((ballX + radius/2) >= (lass2.getPosX() - 2)) &&((ballX + radius/2) <= (lass2.getPosX() + lass2.getWidth() + 2))){
            
            
            if((ballY <= (lass2.getPosY() + lass2.getHeight()) ) &&(ballY > lass2.getPosY())){
                ballY = lass2.getPosY() + lass2.getHeight();
                speedY *= -1;
            }
            
            
            else if(((ballY + radius) >= lass2.getPosY() ) && ((ballY + radius) < (lass2.getPosY() + lass2.getHeight())) ) {
                ballY = lass2.getPosY() - radius;
                speedY *= -1;
            }
            
            
        }
        //lorsque la ball entre lass2 et coté du canvas
        if(((ballX + radius/2) >= lass2.getPosX() - 2) &&((ballX + radius/2) <= (lass2.getPosX() + lass2.getWidth() + 2))){
            
            if(ballY < lass2.getPosY() ){
                
                if( lass2.getPosY() <= radius + 35){
                    ballY = lass2.getPosY() + lass2.getHeight() + 3;
                   
                }
                
            }
            else if(ballY >= (lass2.getPosY()) ){
                if((lass2.getPosY() + lass2.getHeight() + radius) >= BabyFoot.getHeight() - 35){
                    ballY = lass2.getPosY()- radius- 3;
                }
            }
        }
    
    }

    public double getBallX() {
        return ballX;
    }

    public double getBallY() {
        return ballY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getRadius() {
        return radius;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallX(double ballX) {
        this.ballX = ballX;
    }

    public void setBallY(double ballY) {
        this.ballY = ballY;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    
    
    
}
