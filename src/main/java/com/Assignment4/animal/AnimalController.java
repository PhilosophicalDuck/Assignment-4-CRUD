package com.Assignment4.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animal")

public class AnimalController {
    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animal/all
     *
     * @return a list of Animals objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animal/2
     *
     * @param animalId the unique Id for a Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Get a list of Animals based on their name.
     * http://localhost:8080/animal?name=blue
     *
     * @param name the search key.
     * @return A list of Animal objects that contains the search key.
     */
    @GetMapping
    public List<Animal> findByNameContaining(@RequestParam String name) {
        return service.findByName(name);
    }

    /**
     * Get a list of animals with a certain species.
     * http://localhost:8080/animal?species=amphibian
     *
     * @param animalClass the type of species
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/animalClass?animalClass={animalClass}")
    public List<Animal> getAnimalClass(@RequestParam(name = "animalClass", defaultValue = "") String animalClass) {
        return service.getAnimalsByAnimalClass(animalClass);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animal/new --data '{"animalId": 4, "name": "duck", "animalClass": "duck", "scientificName": "something", "habitat" : "pond", "description": "featherly" }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animal.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animal/update/2 --data '{}'
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animal/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}
