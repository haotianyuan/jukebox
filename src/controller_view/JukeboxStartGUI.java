package controller_view;

/**
 * This program is a functional spike to determine the interactions are 
 * actually working. It is an event-driven program with a graphical user
 * interface to affirm the functionality all Iteration 1 tasks have been 
 * completed and are working correctly. This program will be used to 
 * test your code for the first 100 points of the JukeBox project.
 */
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JukeboxStartGUI extends Application {
	 private Label label1 = new Label("Account Name");
	 private Label label2 = new Label("Password");
	 private TextField textField1 = new TextField("");
	 private TextField textField2 = new TextField("");
	 private Button button1 = new Button("Login");
	 private Label label3 = new Label("Login first");
	 private Button button2 = new Button("Log out");
	 private Button button3 = new Button("Select song 1");
	 private Button button4 = new Button("Select song 2");
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) { 
    GridPane window=new GridPane();
    window.setPadding(new Insets(0, 5, 0, 5));
    GridPane.setHalignment(label2, HPos.RIGHT);
    //GridPane.setHalignment(label1, HPos.LEFT);
    window.setHgap(10);
    window.setVgap(10);
    window.add(label1, 0, 3);
    window.add(label2, 0, 4);
    textField1.setMaxWidth(130);
    window.add(textField1,1,3);
    textField2.setMaxWidth(130);
    window.add(textField2,1,4);
    window.add(button1,1,5);
    window.add(label3,1,6);
    window.add(button2,1,7);
    window.add(button3, 0,0);
    window.add(button4, 1,0);
    
    Scene scene = new Scene(window, 250, 250);
    primaryStage.setScene(scene);
    primaryStage.show();

  }


}