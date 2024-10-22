package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.repositories.AreneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreneService {

    private final AreneRepository areneRepository;

    @Autowired
    public AreneService(AreneRepository areneRepository) {
        this.areneRepository = areneRepository;
    }

    public List<Arene> findAll() {
        return areneRepository.findAll();
    }

    public Arene findById(String id) {
        return areneRepository.findById(id).orElse(null);
    }

    public void save(Arene pokemon) {
        areneRepository.save(pokemon);
    }

    public void delete(String id) {
       areneRepository.deleteById(id);
    }

    public void update(String id, Arene pokemonBody) {
        Arene pokemonAModifier = findById(id);
        AreneAModifier.setType(areneBody.getType());
        areneAModifier.setName(areneBody.getName());
        areneAModifier.setLevel(areneBody.getLevel());
        areneRepository.save(pokemonAModifier);
    }

    public void partialUpdate(String id, Arene areneBody) {
        Arene pokemonAModifier = findById(id);
        if(areneBody.getType() != null) {
            areneAModifier.setType(areneBody.getType());
        }
        if(areneBody.getName() != null) {
            areneAModifier.setName(areneBody.getName());
        }
        if(areneBody.getLevel() != 0) {
            areneAModifier.setLevel(areneBody.getLevel());
        }
        areneRepository.save(areneAModifier);
    }
}
