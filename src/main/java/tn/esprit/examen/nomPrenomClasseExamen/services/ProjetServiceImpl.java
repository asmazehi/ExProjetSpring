package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {
    private final ProjetRepository projetRepository;
    private final ProjetDetailRepository projetDetailRepository;
    private final EquipeRepository equipeRepository;


    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
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
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

}

