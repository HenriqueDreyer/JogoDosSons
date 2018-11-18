package services;

import javafx.scene.image.Image;
import model.Animal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ImageService {

    public static Image getAnimalImage(Animal animal){
        InputStream inputStream = new ByteArrayInputStream(animal.getImagem());
        return new Image(inputStream);
    }
}
