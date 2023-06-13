
package babyfoot;


import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.SVGPath;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.util.Duration;

import jssc.SerialPort;

import jssc.SerialPortException;

public class BabyFoot{
    final private static double width = 1300;
    final private static double height = 770;
    private static boolean start = false;
    private Image image;
    private Image baguette;
    private Image ballIm;
    private ImagePattern patternBall;
    private ImageView team1;
    private ImageView team2;
    private Canvas canvas;
    private BorderPane border;
    private HBox hbox;
    private VBox vbox;
    private Scene scene;
    private Button btnF;
    private static Text score1;
    private static int scoree1 = 0;
    private static Text score2;
    private static int scoree2 = 0;
    
    
    
    
    public BabyFoot(Stage stage){
        Arduino.serialPort = new SerialPort(Arduino.portName);
       // while(true){
            try {
                Arduino.serialPort.openPort();
                Arduino.serialPort.setParams(Arduino.baudRate, 8, 1, 0); // Paramètres du port série : vitesse, bits de données, bits de stop, parité
                int mask = SerialPort.MASK_RXCHAR; // Masque d'événement : RXCHAR (caractère reçu)
                Arduino.serialPort.setEventsMask(mask);
                Arduino.serialPort.addEventListener(new Arduino());
                //System.out.println("hello");
               // break;
            } catch (SerialPortException ex) {
              System.out.println(ex);
            }
       // }
        
        
        
        image = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\background.png");
        baguette = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\baguette2.png");
        ballIm = new Image("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\ball.png");
        patternBall = new ImagePattern(ballIm);
        
        //bouton fullscreen
        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M18 7h4v2h-6V3h2v4zM8 9H2V7h4V3h2v6zm10 8v4h-2v-6h6v2h-4zM8 15v6H6v-4H2v-2h6z");
        btnF = new Button();
        btnF.setId("btnF");
        btnF.setGraphic(svgPath);
        btnF.setOnMouseClicked(e -> {
            if(stage.isFullScreen()){
                svgPath.setContent("M16 3h6v6h-2V5h-4V3zM2 3h6v2H4v4H2V3zm18 16v-4h2v6h-6v-2h4zM4 19h4v2H2v-6h2v4z");
                btnF.setGraphic(svgPath);
                stage.setFullScreen(false);
            }
            else{
                svgPath.setContent("M18 7h4v2h-6V3h2v4zM8 9H2V7h4V3h2v6zm10 8v4h-2v-6h6v2h-4zM8 15v6H6v-4H2v-2h6z");
                btnF.setGraphic(svgPath);
                stage.setFullScreen(true);
            }
        });
        
        team1 = Selectteam.getTeam1();
        team1.setId("team1");
        
        score1 = new Text(Integer.toString(scoree1));
        score1.setFill(Color.BLUE);
        score1.setId("score1");
        
        team2 = Selectteam.getTeam2();
        team2.setId("team2");
        
        score2 = new Text(Integer.toString(scoree2));
        score2.setId("score2");
        score2.setFill(Color.RED);
        
        
        
        vbox = new VBox();
        vbox.setId("vbox");
        vbox.getChildren().addAll(team1,score1,score2,team2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        
        
        
        canvas = new Canvas(width,height);
        
      
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Ball ball = new Ball(650,340,0.04,0.04,Color.BLANCHEDALMOND,30);
        Dou dou = new Dou(100,52.5,27,0,0,227.5);
        Dou2 dou2 = new Dou2();
        Lass lass = new Lass();
        Lass2 lass2 = new Lass2();
        
        
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(0.1), e -> run(gc, ball , dou,dou2, lass , lass2,  image , baguette , patternBall)));
	tl.setCycleCount(Timeline.INDEFINITE);
        
        
        
        
        canvas.setOnMouseMoved(e ->  {dou2.setPosY(e.getY());
                                      lass2.setPosY(e.getY());
                    });
        
        canvas.setOnMouseClicked(e ->  start = true);
        hbox = new HBox();
        hbox.getChildren().addAll(canvas,vbox);
        
        border = new BorderPane();
        border.setBottom(hbox);
        border.setRight(btnF);
        
        
        
        //hbox.getChildren().add(vbox);
        border.setId("border");
        
       // root.getChildren().add(team1);
        //root.getChildren().add(team2);
        
        
        //hbox.setAlignment(Pos.CENTER);
        scene = new Scene(border);
        scene.getStylesheets().add(BabyFoot.class.getResource("style.css").toExternalForm());
        
       
        
        tl.play();
    }
    private void run(GraphicsContext gc, Ball ball , Dou dou, Dou2 dou2, Lass lass ,Lass2 lass2, Image image, Image baguette, ImagePattern patternBall ) {
        
        gc.clearRect(0, 0, width, height); // Effacer le contenu précédent
    
        gc.drawImage(image, 0, 0, width, height);//background
        
        
        
        
        
        
        
        
        gc.setFill(patternBall);
        gc.fillOval(ball.getBallX(), ball.getBallY(), ball.getRadius(), ball.getRadius());
        
        
        if( start ){
            ball.moveball(dou, dou2, lass , lass2);
        }
        else{
            //commencer
            gc.setFont(new Font("Impact" , 40));
            gc.setFill(Color.PINK);
            gc.fillText("COMMENCER", 550, 280);
            ball.setBallX(340);
            ball.setBallY(340);
            ball.setSpeedX(0);
            ball.setSpeedY(0);
        }
        
        //baguette dou
        gc.drawImage(baguette, 340, 0, 19, height);
        //baguette lass
        gc.drawImage(baguette, 170, 0, 19, height);
        //baguette dou2
        gc.drawImage(baguette, 960, 0, 19, height);
        //baguette lass2
        gc.drawImage(baguette, 1130, 0, 19, height);
        
        
        //dou
        dou.setPosY(Arduino.distance);
        dou.setPosX(Arduino.angle);
        gc.setFill(Color.BLUE);
        gc.fillRect(dou.getPosX(), dou.getPosY() - 2, dou.getWidth(), dou.getHeight()+4);
        gc.drawImage(dou.getIm(Arduino.angle), dou.getPosXIm(Arduino.angle), dou.getPosY(), dou.getImWidth(Arduino.angle), dou.getHeight());
        
        gc.setFill(Color.BLUE);
        gc.fillRect(dou.getPosX(), dou.getPosY() + dou.getSpace() - 2, dou.getWidth(), dou.getHeight()+4);
        gc.drawImage(dou.getIm(Arduino.angle), dou.getPosXIm(Arduino.angle), dou.getPosY() + dou.getSpace(), dou.getImWidth(Arduino.angle), dou.getHeight());
        
        dou.speed(Arduino.rotation, Arduino.angle);
        dou.setOldY(dou.getPosY());
        
        
        //lass
        lass.setPosY(Arduino.distance);
        lass.setPosX(Arduino.angle);
        gc.drawImage(lass.getIm(Arduino.angle), lass.getPosXIm(Arduino.angle), lass.getPosY(), lass.getImWidth(Arduino.angle), lass.getHeight());
        lass.speed(Arduino.rotation, Arduino.angle);
        lass.setOldY(dou.getPosY());
        
        
        //dou2
        
        gc.drawImage(dou2.getDouu0ar(), dou2.getPosX(), dou2.getPosY(), dou2.getWidth() , dou2.getHeight());
        gc.drawImage(dou2.getDouu0ar(), dou2.getPosX(), dou2.getPosY() + dou2.getSpace(), dou2.getWidth(), dou2.getHeight());
        
        //lass2
        
        gc.drawImage(lass2.getDouu0ar(), lass2.getPosX(), lass2.getPosY(), lass2.getWidth(), lass2.getHeight());
        
        
    }

    
   

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }

    public static void setStart(boolean start) {
        BabyFoot.start = start;
    }

    public Scene getScene() {
        return scene;
    }

    public static void setScore1(int scoree1) {
        BabyFoot.score1.setText(Integer.toString(scoree1));
    }

    public static void setScore2(int scoree2) {
        BabyFoot.score2.setText(Integer.toString(scoree2));
    }

    public static int getScoree1() {
        return scoree1;
    }

    public static int getScoree2() {
        return scoree2;
    }

    public static void setScoree1() {
        BabyFoot.scoree1++;
    }

    public static void setScoree2() {
        BabyFoot.scoree2 ++;
    }

    
}
