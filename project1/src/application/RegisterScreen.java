package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegisterScreen extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	TextField UserName = null, txtUserId = null, txtEmail = null, txtAddress1 = null, txtAddress2 = null,
			txtPhoneNumber = null;
	PasswordField txtPassword1 = null, txtPassword2 = null;

	Label lbl1, Id, User, Password, Email, Number, AddressLine1, AddressLine2, RePassword;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		lbl1 = new Label("Registration New Users");
		Font font1 = new Font("Serif", 25);
		lbl1.setFont(font1);
		lbl1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		lbl1.setLayoutX(65);
		lbl1.setLayoutY(5);

		Line line1 = new Line();
		line1.setStartX(20);
		line1.setStartY(38);
		line1.setEndX(380);
		line1.setEndY(38);
		line1.setStroke(Color.BROWN);

		Id = new Label("Enter UserId");

		txtUserId = new TextField();
		txtUserId.setPrefWidth(250);
		txtUserId.setPromptText("Enter UseId/Log-In Id");

		HBox userName = new HBox(55);
		userName.setLayoutX(10);
		userName.setLayoutY(80);
		userName.getChildren().add(Id);
		userName.getChildren().add(txtUserId);

		Password = new Label("Enter Password");

		PasswordField txtPassword1 = new PasswordField();
		txtPassword1.setPrefWidth(250);
		txtPassword1.setPromptText("Enter Password");

		HBox mail = new HBox(40);
		mail.setLayoutX(10);
		mail.setLayoutY(110);
		mail.getChildren().add(Password);
		mail.getChildren().add(txtPassword1);

		RePassword = new Label("Re-Enter Password");

		PasswordField txtPassword2 = new PasswordField();
		txtPassword2.setPrefWidth(250);
		txtPassword2.setPromptText("Re-Enter Password");

		HBox No = new HBox(22);
		No.setLayoutX(10);
		No.setLayoutY(140);
		No.getChildren().add(RePassword);
		No.getChildren().add(txtPassword2);

		User = new Label("Enter Your Name ");

		UserName = new TextField();
		UserName.setPrefWidth(250);
		UserName.setPromptText("Enter Name");

		HBox AL1 = new HBox(27);
		AL1.setLayoutX(10);
		AL1.setLayoutY(170);
		AL1.getChildren().add(User);
		AL1.getChildren().add(UserName);

		Email = new Label("Enter Emailid");

		txtEmail = new TextField();
		txtEmail.setPrefWidth(250);
		txtEmail.setPromptText("Enter Email-id");

		HBox AL2 = new HBox(52);
		AL2.setLayoutX(10);
		AL2.setLayoutY(200);
		AL2.getChildren().add(Email);
		AL2.getChildren().add(txtEmail);

		Number = new Label("Enter Number");

		txtPhoneNumber = new TextField();
		txtPhoneNumber.setPrefWidth(250);
		txtPhoneNumber.setPromptText("Enter PhoneNumber");

		HBox Uid = new HBox(46);
		Uid.setLayoutX(10);
		Uid.setLayoutY(230);
		Uid.getChildren().add(Number);
		Uid.getChildren().add(txtPhoneNumber);

		AddressLine1 = new Label("AddressLine-1");

		txtAddress1 = new TextField();
		txtAddress1.setPrefWidth(250);
		txtAddress1.setPromptText("Enter FlatNo./Name , Society Name");

		HBox Pass = new HBox(45);
		Pass.setLayoutX(10);
		Pass.setLayoutY(260);
		Pass.getChildren().add(AddressLine1);
		Pass.getChildren().add(txtAddress1);

		AddressLine2 = new Label("AddressLine-2");

		txtAddress2 = new TextField();
		txtAddress2.setPrefWidth(250);
		txtAddress2.setPromptText("Enter Landmark and City");

		HBox Pass2 = new HBox(45);
		Pass2.setLayoutX(10);
		Pass2.setLayoutY(290);
		Pass2.getChildren().add(AddressLine2);
		Pass2.getChildren().add(txtAddress2);

		Button btn = new Button("Register");
		btn.setLayoutX(104);
		btn.setLayoutY(330);
		Font font = Font.font("Courier New", FontWeight.BOLD, 15);
		btn.setFont(font);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					File file = new File("C:\\Users\\vagha\\eclipse-workspace\\project1\\src\\application\\User.txt");
					FileWriter fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					PrintWriter pw = new PrintWriter(br);
					String temp = "\n" + txtUserId.getText() + "  " + txtPassword1.getText() + "  " + UserName.getText()
							+ "  " + txtEmail.getText() + "  " + txtPhoneNumber.getText() + "  " + txtAddress1.getText()
							+ "  " + txtAddress2.getText();
					pw.append(temp);
					pw.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Button butn = new Button("Log-In");
		butn.setLayoutX(228);
		butn.setLayoutY(330);
		Font font5 = Font.font("Courier New", FontWeight.BOLD, 15);
		butn.setFont(font5);
		
		butn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent bc) {
				// TODO Auto-generated method stub
				try {
					new Main().start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Group root = new Group(lbl1, line1, userName, mail, No, AL1, AL2, Uid, Pass, Pass2, btn, butn);
		Scene s = new Scene(root, 400, 380);

		// primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(s);
		primaryStage.setTitle("Register");
		primaryStage.show();
	}

}
