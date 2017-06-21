/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrv_javafx_study;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;


/**
 *
 * @author James R. Vaughan
 */
public class JRV_JavaFX_Study extends Application /*implements EventHandler<ActionEvent>*/ {
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button buttonE;
    Button buttonF;
    Button buttonG;
    Button buttonH;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    
    Button orderButton;
    Button loginButton;
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;
    Label label1;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        Label label1 = new Label("Welcome to the first scene!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));
        
        buttonA = new Button();
        buttonA.setText("Anonymous inner class");
        buttonA.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("I am an anonymous inner class");
            }
        });
        
        buttonB = new Button();
        buttonB.setText("Lambda syntax");
        buttonB.setOnAction(e -> {
            System.out.println("Lambda syntax");
            System.out.println("Lambda syntax2");
        });
        
        buttonC = new Button();
        buttonC.setText("Open alert box");
        buttonC.setOnAction(e -> AlertBox.display("Title of the window", "I am an alert box"));
        
        buttonD = new Button();
        buttonD.setText("Open confirm box");
        buttonD.setOnAction(e -> {
            boolean result =  ConfirmBox.display("Title of the window", "Would you like to confirm?");
            System.out.println(result);
        });

        buttonF = new Button("Go to login scene");
        buttonF.setOnAction(e -> window.setScene(scene3));
        
        buttonG = new Button("Go to sub sandwich scene");
        buttonG.setOnAction(e -> window.setScene(scene4));
        
        buttonH = new Button("Go to choicebox scene");
        buttonH.setOnAction(e -> window.setScene(scene5));
        
        // --------- Exit button ---------- //
        
        buttonE = new Button();
        buttonE.setText("Close program");
        buttonE.setOnAction(e -> closeProgram());
        
        // Scene 2: BorderPane
        // Layout 1: children laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, buttonA, buttonB, buttonC, buttonD, buttonF, buttonG, buttonH, buttonE);
        layout1.setPadding(new Insets(10,10,10,10));
        scene1 = new Scene(layout1, 200, 500);
        
        Button button2 = new Button("Go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        HBox topMenu = new HBox();
        Button button3 = new Button("File");
        Button button4 = new Button("Edit");
        Button button5 = new Button("View");
        topMenu.getChildren().addAll(button3, button4, button5);
        
        VBox leftMenu = new VBox();
        Button button6 = new Button("D");
        Button button7 = new Button("E");
        Button button8 = new Button("F");
        leftMenu.getChildren().addAll(button6, button7, button8);
        
        //StackPane layout2 = new StackPane();
        BorderPane layout2 = new BorderPane();
        //layout2.getChildren().addAll(button2);
        layout2.setTop(topMenu);
        layout2.setLeft(leftMenu);
        layout2.setBottom(button2);
        layout2.setPadding(new Insets(10,10,10,10));
        scene2 = new Scene(layout2, 600, 300);
        
        window.setScene(scene1);
        window.setTitle("Title here");
        window.setOnCloseRequest(e -> {
            e.consume(); // stops closing of window via X button
            closeProgram();
        });
        window.show();
        
        //Scene 3: GridPane
        GridPane layout3 = new GridPane();
        layout3.setPadding(new Insets(10,10,10,10));
        layout3.setVgap(8);
        layout3.setHgap(10);
        
        Label nameLabel = new Label("Username:");
        layout3.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField("Bucky");
        layout3.setConstraints(nameInput, 1, 0);
        
        Label pwLabel = new Label("Password:");
        layout3.setConstraints(pwLabel, 0, 1);
        TextField pwInput = new TextField();
        pwInput.setPromptText("password");
        layout3.setConstraints(pwInput, 1, 1);
        
        Label ageLabel = new Label("Age:");
        layout3.setConstraints(ageLabel, 0, 2);
        TextField ageInput = new TextField();
        layout3.setConstraints(ageInput, 1, 2);
        
        Button loginButton = new Button("Log In");
        layout3.setConstraints(loginButton, 1, 3);
        loginButton.setOnAction(e -> {
            System.out.println("Username: " + nameInput.getText());
            System.out.println("Password: " + pwInput.getText());
            if (validateInteger(ageInput, ageInput.getText())) {
            }
            window.setScene(scene1);
        });
        
        layout3.getChildren().addAll(nameLabel, nameInput, pwLabel, pwInput, ageLabel, ageInput, loginButton);
        
        scene3 = new Scene(layout3, 300, 200);
        
        // Scene 4: Checkbox
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);
        orderButton = new Button("Order Now");
        orderButton.setOnAction(e -> handleOptions(box1, box2));
        
        VBox layout4 = new VBox(10);
        layout4.setPadding(new Insets(10,10,10,10));
        layout4.getChildren().addAll(box1, box2, orderButton);
        scene4 = new Scene(layout4, 300, 200);
        
        // Scene 5: ChoiceBox
        
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().addAll("Pears", "Peaches", "Bacon", "Ham", "Meatballs");
        choiceBox.setValue("Apples");
        
        Button button10 = new Button("Get choice");
        button10.setOnAction(e -> {
            getChoice(choiceBox);
            window.setScene(scene1);
        });
        
        VBox layout5 = new VBox(10);
        layout5.setPadding(new Insets(20, 20, 20, 20));
        layout5.getChildren().addAll(choiceBox, button10);
        scene5 = new Scene(layout5, 300, 200);
        
        
        
        
        //button.setOnAction(this);
        
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//        layout.getChildren().add(button2);
//        
//        
//        Scene scene = new Scene(layout, 300, 250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
    
    private void closeProgram(){
        boolean answer = ConfirmBox.display("Close Program", "Are you sure you want to exit?");
        
        if (answer) {
            System.out.println("File is saved!");
            window.close();
        }
    }
    
    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "User's Order: \n";
        if(box1.isSelected()) message += "Bacon\n";
        if(box2.isSelected()) message += "Tuna\n";
        System.out.println(message);
        window.setScene(scene1);
    }
    
    private void getChoice(ChoiceBox<String> choiceBox){
        System.out.println("Food: " + choiceBox.getValue());
    }
    
    private boolean validateInteger(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("Age: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + input.getText() + " is not a number.");
            return false;
        }
    }

//    @Override
//    public void handle(ActionEvent event) {
//        
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if(event.getSource() == button) {
//            System.out.println("Hello");
//        }
//    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
