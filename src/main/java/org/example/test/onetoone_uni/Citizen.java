package org.example.test.onetoone_uni;

import javax.persistence.*;

@Entity
@Table(name = "citizens")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String nameCountry;
    @Column(name = "nacionality")
    private String nacionality;

    public Citizen() {
    }

    public Citizen(String nameCountry, String nacionality) {
        this.nameCountry = nameCountry;
        this.nacionality = nacionality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String country) {
        this.nameCountry = country;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", country='" + nameCountry + '\'' +
                ", nacionality='" + nacionality + '\'' +
                '}';
    }
}
