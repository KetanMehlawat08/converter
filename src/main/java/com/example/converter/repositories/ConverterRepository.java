package com.example.converter.repositories;

import com.example.converter.entities.Converter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConverterRepository extends ReactiveMongoRepository<Converter, String> {

}
