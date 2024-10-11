package com.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Animal Database.
 */
@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;


    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique Animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all Animals whose name matches the search term.
     *
     * @param name the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> findByName(String name) {
        return animalRepository.findByNameContaining(name);
    }

    /**
     * Fetch all Animals whose species matches the search term.
     *
     * @param animalClass the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByAnimalClass(String animalClass) {
        return animalRepository.getAnimalsByAnimalClass(animalClass);
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal Id.
     * @param animal the new Animal details.
     */
    public void updateAnimal(int animalId, Animal animal) {

        //Technically the 4 lines above are not necessary because the save method merges by default.
        Animal existing = getAnimalById(animalId);
        animalRepository.save(existing);
    }

    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Student Id.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}