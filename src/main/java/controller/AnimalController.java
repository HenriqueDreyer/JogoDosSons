package controller;

import model.Animal;
import services.AnimalService;

import java.util.List;

public class AnimalController {

    private AnimalController(){}

    public static List<Animal> listarTodos(){
        return AnimalService.listar();
    }

    public static void adicionar(Animal animal){
        AnimalService.add(animal);
    }
}
