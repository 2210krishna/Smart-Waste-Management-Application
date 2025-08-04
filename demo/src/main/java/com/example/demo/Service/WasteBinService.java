package com.example.demo.Service;

import com.example.demo.entities.WasteBin;
import com.example.demo.repositories.WasteBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WasteBinService {

    @Autowired
    private WasteBinRepository wasteBinRepository;

    public WasteBin saveWasteBin(WasteBin wasteBin) {
        return wasteBinRepository.save(wasteBin);
    }

    public List<WasteBin> getAllWasteBins() {
        return wasteBinRepository.findAll();
    }

    public Optional<WasteBin> getWasteBinById(Long id) {
        return wasteBinRepository.findById(id);
    }

    public void deleteWasteBin(Long id) {
        wasteBinRepository.deleteById(id);
    }

    public List<WasteBin> searchWasteBinsByLocation(String location) {
        return wasteBinRepository.searchWasteBinsByLocation(location);
    }

    public Page<WasteBin> getWasteBins(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return wasteBinRepository.findAll(pageable);
    }
}