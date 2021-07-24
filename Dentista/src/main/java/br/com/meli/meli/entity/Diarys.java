package br.com.meli.meli.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Diarys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime start_time;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ending_time;

    @ManyToOne
   // @JsonManagedReference
    private Dentists dentist;

    @OneToMany
    @JsonBackReference
    private List<Turns> turn;

    public Diarys(long id, LocalDateTime start_time, LocalDateTime ending_time, Dentists dentist, List<Turns> turn) {
        this.id = id;
        this.start_time = start_time;
        this.ending_time = ending_time;
        this.dentist = dentist;
        this.turn = turn;
    }

    public Diarys() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnding_time() {
        return ending_time;
    }

    public void setEnding_time(LocalDateTime ending_time) {
        this.ending_time = ending_time;
    }

    public Dentists getDentist() {
        return dentist;
    }

    public void setDentist(Dentists dentist) {
        this.dentist = dentist;
    }

    public List<Turns> getTurn() {
        return turn;
    }

    public void setTurn(List<Turns> turn) {
        this.turn = turn;
    }
}
