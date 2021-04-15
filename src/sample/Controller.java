package sample;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.util.Random;

public class Controller {

    @FXML
    private AnchorPane AnchorPaneSet2;

    @FXML
    private Button buttonKey;

    @FXML
    private AnchorPane AnchorPaneMenu;

    @FXML
    private Label labelOnStartMenu;

    @FXML
    private Button buttonOnStartMenu;


    public void initialize() {
        AnchorPaneMenu.setVisible(true);
        AnchorPaneSet2.setVisible(false);
        initMenu();
    }

    private void initMenu() {
        buttonOnStartMenu.setText("Ready?");
        labelOnStartMenu.setText("Начало игры");
        buttonOnStartMenu.setOnAction(actionEvent -> {
            AnchorPaneMenu.setVisible(false);
            initGame();
        });
        xPosition = buttonKey.getLayoutX();
        yPosition = buttonKey.getLayoutY();

    }

    Double xPosition, yPosition;
    double newColor;

    private void initGame() {
        AnchorPaneSet2.setVisible(true);

        buttonKey.setOnAction(actionEvent -> {
            buttonKey.setLayoutX(getRandomPosition(buttonKey.getPrefWidth(), AnchorPaneSet2.getPrefWidth()));
            buttonKey.setLayoutY(getRandomPosition(buttonKey.getPrefHeight(), AnchorPaneSet2.getPrefHeight()));
            AnchorPaneSet2.setBackground(new Background(new BackgroundFill(getRandomColor(),CornerRadii.EMPTY, Insets.EMPTY)));
        });
    }


    private int getRandomPosition(double sizeElement, double maxValue) {
        Random random = new Random();
        return random.nextInt( (int)maxValue - (int)sizeElement);
    }

    private void clearAllPos() {
        AnchorPaneSet2.setBackground(new Background(new BackgroundFill(Color.color(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonKey.setLayoutX(0);
        buttonKey.setLayoutY(0);
    }

    private Color getRandomColor() {
        Random random = new Random();
        double red = (double)random.nextInt(100)/100;
        double green = (double)random.nextInt(100)/100;
        double blue = (double)random.nextInt(100)/100;
        System.out.printf("red = %f, green = %f, blue = %f \n", red, green, blue);
        return Color.color(red, green, blue);
    }


}
