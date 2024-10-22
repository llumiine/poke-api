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

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(String id) {
        return regionRepository.findById(id).orElse(null);
    }

    public void save(Region pokemon) {
        regionRepository.save(pokemon);
    }

    public void delete(String id) {
        regionRepository.deleteById(id);
    }

    public void update(String id, Region regionBody) {
        Region regionAModifier = findById(id);
        regionAModifier.setName(regionBody.getName());
        regionRepository.save(regionAModifier);
    }

    public void partialUpdate(String id, Region regionBody) {
        Region regionAModifier = findById(id);

        if(regionBody.getName() != null) {
            regionAModifier.setName(regionBody.getName());
        }
        regionRepository.save(regionAModifier);
    }
}
