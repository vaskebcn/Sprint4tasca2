package cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.vasovic.milos.s04.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fruit")
public class Controller {

    @Autowired
    FruitRepository fruitRepository;

    @PostMapping("/add")
    public ResponseEntity<Fruit>createFruit(@RequestBody Fruit fruit){

        try{
            Fruit _fruit = fruitRepository.save(new Fruit(fruit.getName(), fruit.getQuantityKg()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(fruitRepository.save(fruit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit>updateFruit(@RequestBody Fruit fruit, @PathVariable("id") int id){
        Optional<Fruit>fruitData = fruitRepository.findById(id);

        if(fruitData.isPresent()){
            Fruit _fruit = fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setQuantityKg(fruit.getQuantityKg());
            return new ResponseEntity<>(fruitRepository.save(_fruit), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruit>deleteFruit(@PathVariable("id") int id){
        try{
            fruitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneById(@PathVariable int id){
        Optional<Fruit>fruitData = fruitRepository.findById(id);

        if(fruitData.isPresent()){
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(@RequestParam (required = false) String name){

        try {
            List<Fruit> fruits = new ArrayList<>();
            if (name == null) {
                fruitRepository.findAll().forEach(fruits::add);
            } else {
                fruitRepository.findByName(name).forEach(fruits::add);
            }

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        }
            catch(Exception e){
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

