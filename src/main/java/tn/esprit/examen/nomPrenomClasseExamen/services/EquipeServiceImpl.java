package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements  IEquipeService{
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
    @Override
    public List<Equipe> findEquipebyprojetdetails(String technologie) {
        return equipeRepository.retrieveEquipesByProjetTechnologie(technologie);
    }

    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }

    @Override
    public List<Projet> retrieveAllProjet() {
        return List.of();
    }

    @Override
    public Projet retrieveProjet(Long ProjetId) {
        return null;
    }

    @Override
    public Projet addProjet(Projet b) {
        return null;
    }

    @Override
    public void removeProjet(Long projetId) {

    }

    @Override
    public Projet modifyProjet(Projet projet) {
        return null;
    }

    public void assignProjetDetailToProjet(Long projetId, Long equipeId) {
    }
}