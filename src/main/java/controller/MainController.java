package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import model.Animal;
import services.AnimalService;
import services.SomService;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    ImageView balaoSom1;

    public void initialize(URL location, ResourceBundle resources) {
        List<Animal> list = AnimalController.listarTodos();
        Animal animal = list.get(0);
        System.out.println(animal.getNome());
        SomService.playSom(animal);
//        for(Animal a : list){
//            System.out.println(a.getNome());
//            SomService.play(a.getSom());
//        }

        balaoSom1.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            public void handle(MouseDragEvent event) {
                System.out.println("CLIQUEI NA IMAGEM BB");
            }
        });
    }


}
