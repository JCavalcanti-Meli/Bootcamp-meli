package br.com.meli.meli.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private int phone;

    private  String email;

    @OneToMany
    private List<Turns> turnsList = new ArrayList<>();


    public Patients(long id, String name, String last_name, String address, String dni, LocalDate birth_date, int phone, String email, List<Turns> turnsList) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.turnsList = turnsList;
    }

    public Patients() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Turns> getTurnsList() {
        return turnsList;
    }

    public void setTurnsList(List<Turns> turnsList) {
        this.turnsList = turnsList;
    }
}
