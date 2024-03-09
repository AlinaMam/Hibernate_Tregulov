package org.example.test.onetoone_bi;

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
    @OneToOne(mappedBy = "citizen", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", nameCountry='" + nameCountry + '\'' +
                ", nacionality='" + nacionality + '\'' +
                '}';
    }
}
