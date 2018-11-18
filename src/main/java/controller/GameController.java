package controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Animal;
import services.ResourceFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private static GameController instance;
    private static List<Integer> animalSelectded;
    private static List<Animal> animalList;

    private GameController(){
        animalList = AnimalController.random();
        animalSelectded = new ArrayList<Integer>();
    }

    public static GameController getInstance(){
        if(instance == null){
            instance = new GameController();
        }
        return instance;
    }

    public Animal getRandomAnimal(){
        Random rand = new Random();

        Integer index = rand.nextInt(4);
        while(animalSelectded.contains(index)){
            index = rand.nextInt(4);
        }
        animalSelectded.add(index);

        return animalList.get(index);
    }
}
