package br.com.meli.meli.repository;

import br.com.meli.meli.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

}
