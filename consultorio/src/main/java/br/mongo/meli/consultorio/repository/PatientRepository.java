package br.mongo.meli.consultorio.repository;

import br.mongo.meli.consultorio.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
