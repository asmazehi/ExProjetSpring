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
        return projetRepository.findAll();
    }

    @Override
    public Projet retrieveProjet(Long projetId) {
        return projetRepository.findById(projetId).orElse(null);
    }

    @Override
    public Projet addProjet(Projet b) {
        return projetRepository.save(b);
    }

    @Override
    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    @Override
    public Projet modifyProjet(Projet projet) {
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

    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow();
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).orElseThrow();
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).orElseThrow();
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
}
