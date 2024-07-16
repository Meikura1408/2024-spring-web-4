package org.java.spring_web4.web.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.pojo.Farmer;
import org.java.spring_web4.db.serv.FarmService;
import org.java.spring_web4.db.serv.FarmerService;
import org.java.spring_web4.web.data.dto.FarmerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private FarmService farmService;

    @GetMapping("/test/add")
    public ResponseEntity<Void> addTestEntity() {

        Farm farm1 = new Farm("Farm1", "Rome");
        Farm farm2 = new Farm("Farm2", "NewYork");
        Farm farm3 = new Farm("Farm3", "Naples");

        farmService.save(farm1);
        farmService.save(farm2);
        farmService.save(farm3);

        Farmer farmer1 = new Farmer("Giovanni", "Cappelletti", 30, farm1);
        Farmer farmer2 = new Farmer("Andrea", "Ceccarelli", 25, farm2);
        Farmer farmer3 = new Farmer("Clarissa", "Serni", 40, farm3);

        farmerService.save(farmer1);
        farmerService.save(farmer2);
        farmerService.save(farmer3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Farmer>> getAllFarmers() {

        List<Farmer> farmers = farmerService.getAllFarmer();
        return ResponseEntity.ok(farmers);
    }

    @PostMapping("")
    public ResponseEntity<Farmer> addFarmer(@RequestBody FarmerDto farmerDto) {
        
        Farmer farmer = new Farmer(farmerDto);

        Optional<Farm> optFarm = farmService.getFarmById(farmerDto.getFarmId());

        if (optFarm.isEmpty())
            return ResponseEntity.badRequest().build();

        Farm farm = optFarm.get();
        farmer.setFarm(farm);

        farmerService.save(farmer);

        return ResponseEntity.ok(farmer);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<Void> deleteFarmer(@PathVariable int id) {

        Optional<Farmer> optFarmer = farmerService.getFarmerById(id);

        if (optFarmer.isEmpty())
            return ResponseEntity.notFound().build();

        Farmer farmer = optFarmer.get();
        farmerService.delete(farmer);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable int id, @RequestBody FarmerDto farmerDto) {
        Optional<Farmer> optFarmer = farmerService.getFarmerById(id);
        if (optFarmer.isEmpty())
            return ResponseEntity.notFound().build();

        Farmer farmer = optFarmer.get();
        farmer.update(farmerDto);

        Optional<Farm> optFarm = farmService.getFarmById(farmerDto.getFarmId());
        if (optFarm.isEmpty())
            return ResponseEntity.badRequest().build();

        Farm farm = optFarm.get();
        farmer.setFarm(farm);

        farmerService.save(farmer);
        return ResponseEntity.ok(farmer);
    }

}
