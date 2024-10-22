package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.services.AreneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arenes")
public class AreneController {

    private final AreneService service;

    @Autowired
    public AreneController(AreneService service) {
        this.service = service;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Arene>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arene> findById(@PathVariable String id) {
        Arene pokemon = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Arene arene) {
        service.save(arene);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Arene arene) {
        Arene areneAModifier = service.findById(id);
        if (areneAModifier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, arene);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Arene arene = service.findById(id);
        if(arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
        public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Arene areneBody) {
        Arene arene = service.findById(id);
        if(arene == null) {
            return new ResponseEntity< >(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, areneBody);
        return new ResponseEntity< >(HttpStatus.NO_CONTENT);
    }
}
