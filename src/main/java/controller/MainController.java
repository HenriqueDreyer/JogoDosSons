package controller;

import javafx.event.ActionEvent;
//import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.Animal;
import services.ImageService;
import services.SomService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;

public class MainController implements Initializable {

    private GameController gameController;

    private static Animal animal1;
    private static Animal animal2;
    private static Animal animal3;
    private static Animal animal4;

    public int somA, imagemA;
    
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
    @FXML Label labelCorreto1, labelCorreto2, labelCorreto3, labelCorreto4;
    
    public void initialize(URL location, ResourceBundle resources) {
        gameController = GameController.getInstance();        
        
        this.carregarAnimais();
        
        animal1Image.setImage(ImageService.getAnimalImage(animal1));
        animal2Image.setImage(ImageService.getAnimalImage(animal2));
        animal3Image.setImage(ImageService.getAnimalImage(animal3));
        animal4Image.setImage(ImageService.getAnimalImage(animal4));
        
        buttonAnimal1.setOnAction(new EventHandler<ActionEvent>() {            
            public void handle(ActionEvent event) {                                                                                                
                labelCorreto1.setVisible(true);
                animal1Image.setBlendMode(BlendMode.LIGHTEN);
        //        buttonAnimal1.setDisable(true);  
        //        imagemA = animal1.getId();
            }
        });
        
        buttonSom1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {                
                SomService.playSom(animal1);
                //somA = animal1.getId();
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
        MainController.animal1 = gameController.getRandomAnimal();
        MainController.animal2 = gameController.getRandomAnimal();
        MainController.animal3 = gameController.getRandomAnimal();
        MainController.animal4 = gameController.getRandomAnimal();        
    }
}
