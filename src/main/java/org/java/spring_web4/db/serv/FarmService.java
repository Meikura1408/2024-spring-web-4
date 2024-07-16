package org.java.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.repo.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAllFarm() {
        return farmRepository.findAll();
    }

    public Optional<Farm> getFarmById(int id) {
        return farmRepository.findById(id);
    }

    public void save(Farm farm) {
        farmRepository.save(farm);
    }

    public void delete(Farm farm) {
        farmRepository.delete(farm);
    }
}
