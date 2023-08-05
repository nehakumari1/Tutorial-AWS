package com.tutorial.aws.spring.repository;

import com.tutorial.aws.spring.model.SemiBankedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemiBankedRepository   extends JpaRepository<SemiBankedData, Integer > {

}