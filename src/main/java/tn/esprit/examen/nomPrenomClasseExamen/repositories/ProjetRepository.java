package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findByProjetDetailTechnologieLike(String technologie);

    @Query("SELECT projet FROM Projet projet where "
    + "projet.projetDetail.technologie =:technologie"
    )
    List<Projet> findByProjetDetailTechnologie(@Param("technologie") String technologie);
    List<Projet> findByEquipesId(Long id);
    List<Projet> findByEquipesIdAndProjetdetailDescriptionNotNull(Long id);
}

