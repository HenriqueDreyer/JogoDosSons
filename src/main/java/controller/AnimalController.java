package controller;

import model.Animal;
import services.AnimalService;

import java.util.List;

public class AnimalController {

    private AnimalController(){}

    /**
     * Retorna todos os animais do banco
     * @return List<Animal>
     * @author Henrique Dreyer - HJSD
     */
    public static List<Animal> listarTodos(){
        return AnimalService.listar();
    }

    /**
     * Cadastra um animal no banco
     * @param animal
     * @author Henrique Dreyer - HJSD
     */
    public static void adicionar(Animal animal){
        AnimalService.add(animal);
    }

    /**
     * Gera animais aleatorios
     * @return List<Animal>
     * @author Henrique Dreyer - HJSD
     */
    public static List<Animal> random(){ return AnimalService.radom(); }
}
