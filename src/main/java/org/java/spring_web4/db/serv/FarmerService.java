package org.java.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farmer;
import org.java.spring_web4.db.repo.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public List<Farmer> getAllFarmer() {
        return farmerRepository.findAll();
    }

    public Optional<Farmer> getFarmerById(int id) {
        return farmerRepository.findById(id);
    }

    public void save (Farmer farmer) {
        farmerRepository.save(farmer);
    }

    public void delete(Farmer farmer) {
        farmerRepository.delete(farmer);
    }
}
