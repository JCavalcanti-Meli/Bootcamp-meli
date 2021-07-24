package br.com.meli.meli.entity;

import br.com.meli.meli.Enum.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String user_name;

    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserStatus user_status;

}
