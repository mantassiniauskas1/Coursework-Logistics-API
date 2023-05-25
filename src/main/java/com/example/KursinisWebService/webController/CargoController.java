package com.example.KursinisWebService.webController;

import com.example.KursinisWebService.exception.ResourceNotFoundException;
import com.example.KursinisWebService.model.Cargo;
import com.example.KursinisWebService.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public List<Cargo> getAllCargo(){
        return cargoRepository.findAll();
    }

    @PostMapping
    public Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable  int id){
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo does not exist with id:" + id));

        return ResponseEntity.ok(cargo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable int id,@RequestBody Cargo cargoDetails) {
        Cargo updateCargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo does not exist with id: " + id));

        updateCargo.setCargoMassKg(cargoDetails.getCargoMassKg());
        updateCargo.setDescription(cargoDetails.getDescription());
        updateCargo.setInOrder(cargoDetails.getInOrder());

        cargoRepository.save(updateCargo);
        return ResponseEntity.ok(updateCargo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCargo(@PathVariable int id){

        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo does not exist with id: " + id));

        cargoRepository.delete(cargo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}