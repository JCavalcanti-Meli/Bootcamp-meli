package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StarWarsRepository extends JpaRepository<StarWarsModel, String>{

	List<StarWarsModel> findByNameLike(String name);

	List<StarWarsModel> findByNameLikeIgnoreCase(String name);

	

}
