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

    public void update(String id, Arene areneBody) {
        Arene areneAModifier = findById(id);
        areneAModifier.setName(areneBody.getName());
        areneRepository.save(areneAModifier);
    }

    public void partialUpdate(String id, Arene arenBody) {
        Arene areneAModifier = findById(id);

        if(arenBody.getName() != null) {
            areneAModifier.setName(areneBody.getName());
        }
        areneRepository.save(areneAModifier);
    }
}
