package com.freelance.atelier_workshops.repository;

import com.freelance.atelier_workshops.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

}
