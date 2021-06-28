package application;

import javafx.scene.Group;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {

	public static Stage primaryStage;
	public static void main(String[] args) {
		launch(args);
	}

	TextField txtUserName = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		this.primaryStage = primaryStage;
		Circle circle = new Circle();
		circle.setCenterX(175);
		circle.setCenterY(40);
		circle.setRadius(10);
		// circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);

		Arc arc1 = new Arc();
		arc1.setCenterX(178);
		arc1.setCenterY(65);
		arc1.setRadiusX(25);
		arc1.setRadiusY(25);
		arc1.setStartAngle(120);
		arc1.setLength(70);

		Arc arc2 = new Arc();
		arc2.setCenterX(172);
		arc2.setCenterY(65);
		arc2.setRadiusX(25);
		arc2.setRadiusY(25);
		arc2.setStartAngle(350);
		arc2.setLength(70);

		Line line1 = new Line();
		line1.setStartX(50);
		line1.setStartY(80);
		line1.setEndX(300);
		line1.setEndY(80);
		line1.setStroke(Color.BLUEVIOLET);
		
		Text lbl1 = new Text("My First Project");
		Font font1 = new Font("Serif", 25);
		lbl1.setFont(font1);
		lbl1.setLayoutX(96);
		lbl1.setLayoutY(110);
		
		txtUserName = new TextField();
		txtUserName.setLayoutX(53);
		txtUserName.setLayoutY(135);
		txtUserName.setPrefWidth(250);
		txtUserName.setPromptText("Enter Username");


		PasswordField txtPassword = new PasswordField();
		txtPassword.setPromptText("Enter Password");
		txtPassword.setLayoutX(53);
		txtPassword.setLayoutY(175);
		txtPassword.setPrefWidth(250);
		
		
		
		Label lbl2 = new Label("");
		lbl2.setLayoutX(95);
		lbl2.setLayoutY(270);
		lbl2.setTextFill(Color.RED);
		
		
		Button btn1 = new Button("Sing In");
		btn1.setLayoutX(120);
		btn1.setLayoutY(230);
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vagha\\eclipse-workspace\\project1\\src\\application\\User.txt"));
					String temp ;
					Boolean isValid = false;
					while((temp = br.readLine())!=null) {
						String[] up = temp.split("  ");
						
						  if (txtUserName.getText().equals(up[0]) && txtPassword.getText().equals(up[1])) { 
							  isValid = true; 
							  try {
								  new DashBoard().start(primaryStage);
							  } catch (Exception e) {
								  e.printStackTrace();
							  }
							  break; 
						  }
					}
					if(isValid==false) {
						lbl2.setText("UserId/Password doesn't match");
					}
					br.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Button btn2 = new Button("Sign Up");
		btn2.setLayoutX(180);
		btn2.setLayoutY(230);
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent ae) {
				// TODO Auto-generated method stub
				try {
					new RegisterScreen().start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		

		Group root = new Group(circle, arc1, arc2, line1, lbl1, txtUserName, txtPassword, btn1, btn2 , lbl2);
		Scene s = new Scene(root, 350, 350);
		s.setFill(Color.LIGHTGRAY);
		//this.primaryStage.initStyle(StageStyle.UTILITY);
		this.primaryStage.setScene(s);
		this.primaryStage.setTitle("LOGIN");
		this.primaryStage.show();

	}

}
