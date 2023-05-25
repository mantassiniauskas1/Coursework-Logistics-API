package com.example.KursinisWebService.webController;

import com.example.KursinisWebService.exception.ResourceNotFoundException;
import com.example.KursinisWebService.model.Order;
import com.example.KursinisWebService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable  int id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order does not exist with id:" + id));

        return ResponseEntity.ok(order);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id,@RequestBody Order orderDetails) {
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order does not exist with id: " + id));

        updateOrder.setDriverId(orderDetails.getDriverId());
        updateOrder.setVehicleLicensePlate(orderDetails.getVehicleLicensePlate());
        updateOrder.setCargoId(orderDetails.getCargoId());
        updateOrder.setDestinationId(orderDetails.getDestinationId());
        updateOrder.setStatus(orderDetails.getStatus());

        orderRepository.save(updateOrder);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable int id){

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order does not exist with id: " + id));

        orderRepository.delete(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}