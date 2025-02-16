package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ReconciliationServiceModel;

public interface ReconciliationServiceReposistory extends JpaRepository<ReconciliationServiceModel, Long>{

}