package cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FruitRepository extends MongoRepository<Fruit, ObjectId> {
    List<Fruit> findByName(String name);
}
