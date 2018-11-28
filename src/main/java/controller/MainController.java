package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.Animal;
import services.ImageService;
import services.SomService;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;

public class MainController implements Initializable {

    private GameController gameController;

    private Animal[] animalList;
    private Animal[] animalEmbaralhado;
    
    private static Animal animal1;
    private static Animal animal2;
    private static Animal animal3;
    private static Animal animal4;

    private Animal animalSelecionado, somSelecionado;
    private int pontos = 0;
    
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
    @FXML ImageView telaVitoria;
    @FXML Label labelCorreto1, labelCorreto2, labelCorreto3, labelCorreto4;
    
    public void initialize(URL location, ResourceBundle resources) {
        gameController = GameController.getInstance();

        this.carregarAnimais();

        animal1Image.setImage(ImageService.getAnimalImage(animal1));
        animal2Image.setImage(ImageService.getAnimalImage(animal2));
        animal3Image.setImage(ImageService.getAnimalImage(animal3));
        animal4Image.setImage(ImageService.getAnimalImage(animal4));

        iniciarListas();
        embaralhar();

        tocarSom(buttonSom1, animalEmbaralhado[0]);
        tocarSom(buttonSom2, animalEmbaralhado[1]);
        tocarSom(buttonSom3, animalEmbaralhado[2]);
        tocarSom(buttonSom4, animalEmbaralhado[3]);
        
        escolherAnimal(buttonAnimal1, animal1);
        escolherAnimal(buttonAnimal2, animal2);
        escolherAnimal(buttonAnimal3, animal3);
        escolherAnimal(buttonAnimal4, animal4);
    }

    private void carregarAnimais() {
        animal1 = gameController.getRandomAnimal();
        animal2 = gameController.getRandomAnimal();
        animal3 = gameController.getRandomAnimal();
        animal4 = gameController.getRandomAnimal();
    }

    private void iniciarListas() {
        animalEmbaralhado = new Animal[4];
        animalList = new Animal[4];
        animalList[0] = animal1;
        animalList[1] = animal2;
        animalList[2] = animal3;
        animalList[3] = animal4;
    }

    private void embaralhar() {        
        int posicao;
        Random gerador = new Random();

        for (Animal animalL : animalList) {
            do {
                posicao = gerador.nextInt(4);
            } while (animalEmbaralhado[posicao] != null);
            animalEmbaralhado[posicao] = animalL;
        }
    }

    public void tocarSom(final Button btn, final Animal animal) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SomService.playSom(animal);
                somSelecionado = animal;                
            }
        });
    }
    
    private void escolherAnimal(final Button btn, final Animal animal) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                animalSelecionado = animal;

                if (pontos == 3)
                    telaVitoria.setVisible(true);

                if ((somSelecionado != null) && (animalSelecionado.getNome().equals(somSelecionado.getNome()))) {
                    if (btn.getId().equals("1")) {
                        labelCorreto1.setVisible(true);
                        animal1Image.setBlendMode(BlendMode.LIGHTEN);
                        buttonAnimal1.setDisable(true);
                        buttonAnimal1.setBlendMode(BlendMode.LIGHTEN);
                        pontos+=1;
                    }
                    if (btn.getId().equals("2")) {
                        labelCorreto2.setVisible(true);
                        animal2Image.setBlendMode(BlendMode.LIGHTEN);
                        buttonAnimal2.setDisable(true);
                        buttonAnimal2.setBlendMode(BlendMode.LIGHTEN);
                        pontos+=1;
                    }
                    if (btn.getId().equals("3")) {
                        labelCorreto3.setVisible(true);
                        animal3Image.setBlendMode(BlendMode.LIGHTEN);
                        buttonAnimal3.setDisable(true);
                        buttonAnimal3.setBlendMode(BlendMode.LIGHTEN);
                        pontos+=1;
                    }
                    if (btn.getId().equals("4")) {
                        labelCorreto4.setVisible(true);
                        animal4Image.setBlendMode(BlendMode.LIGHTEN);
                        buttonAnimal4.setDisable(true);
                        buttonAnimal4.setBlendMode(BlendMode.LIGHTEN);
                        pontos+=1;
                    }
                } else {
                    somSelecionado = null;
                }
            }
        });
    }
}