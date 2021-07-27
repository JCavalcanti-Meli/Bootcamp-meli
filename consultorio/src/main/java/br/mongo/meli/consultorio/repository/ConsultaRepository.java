package br.mongo.meli.consultorio.repository;

import br.mongo.meli.consultorio.entities.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    List<Consulta> findByStatus (String consult);

    List<Consulta> findByDoctorFirstName (String name);


}
