package colorfulcircles;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import static java.lang.Math.random;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ColoourfulCircles extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private final EventHandler<MouseEvent> mouseHandler;

    public ColoourfulCircles() {
        this.mouseHandler = new EventHandler<MouseEvent>() {
            
            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getEventType() + "\n"
                        + "X : Y - " + mouseEvent.getX() + " : " + mouseEvent.getY() + "\n"
                        + "SceneX : SceneY - " + mouseEvent.getSceneX() + " : " + mouseEvent.getSceneY() + "\n"
                        + "ScreenX : ScreenY - " + mouseEvent.getScreenX() + " : " + mouseEvent.getScreenY());
                
                
            };
            
            
        };
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
      
        scene.setOnMouseClicked(mouseHandler);
        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseEntered(mouseHandler);
        scene.setOnMouseExited(mouseHandler);
        scene.setOnMouseMoved(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);
        
        primaryStage.setScene(scene);

        Group circles = new Group();
        
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }
        
        //root.getChildren().add(circles);
        
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
                
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
                    new Stop(0, Color.web("#f8bd55")),
                    new Stop(0.14, Color.web("#c0fe56")),
                    new Stop(0.28, Color.web("#5dfbc1")),
                    new Stop(0.43, Color.web("#64c2f8")),
                    new Stop(0.57, Color.web("#be4af7")),
                    new Stop(0.71, Color.web("#ed5fc2")),
                    new Stop(0.85, Color.web("#ef504c")),
                    new Stop(1, Color.web("#f2660f")),}));
        //colors.setRotate(45);
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        
        //root.getChildren().add(colors);
      
        Group blendModeGroup =
                new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
                Color.BLACK), circles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        //circles.setEffect(new BoxBlur(10, 10, 3));
        
        Timeline timeline = new Timeline();
        for (Node circle : circles.getChildren()) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)),
                    new KeyFrame(new Duration(40000), // set end position at 40s
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)));
        }
        // play 40s of animation
        timeline.play();
        
         scene.setOnKeyTyped(new EventHandler<KeyEvent>() {

                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCharacter().equals("q")){
                            System.out.println("Quit");
                            Platform.exit();
                        }
                        else{
                            System.out.print(event.getCharacter());
                        }
                    }
                });
         
      
        primaryStage.show();
    }  
}
