package com.dbe.banklocator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbe.banklocator.model.BankBranch;

@Repository
public interface BranchRepository extends JpaRepository<BankBranch, Long> {
    @Query("SELECT b FROM BankBranch b WHERE LOWER(b.city) LIKE LOWER(CONCAT('%', :district, '%')) OR LOWER(b.address) LIKE LOWER(CONCAT('%', :district, '%'))")
    List<BankBranch> findByDistrictContainingIgnoreCase(@Param("district") String district);
    
    List<BankBranch> findByCityIgnoreCase(String city);
}