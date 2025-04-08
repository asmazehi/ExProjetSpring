package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetails;

import java.util.List;

@Repository
public interface ProjetDetailsRepository extends JpaRepository<ProjetDetails, Long> {
    List<ProjetDetails> findByTechnologieLike(String technologie);
    List<ProjetDetails> findByTechnologieContains(String technologie);
    List<ProjetDetails> findByTechnologieContaining(String technologie);
}

