package application;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DashBoard extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Label lbl1 = new Label("Users DashBoard");
		Font font1 = new Font("Serif", 25);
		lbl1.setFont(font1);
		lbl1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		lbl1.setLayoutX(160);
		lbl1.setLayoutY(5);
		lbl1.setTextFill(Color.BLUE);

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vagha\\eclipse-workspace\\project1\\src\\application\\User.txt"));
		String temp ;
		while((temp = br.readLine())!=null) {
			String[] up = temp.split("  ");
			System.out.println(up[0]);
			System.out.println(up[2]);
		}
		
		Group root = new Group(lbl1);
		Scene s = new Scene(root, 500, 380);

		primaryStage.setScene(s);
		primaryStage.setTitle("DashBoard");
		primaryStage.show();


	}
}
