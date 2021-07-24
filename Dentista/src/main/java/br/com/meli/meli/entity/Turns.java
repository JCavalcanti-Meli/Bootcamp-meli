package br.com.meli.meli.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Turns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate day;

    @ManyToOne
    private Patients patient;

    @ManyToOne
    @JsonBackReference
    private Turn_status turnStatus;

    @ManyToOne
    @JsonBackReference
    private Diarys diary;

    public Turns(long id, LocalDate day, Patients patient, Turn_status turnStatus, Diarys diary) {
        this.id = id;
        this.day = day;
        this.patient = patient;
        this.turnStatus = turnStatus;
        this.diary = diary;
    }

    public Turns() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Turn_status getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(Turn_status turnStatus) {
        this.turnStatus = turnStatus;
    }

    public Diarys getDiary() {
        return diary;
    }

    public void setDiary(Diarys diary) {
        this.diary = diary;
    }
}
