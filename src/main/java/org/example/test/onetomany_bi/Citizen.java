package org.example.test.onetomany_bi;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL)
    private List<Person> persons;

    public void addToPersons(Person person) {
        if (persons == null) {
            persons = new ArrayList<>();
        }
        persons.add(person);
    }

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

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", nameCountry='" + nameCountry + '\'' +
                ", nacionality='" + nacionality + '\'' +
                ", persons=" + persons +
                '}';
    }
}
