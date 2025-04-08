package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("SELECT projet from Projet projet where projet.projetdetails.technologie=:technologie")
    List<Projet> findByProjetdetailsTechnologieContaining(@Param("technologie") String technologie);
    //List<Projet> findByProjetdetailsTechnologieContaining(String projet);
    List<Projet> findByEquipesId(Long id);
    List<Projet> findByEquipesIdAndProjetdetailsDescriptionNotNull(Long id);

}

