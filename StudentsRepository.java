package com.jbk.springback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.jbk.springback.entity.Students;


public interface StudentsRepository extends JpaRepository<Students, Long>{

	Optional<Students> getById(int id);

	Optional<Students> findById(int id);

	void deleteById(int id);

}
