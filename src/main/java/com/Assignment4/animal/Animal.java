package com.Assignment4.animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String animalClass;

    @Column(nullable = false)
    private String habitat;

    private String scientificName;

    private String description;

    public Animal(int animalIdId, String name, String animalClass, String scientificName, String habitat, String description) {
        this.name = name;
        this.animalClass = animalClass;
        this.scientificName = scientificName;
        this.habitat = habitat;
        this.description = description;
    }

    public Animal(String name, String animalClass, String scientificName, String habitat, String description){
        this.name = name;
        this.animalClass = animalClass;
        this.scientificName = scientificName;
        this.habitat = habitat;
        this.description = description;
    }
    public Animal(){

    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
