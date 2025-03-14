package com.xamplify.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xamplify.demo.modal.CompanyModule;

@Repository
public interface CompanyModuleRepository extends JpaRepository<CompanyModule, Long> {
    List<CompanyModule> findByCompanyId(Long companyId);
    void deleteByCompanyId(Long companyId);
}