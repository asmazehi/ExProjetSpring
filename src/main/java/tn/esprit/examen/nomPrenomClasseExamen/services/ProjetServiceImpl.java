package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

@Service
@AllArgsConstructor
public class ProjetServiceImpl {
    private final ProjetRepository projetRepository;
    private final ProjetDetailRepository projetDetailRepository;

    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }

    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).orElseThrow();
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    public Projet desaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }
}

