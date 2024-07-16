package org.java.spring_web4.web.data.dto;

public class FarmerDto {
 
    private String name;
    private String surname;
    private int age;
    private int farmId;


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
    public int getFarmId() {
        return farmId;
    }
    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public void update(FarmerDto farmerDto) {

        setName(farmerDto.getName());
        setSurname(farmerDto.getSurname());
        setAge(farmerDto.getAge());

    }

    @Override
    public String toString() {

        return "FarmerDto{\n" +
                "\tid=" + farmId + ",\n" +
                "\tname='" + name + '\'' + ",\n" +
                "\tsurname='" + surname + '\'' + ",\n" +
                "\tage=" + age + ",\n" +
                "}";
    }
}
