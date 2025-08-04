package com.example.demo.Controller;

import com.example.demo.Service.WasteBinService;
import com.example.demo.entities.WasteBin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/wastebins")
public class WasteBinController {

    @Autowired
    private WasteBinService wasteBinService;

    @PostMapping
    public ResponseEntity<WasteBin> createWasteBin(@RequestBody WasteBin wasteBin) {
        WasteBin createdWasteBin = wasteBinService.saveWasteBin(wasteBin);
        return new ResponseEntity<>(createdWasteBin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WasteBin>> getAllWasteBins() {
        List<WasteBin> wasteBins = wasteBinService.getAllWasteBins();
        return new ResponseEntity<>(wasteBins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<WasteBin> getWasteBinById(@PathVariable Long id) {
        return wasteBinService.getWasteBinById(id);
    }
}