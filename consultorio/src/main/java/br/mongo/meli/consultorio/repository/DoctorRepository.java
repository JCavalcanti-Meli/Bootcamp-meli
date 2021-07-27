package br.mongo.meli.consultorio.repository;

import br.mongo.meli.consultorio.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
