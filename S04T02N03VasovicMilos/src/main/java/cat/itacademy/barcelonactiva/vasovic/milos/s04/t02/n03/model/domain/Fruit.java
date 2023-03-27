package cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n03.model.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Document(collection = "fruits")
public class Fruit {

    @Id
    private ObjectId id;
    private String name;
    private String quantityKg;

    public Fruit(String name, String quantityKg){
        this.name = name;
        this.quantityKg = quantityKg;
    }

}
