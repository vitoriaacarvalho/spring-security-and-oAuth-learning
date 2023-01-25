package com.vitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitoria.models.Flowers;

@Repository
public interface FlowersRepository extends JpaRepository<Flowers, Integer>{

}
