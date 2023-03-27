package cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n01.model.domain.Fruit;
import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    List<Fruit> findByName(String name);

    @Override
    List<Fruit> findAll();
}
