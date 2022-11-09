package com.example.FarmersApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feeds {
    @Id
    private Integer id;
    private String name;
    private String ratio;
    private String weight;

    public Feeds() {}

    public Feeds(Integer id, String name, String ratio, String weight) {
        this.id = id;
        this.name = name;
        this.ratio = ratio;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Feeds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ratio='" + ratio + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

}
