package org.example.jpaopgave.repository;

import org.example.jpaopgave.model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnicodeRepository extends JpaRepository<Unicode, Integer> {
}
