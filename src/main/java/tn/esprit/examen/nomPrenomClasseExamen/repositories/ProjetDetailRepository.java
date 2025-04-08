package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;

import java.util.List;

@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {
    List<ProjetDetail> findByTechnologieLike(String technologie);
    List<ProjetDetail> findByTechnologieContains(String technologie);
    List<ProjetDetail> findByTechnologieContaining(String technologie);
}

