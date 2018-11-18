package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import model.Animal;
import services.AnimalService;
import services.ImageService;
import services.SomService;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private GameController gameController;

    private static Animal animal1;
    private static Animal animal2;
    private static Animal animal3;
    private static Animal animal4;

    @FXML Button buttonSom1;
    @FXML Button buttonSom2;
    @FXML Button buttonSom3;
    @FXML Button buttonSom4;
    @FXML Button buttonAnimal1;
    @FXML Button buttonAnimal2;
    @FXML Button buttonAnimal3;
    @FXML Button buttonAnimal4;
    @FXML ImageView animal1Image;
    @FXML ImageView animal2Image;
    @FXML ImageView animal3Image;
    @FXML ImageView animal4Image;

    public void initialize(URL location, ResourceBundle resources) {
        gameController = GameController.getInstance();

        this.carregarAnimais();

        animal1Image.setImage(ImageService.getAnimalImage(animal1));
        animal2Image.setImage(ImageService.getAnimalImage(animal2));
        animal3Image.setImage(ImageService.getAnimalImage(animal3));
        animal4Image.setImage(ImageService.getAnimalImage(animal4));

        buttonSom1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SomService.playSom(animal1);
            }
        });

        buttonSom2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SomService.playSom(animal2);
            }
        });

        buttonSom3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SomService.playSom(animal3);
            }
        });

        buttonSom4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SomService.playSom(animal4);
            }
        });
    }

    private void carregarAnimais() {
        this.animal1 = gameController.getRandomAnimal();
        this.animal2 = gameController.getRandomAnimal();
        this.animal3 = gameController.getRandomAnimal();
        this.animal4 = gameController.getRandomAnimal();
    }
}
