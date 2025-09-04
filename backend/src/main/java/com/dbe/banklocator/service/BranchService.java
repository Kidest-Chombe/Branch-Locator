package com.dbe.banklocator.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dbe.banklocator.model.BankBranch;
import com.dbe.banklocator.repository.BranchRepository;

@Service
public class BranchService {
    private final BranchRepository repository;

    public BranchService(BranchRepository repository) {
        this.repository = repository;
    }

    public List<BankBranch> getAllBranches() {
        return repository.findAll();
    }

    public List<BankBranch> findByDistrict(String district) {
        return repository.findByDistrictContainingIgnoreCase(district);
    }

    public List<BankBranch> findByCity(String city) {
        return repository.findByCityIgnoreCase(city);
    }

    public List<BankBranch> findNearby(double lat, double lon, double radius) {
        return repository.findAll().stream()
                .filter(branch -> calculateDistance(lat, lon, branch.getLatitude(), branch.getLongitude()) <= radius)
                .collect(Collectors.toList());
    }

    private double calculateDistance(double lat1, double lon1, Double lat2, Double lon2) {
        if (lat2 == null || lon2 == null) return Double.MAX_VALUE;
        
        final int EARTH_RADIUS = 6371; // Earth's radius in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}