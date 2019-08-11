package polo.dto;

import java.time.LocalDate;

public class ClientDTO {
    private int id;
    private String img;
    private String name;
    private int age;
    private String gender;
    private String password;
    private double height;
    private double weight;
    private String lifeStyle;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
