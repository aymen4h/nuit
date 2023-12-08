package babyfoot;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Baby extends Application {
    private int imageIndex = 0;
    private String[] imageNames = {"bk1.jpg", "bk2.jpg", "bk3.jpg"};
    
    @Override
    public void start(Stage stage) {
        

        
        Button fullscreenButton = new Button("\u26F6");
        fullscreenButton.setOnAction(e -> stage.setFullScreen(true));
        StackPane.setAlignment(fullscreenButton, Pos.TOP_LEFT);
        fullscreenButton.setStyle("-fx-border-color: transparent;-fx-font-weight: bold;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-size: 20px;");
        stage.setFullScreen(true);
        
        Button btn = new Button();
        btn.setText("Appuyer pour continuer");
        btn.setStyle("-fx-border-color: transparent;-fx-font-weight: bold;-fx-background-color: transparent;-fx-text-fill: white;-fx-font-size: 20px;");
        
        
        btn.setOnAction(event -> {
    
    // code pour afficher l'image de fond et les boutons
    Image backgroundImage = new Image("file:src/babyfoot/bk.jpg");
    BackgroundSize backgroundSize = new BackgroundSize(1504, 1000, true, true, true, false);
    BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    StackPane root = new StackPane();
    root.setBackground(new Background(background));
    Label label = new Label();
    label.setStyle("-fx-text-fill: white;-fx-font-size: 40px;-fx-font-weight: bold;");
    
    
    
    
    // Ajout de boutton
    Image buttonImage1 = new Image("file:src/babyfoot/arbitrator.jpg");
    ImageView imageView1 = new ImageView(buttonImage1);
    Button imageButton1 = new Button();
    imageButton1.setGraphic(imageView1);
    imageButton1.setOnMouseEntered(e -> {
    label.setText("Sélectionner l'arbitre");});
    imageButton1.setOnMouseExited(e -> {
    label.setText("");});
    
    root.getChildren().add(imageButton1);
    
    Image buttonImage2 = new Image("file:src/babyfoot/stadium.jpg");
    ImageView imageView2 = new ImageView(buttonImage2);
    Button imageButton2 = new Button();
    imageButton2.setGraphic(imageView2);
    imageButton2.setOnMouseEntered(e -> {
    label.setText("Sélectionner le stade");});
    imageButton2.setOnMouseExited(e -> {
    label.setText("");});
    root.getChildren().add(imageButton2);
    
    Image buttonImage3 = new Image("file:src/babyfoot/time.jpg");
    ImageView imageView3 = new ImageView(buttonImage3);
    Button imageButton3 = new Button();
    imageButton3.setGraphic(imageView3);
    imageButton3.setOnMouseEntered(e -> {
    label.setText("Sélectionner le temps");});
    imageButton3.setOnMouseExited(e -> {
    label.setText("");});
    root.getChildren().add(imageButton3);
    
    Image buttonImage4 = new Image("file:src/babyfoot/team.jpg");
    ImageView imageView4 = new ImageView(buttonImage4);
    Button imageButton4 = new Button();
    imageButton4.setGraphic(imageView4);
    imageButton4.setOnMouseEntered(e -> {
    label.setText("Sélectionner l'equipe");});
    imageButton4.setOnMouseExited(e -> {
    label.setText("");});
    imageButton4.setOnAction(e -> {
        Selectteam selectteam = new Selectteam(stage);
        stage.setScene(selectteam.getScene());
        stage.setFullScreen(true);
    });
    root.getChildren().add(imageButton4);
    
    imageView1.setFitWidth(250);imageView1.setFitHeight(200);
    imageView2.setFitWidth(250);imageView2.setFitHeight(200);
    imageView3.setFitWidth(250);imageView3.setFitHeight(200);
    imageView4.setFitWidth(250);imageView4.setFitHeight(200);
    
    GridPane grid = new GridPane();
    grid.add(imageButton1, 0, 0);
    grid.add(imageButton2, 1, 0);
    grid.add(imageButton3, 0, 1);
    grid.add(imageButton4, 1, 1);
    grid.setAlignment(Pos.BOTTOM_CENTER);
    root.getChildren().add(grid);
      

    // bouton plein écran
    Button fullscreenButton1 = new Button("\u26F6");
    fullscreenButton1.setOnAction(e -> stage.setFullScreen(true));
    StackPane.setAlignment(fullscreenButton1, Pos.TOP_LEFT);
    root.getChildren().add(fullscreenButton1);
    
    // bouton paramétres
    Button settingButton = new Button("\u2699");
    settingButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        ContextMenu contextMenu = new ContextMenu();
        
        MenuItem menuItem1 = new MenuItem("Muet");
        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Code pour gérer le clic sur l'option 1
            }
        });
        
        MenuItem menuItem2 = new MenuItem("About Us");
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Code pour gérer le clic sur l'option 1
                try {Desktop.getDesktop().browse(new URI("https://github.com/aymen4h"));} catch (IOException | URISyntaxException e) {e.printStackTrace();}
            }
        });
        
        contextMenu.getItems().add(menuItem1);
        contextMenu.getItems().add(menuItem2);
        contextMenu.show(settingButton, Side.LEFT, -5, 40);
    }
});
    
    StackPane.setAlignment(settingButton, Pos.TOP_RIGHT);
    StackPane.setAlignment(label, Pos.TOP_CENTER);
    root.getChildren().add(settingButton);
    root.getChildren().add(label);

    Scene scene = new Scene(root, 1500, 750);
    scene.getStylesheets().add(getClass().getResource("style1.css").toExternalForm());
    stage.setScene(scene);
        stage.setFullScreen(true);});

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(fullscreenButton);
        StackPane.setAlignment(btn,Pos.BOTTOM_CENTER);
        
        //Changement du Background
        setBackgroundImage(root);
        Timeline timebk = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            setBackgroundImage(root);
        }));
        timebk.setCycleCount(Animation.INDEFINITE);
        timebk.play();
        
        //effet clignotement
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.7), evt -> btn.setVisible(!btn.isVisible())));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(root, 1500, 750);

        stage.setTitle("Launcher");
        stage.setScene(scene);
        stage.show();

    }

    private void setBackgroundImage(StackPane root) {
        // Set the background image
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(getClass().getResource(imageNames[imageIndex]).toExternalForm()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT  );
        
        root.setBackground(new Background(backgroundImage));
        imageIndex = (imageIndex + 1) % imageNames.length;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
