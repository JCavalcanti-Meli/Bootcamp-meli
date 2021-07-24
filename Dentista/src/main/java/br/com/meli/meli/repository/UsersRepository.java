package br.com.meli.meli.repository;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
