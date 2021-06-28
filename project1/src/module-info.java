module project1 {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.base;
	requires jdk.hotspot.agent;
	
	opens application to javafx.graphics, javafx.fxml;
}
