package br.com.meli.meli.entity;

import br.com.meli.meli.Enum.TurnStatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Turn_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private TurnStatusEnum name;

    private String description;

    @OneToMany
    @JsonBackReference
    private List<Turns> turnsList = new ArrayList<>();

    public Turn_status(long id, TurnStatusEnum name, String description, List<Turns> turnsList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.turnsList = turnsList;
    }

    public Turn_status() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TurnStatusEnum getName() {
        return name;
    }

    public void setName(TurnStatusEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Turns> getTurnsList() {
        return turnsList;
    }

    public void setTurnsList(List<Turns> turnsList) {
        this.turnsList = turnsList;
    }
}
