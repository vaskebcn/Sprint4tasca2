package cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n02.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    List<Fruit> findByName(String name);
}
