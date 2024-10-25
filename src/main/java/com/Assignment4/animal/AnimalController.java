package com.Assignment4.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@Controller
@RequestMapping("/animal")

public class AnimalController {
    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * <a href="http://localhost:8080/animal/all">All</a>
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animal/2
     *
     * @param animalId the unique Id for a Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model){
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animal-details";
    }

    /**
     * Get a list of Animals based on their name.
     * http://localhost:8080/animal?name=blue
     *
     * @param name the search key.
     * @return A list of Animal objects that contains the search key.
     */
    @GetMapping("/")
    public String findByNameContaining(@RequestParam String name, Model model) {
        model.addAttribute("animalList", service.findByName(name));
        model.addAttribute("title", "Name Animal:" + name);
        return "animal-list";
    }

    /**
     * Get a list of animals with a certain species.
     * http://localhost:8080/animal?species=amphibian
     *
     * @param animalClass the type of species
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/animalClass?animalClass={animalClass}")
    public String getAnimalClass(@RequestParam(name = "animalClass", defaultValue = "") String animalClass, Model model) {
        model.addAttribute("animalList", service.getAnimalsByAnimalClass(animalClass));
        model.addAttribute("title", "Animal Class:"+ animalClass);
        return "animal-list";
    }


    @GetMapping("/createForm")
    public String showCreateForm(){
        return "animal-create";
    }
    /**
     * Create a new Animal entry.
     * http://localhost:8080/animal/new --data '{"animalId": 4, "name": "duck", "animalClass": "duck", "scientificName": "something", "habitat" : "pond", "description": "featherly" }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animal.
     */
    @PostMapping("/new")
    public String addNewAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animal/all";
    }

    public String showUpdateForm(@PathVariable int animalId, Model model){
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-update";
    }
    /**
     * Update an existing Animal object.
     * http://localhost:8080/animal/update/2 --data '{}'
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update Animal details.
     * @return the updated Animal object.
     */
    @GetMapping("/update/{animalId}")
    public String updateAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-update";
    }

    /**
     * Perform the update.
     * @param animal
     * @return
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal){
        service.addNewAnimal(animal);
        return "redirect:/animal/" + animal.getAnimalId();
    }
    /**
     * Delete a Animal object.
     * http://localhost:8080/animal/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return "redirect:/animal/all";
    }
}
