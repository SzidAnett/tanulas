package com.example.demo.repository;

import com.example.demo.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

}
