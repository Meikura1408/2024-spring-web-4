package org.java.spring_web4.db.pojo;


import org.java.spring_web4.web.data.dto.FarmerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Farmer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 128)
    private String surname;

    @Column(nullable = false)
    private int age;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Farm farm;

    public Farmer(FarmerDto farmerDto) {}

    public Farmer(String name, String surname, int age, Farm farm) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setFarm(farm);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void update(FarmerDto farmerDto) {

        setName(farmerDto.getName());
        setSurname(farmerDto.getSurname());
        setAge(farmerDto.getAge());

    }

    @Override
    public String toString() {

        return "Farmer{\n" +
                "\tid=" + id + ",\n" +
                "\tname='" + name + '\'' + ",\n" +
                "\tsurname='" + surname + '\'' + ",\n" +
                "\tage=" + age + ",\n" +
                "}";
    }
}
