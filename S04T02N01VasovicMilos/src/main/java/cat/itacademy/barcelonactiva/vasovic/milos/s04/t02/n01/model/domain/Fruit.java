package cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="frutas")
@Getter @Setter @NoArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="quantityKg")
    private String quantityKg;

    public Fruit (String name, String quantityKg){
        this.name = name;
        this.quantityKg = quantityKg;
    }

}
