package com.infor.platform.civabackend.controller;

import com.infor.platform.civabackend.model.Bus;
import com.infor.platform.civabackend.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    // GET /bus -> Lista todos los buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // GET /bus/paginado?page=0&size=5&sortBy=id -> Lista paginada
    @GetMapping("/paginado")
    public Page<Bus> getAllBusesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return busRepository.findAll(pageable);
    }

    // GET /bus/{id} -> Obtiene un bus por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> ResponseEntity.ok().body(bus))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /bus -> Crea un nuevo bus
    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus savedBus = busRepository.save(bus);
        return ResponseEntity.ok(savedBus);
    }
}
