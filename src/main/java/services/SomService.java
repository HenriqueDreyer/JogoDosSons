package services;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Animal;

import java.io.*;
import java.util.Random;

public class SomService {

    public static void playSom(Animal animal){
        Media media = null;
        try {
            media = new Media(getTempFile(animal.getSom(), animal.getNome()).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getTempFile(byte[] som, String animalName) throws IOException {
        Random random = new Random();
        String fileName;
        //String fileName = random.nextInt(50) + "_sound";
        fileName = animalName + "_sound.mp3";
        File tempFile = new File(fileName);
        if(!tempFile.exists()){
            fileName = animalName + "_sound";
            tempFile = File.createTempFile(fileName, ".mp3", null);
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(som);
            fos.close();
        }
        return tempFile;
    }
}
