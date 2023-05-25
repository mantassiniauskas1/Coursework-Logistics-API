package com.example.KursinisWebService.webController;

import com.example.KursinisWebService.exception.ResourceNotFoundException;
import com.example.KursinisWebService.model.Destination;
import com.example.KursinisWebService.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    @GetMapping
    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();
    }

    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationRepository.save(destination);
    }

    @GetMapping("{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable  int id){
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination does not exist with id:" + id));

        return ResponseEntity.ok(destination);
    }

    @PutMapping("{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable int id,@RequestBody Destination destinationDetails) {
        Destination updateDestination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination does not exist with id: " + id));

        updateDestination.setDestinationFrom(destinationDetails.getDestinationFrom());
        updateDestination.setDestinationTo(destinationDetails.getDestinationTo());
        updateDestination.setAdditionalStops(destinationDetails.getAdditionalStops());
        updateDestination.setDistanceKm(destinationDetails.getDistanceKm());

        destinationRepository.save(updateDestination);
        return ResponseEntity.ok(updateDestination);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDestination(@PathVariable int id){

        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination does not exist with id: " + id));

        destinationRepository.delete(destination);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}