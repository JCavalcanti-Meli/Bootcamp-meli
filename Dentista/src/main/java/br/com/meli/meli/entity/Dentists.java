package br.com.meli.meli.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.asm.TypeReferenceAdjustment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Dentists {

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

    private int code_mp;
    //////////////////
    @OneToMany
    //@JsonBackReference
    private List<Diarys> diarys = new ArrayList<>();

    public Dentists(long id, String name, String last_name, String address, String dni, LocalDate birth_date, int phone, String email, int code_mp, List<Diarys> diarys) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.code_mp = code_mp;
        this.diarys = diarys;
    }

    public Dentists() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCode_mp() {
        return code_mp;
    }

    public void setCode_mp(int code_mp) {
        this.code_mp = code_mp;
    }

    public List<Diarys> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diarys> diarys) {
        this.diarys = diarys;
    }

}
