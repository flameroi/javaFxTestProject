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
        initMenu();
    }

    private void initMenu() {
        buttonOnStartMenu.setText("Ready?");
        labelOnStartMenu.setText("Начало игры");
        buttonOnStartMenu.setOnAction(actionEvent -> {
            AnchorPaneMenu.setVisible(false);
            initGame();
        });

    }

    Double xPosition, yPosition;
    double newColor;

    private void initGame() {
        AnchorPaneSet2.setVisible(true);

        buttonKey.setOnAction(actionEvent -> {

            if (xPosition == null && yPosition == null) {
                xPosition = buttonKey.getLayoutX();
                yPosition = buttonKey.getLayoutY();
                clearKeyPos();
            } else {
                buttonKey.setLayoutX(buttonKey.getLayoutX() + xPosition / 10);
                buttonKey.setLayoutY(buttonKey.getLayoutY() + yPosition / 10);
                if (buttonKey.getLayoutX() > xPosition) {
                    clearKeyPos();
                }
                else {
                newColor = newColor + 0.1d;
                AnchorPaneSet2.setBackground(new Background(new BackgroundFill(Color.color(newColor, newColor, newColor), CornerRadii.EMPTY, Insets.EMPTY)));
            }}
        });
    }

    private void clearKeyPos() {
        newColor = 0;
        AnchorPaneSet2.setBackground(new Background(new BackgroundFill(Color.color(newColor, newColor, newColor), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonKey.setLayoutX(0);
        buttonKey.setLayoutY(0);
    }


}
