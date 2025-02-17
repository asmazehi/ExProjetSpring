package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

@Service
@AllArgsConstructor
public class EquipeServiceImpl {
    private final EquipeRepository equipeRepository;
    private final ProjetRepository projetRepository;

    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow();
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
}