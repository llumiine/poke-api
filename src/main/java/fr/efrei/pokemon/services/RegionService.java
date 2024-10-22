package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Region;
import fr.efrei.pokemon.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    // Trajet de la donnée
    // Base de données -> Entité -> Repository -> Service -> Controller
    public List<Region> findAll() {
        // SELECT * FROM pokemon;
        return regionRepository.findAll();
    }

    public Region findById(String id) {
        // Optional : soit l'objet soit null
        // SELECT * FROM pokemon WHERE id = :id
        return regionRepository.findById(id).orElse(null);
    }

    // Trajet de la donnée
    // Controller -> Service -> Repository -> Entité -> BDD
    public void save(Region pokemon) {
        // INSERT INTO pokemon VALUES (:name, :level, :type);
        regionRepository.save(pokemon);
    }

    public void delete(String id) {
        // DELETE FROM pokemon WHERE id = :id
        regionRepository.deleteById(id);
    }

    public void update(String id, Region regionBody) {
        Region regionAModifier = findById(id);
        regionAModifier.setType(regionBody.getType());
        regionAModifier.setName(regionBody.getName());
        regionAModifier.setLevel(regionBody.getLevel());
        regionRepository.save(regionAModifier);
    }

    public void partialUpdate(String id, Pokemon pokemonBody) {
        Region regionAModifier = findById(id);
        if(regionBody.getType() != null) {
            regionAModifier.setType(pokemonBody.getType());
        }
        if(regionBody.getName() != null) {
            regionAModifier.setName(regionBody.getName());
        }
        if(pokemonBody.getLevel() != 0) {
            regionAModifier.setLevel(regionBody.getLevel());
        }
        regionRepository.save(regionAModifier);
    }
}
