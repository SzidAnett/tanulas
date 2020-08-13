package com.example.sqlspring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {
    //SELECT * FROM Cat WHERE name=name;
    List<Cat> findAllByName(String name);
    List<Cat> findCatById(Long id);

}
