package com.dbe.banklocator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dbe.banklocator.model.BankBranch;

public interface BranchRepository extends JpaRepository<BankBranch, Long> {

    @Query("SELECT b FROM BankBranch b WHERE LOWER(b.address) LIKE %:district% OR LOWER(b.city) LIKE %:district%")
    BankBranch findNearestBranchIgnoreCase(@Param("district") String district);
}
