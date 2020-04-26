package com.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Insurance;


@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {}

