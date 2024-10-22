package fr.efrei.arene.services;

import fr.efrei.arene.models.Arene;
import fr.efrei.arene.repositories.AreneRepository;
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

        public void save(Arene arene) {
        areneRepository.save(arene);
    }

    public void delete(String id) {
       areneRepository.deleteById(id);
    }

    public void update(String id, Arene areneBody) {
        Arene areneAModifier = findById(id);
        areneAModifier.setName(areneBody.getName());
        areneAModifier.setLevel(areneBody.getLevel());
        areneRepository.save(areneAModifier);
    }

    public void partialUpdate(String id, Arene areneBody) {
        Arene areneAModifier = findById(id);

        if(areneBody.getName() != null) {
            areneAModifier.setName(areneBody.getName());
        }
        if(areneBody.getLevel() != 0) {
            areneAModifier.setLevel(areneBody.getLevel());
        }
        areneRepository.save(areneAModifier);
    }
}
