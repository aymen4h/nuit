
package babyfoot;

//import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;



public class Selectteam {
    private static ImageView team1;
    private static ImageView team2;
    private ImageView real;
    private ImageView chelsea;
    private ImageView barcelone;
    private ImageView psg;
    private ImageView mancity;
    private ImageView manunited;
    private ImageView arsenal;
    private ImageView liverpool;
    private ImageView bayern;
    private Scene scene;
    
    
    private ImageView real2;
    private ImageView chelsea2;
    private ImageView barcelone2;
    private ImageView psg2;
    private ImageView mancity2;
    private ImageView manunited2;
    private ImageView arsenal2;
    private ImageView liverpool2;
    private ImageView bayern2;
    
    
    private GridPane grid1;
    private GridPane grid2;
    private Button btn;
    private Button btn1;
    private HBox hbox;
    
    
    
    public Selectteam(Stage stage){
        
        real = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\real.png");
        chelsea = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\chelsea.png");
        barcelone = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\barcelone.png");
        psg = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\psg.png");
        mancity = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\mancity.png");
        manunited = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\manunited.png");
        arsenal = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\arsenal.png");
        liverpool = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\liverpool.png");
        bayern = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\bayern.png");
        
        
        real2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\real.png");
        chelsea2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\chelsea.png");
        barcelone2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\barcelone.png");
        psg2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\psg.png");
        mancity2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\mancity.png");
        manunited2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\manunited.png");
        arsenal2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\arsenal.png");
        liverpool2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\liverpool.png");
        bayern2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\bayern.png");
        
        
        //grid1
        grid1 = new GridPane();
        grid1.setId("grid1");
        grid1.setPadding(new Insets(10));
        grid1.setHgap(10);
        grid1.setVgap(10);
        
        //remplir grid1 
        grid1.add(real, 0, 1);
        grid1.add(chelsea, 1, 1);
        grid1.add(barcelone, 2, 1);
        grid1.add(psg, 0, 2);
        grid1.add(mancity, 1, 2);
        grid1.add(manunited, 2, 2);
        grid1.add(arsenal, 0, 3);
        grid1.add(liverpool, 1, 3);
        grid1.add(bayern, 2, 3);
        
        //grid2
        grid2 = new GridPane();
        grid2.setId("grid2");
        grid2.setPadding(new Insets(10));
        grid2.setHgap(10);
        grid2.setVgap(10);
        
        //remplir grid2
        grid2.add(real2, 0, 1);
        grid2.add(chelsea2, 1, 1);
        grid2.add(barcelone2, 2, 1);
        grid2.add(psg2, 0, 2);
        grid2.add(mancity2, 1, 2);
        grid2.add(manunited2, 2, 2);
        grid2.add(arsenal2, 0, 3);
        grid2.add(liverpool2, 1, 3);
        grid2.add(bayern2, 2, 3);
        
        //button next
        btn = new Button("next");
        btn.setId("btn");
        btn.setOnMouseClicked(e -> {
            if(team1 != null && team2 != null){
                BabyFoot babyfoot = new BabyFoot(stage);
                stage.setScene(babyfoot.getScene());
                stage.setFullScreen(true);
                
            }
            
        });
        
        //bouton fullscreen
        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M18 7h4v2h-6V3h2v4zM8 9H2V7h4V3h2v6zm10 8v4h-2v-6h6v2h-4zM8 15v6H6v-4H2v-2h6z");
        btn1 = new Button();
        btn1.setId("btn1");
        btn1.setGraphic(svgPath);
        btn1.setOnMouseClicked(e -> {
            if(stage.isFullScreen()){
                svgPath.setContent("M16 3h6v6h-2V5h-4V3zM2 3h6v2H4v4H2V3zm18 16v-4h2v6h-6v-2h4zM4 19h4v2H2v-6h2v4z");
                btn1.setGraphic(svgPath);
                stage.setFullScreen(false);
            }
            else{
                svgPath.setContent("M18 7h4v2h-6V3h2v4zM8 9H2V7h4V3h2v6zm10 8v4h-2v-6h6v2h-4zM8 15v6H6v-4H2v-2h6z");
                btn1.setGraphic(svgPath);
                stage.setFullScreen(true);
            }
        });
        
        
        VBox vbox= new VBox();
        vbox.getChildren().add(btn);
        vbox.getChildren().add(btn1);
        
        hbox = new HBox(); 
        hbox.setId("hbox");
        hbox.getChildren().add(grid1);
        hbox.getChildren().add(vbox);
        hbox.getChildren().add(btn);
        hbox.getChildren().add(grid2);
        
        hbox.setAlignment(Pos.CENTER);
        
        
        
        scene = new Scene(hbox);
        
        
        
        
        //css
        scene.getStylesheets().add(Selectteam.class.getResource("selectteam.css").toExternalForm());
        
        //selectionner l'equipe1
        real.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\real.png");
        grid1.add(team1, 1, 0);});
        chelsea.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\chelsea.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        barcelone.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\barcelone.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        psg.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\psg.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        mancity.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\mancity.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        manunited.setOnMouseClicked(e ->{team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\manunited.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        arsenal.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\arsenal.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        liverpool.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\liverpool.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        bayern.setOnMouseClicked(e -> {team1 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\bayern.png");
        grid1.add(team1, 1, 0);team1.setId("team1");});
        
        
        
        
        //selectionner l'équipe2
        real2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\real.png");
        grid2.add(team2, 1, 0);
        });
        chelsea2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\chelsea.png");
        grid2.add(team2, 1, 0);});
        barcelone2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\barcelone.png");
        grid2.add(team2, 1, 0);});
        psg2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\psg.png");
        grid2.add(team2, 1, 0);});
        mancity2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\mancity.png");
        grid2.add(team2, 1, 0);});
        manunited2.setOnMouseClicked(e ->{team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\manunited.png");
        grid2.add(team2, 1, 0);});
        arsenal2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\arsenal.png");
        grid2.add(team2, 1, 0);});
        liverpool2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\liverpool.png");
        grid2.add(team2, 1, 0);});
        bayern2.setOnMouseClicked(e -> {team2 = new ImageView("C:\\Users\\msime\\Desktop\\TP_JAVA\\BabyFoot\\src\\babyfoot\\bayern.png");
        grid2.add(team2, 1, 0);});
        
        stage.setFullScreen(true);
        
        

        
        stage.setScene(scene);
        stage.show();
    }
    

    public Scene getScene() {
        return scene;
    }

    public static ImageView getTeam1() {
        return team1;
    }

    public static ImageView getTeam2() {
        return team2;
    }
    

}
