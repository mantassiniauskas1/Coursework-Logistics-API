package com.example.KursinisWebService.webController;

import com.example.KursinisWebService.exception.ResourceNotFoundException;
import com.example.KursinisWebService.model.Vehicle;
import com.example.KursinisWebService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable  String id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle does not exist with id:" + id));

        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable String id,@RequestBody Vehicle vehicleDetails) {
        Vehicle updateVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle does not exist with id: " + id));

        updateVehicle.setLicensePlate(vehicleDetails.getLicensePlate());
        updateVehicle.setBrand(vehicleDetails.getBrand());
        updateVehicle.setModel(vehicleDetails.getModel());
        updateVehicle.setYearOfManifacture(vehicleDetails.getYearOfManifacture());
        updateVehicle.setMileage(vehicleDetails.getMileage());
        updateVehicle.setWeightCapacityKg(vehicleDetails.getWeightCapacityKg());
        updateVehicle.setFuelCapacityL(vehicleDetails.getFuelCapacityL());
        updateVehicle.setIsTaken(vehicleDetails.getIsTaken());

        vehicleRepository.save(updateVehicle);
        return ResponseEntity.ok(updateVehicle);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable String id){

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle does not exist with id: " + id));

        vehicleRepository.delete(vehicle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}