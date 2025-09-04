package com.dbe.banklocator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbe.banklocator.model.BankBranch;
import com.dbe.banklocator.repository.BranchRepository;
import com.dbe.banklocator.service.BranchService;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin(origins = "*")
public class BranchController {

    private final BranchService branchService;
    private final BranchRepository branchRepository;

    public BranchController(BranchService branchService, BranchRepository branchRepository) {
        this.branchService = branchService;
        this.branchRepository = branchRepository;
    }

    @GetMapping
    public List<BankBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    @GetMapping("/nearby")
    public List<BankBranch> getNearbyBranches(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "5") double radiusKm) {
        return branchService.findNearby(lat, lon, radiusKm);
    }
}