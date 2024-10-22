package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Region;
import fr.efrei.pokemon.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService service;
    private Region regionBody;

    @Autowired
    public RegionController(RegionService service) {
        this.service = service;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Region>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> findById(@PathVariable String id) {
        Region region = service.findById(id);
        if (region == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Region region) {
        service.save(region);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Region region) {
        Region regionAModifier = service.findById(id);
        if (regionAModifier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, region);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Region region = service.findById(id);
        if(region == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Region regionBody) {
        this.regionBody = regionBody;
        Region region = service.findById(id);
        if(region == null) {
            return new ResponseEntity< >(HttpStatus.NOT_FOUND);
        }
        service.update(id, regionBody);
        return new ResponseEntity< >(HttpStatus.NO_CONTENT);
    }

    public Region getRegionBody() {
        return regionBody;
    }

    public void setRegionBody(Region regionBody) {
        this.regionBody = regionBody;
    }
}
