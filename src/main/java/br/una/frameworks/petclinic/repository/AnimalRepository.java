package br.una.frameworks.petclinic.repository;

import br.una.frameworks.petclinic.entity.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>{
    List<Animal> findByNomeLike(String nome);
}
