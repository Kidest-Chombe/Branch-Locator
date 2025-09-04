package com.dbe.banklocator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbe.banklocator.model.BankBranch;
import com.dbe.banklocator.service.BranchService;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin(origins = "http://localhost:3000")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public List<BankBranch> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/nearby")
    public List<BankBranch> getNearbyBranches(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "10") double radius) {
        return branchService.findNearby(lat, lon, radius);
    }

    @GetMapping("/nearest")
    public List<BankBranch> getBranchesByDistrict(@RequestParam String location) {
        return branchService.findByDistrict(location);
    }
    
    @GetMapping("/city")
    public List<BankBranch> getBranchesByCity(@RequestParam String city) {
        return branchService.findByCity(city);
    }
    
    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
}