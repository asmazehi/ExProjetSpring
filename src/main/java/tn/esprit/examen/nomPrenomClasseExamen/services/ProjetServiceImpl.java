package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {
    private final ProjetRepository projetRepository;
    private final ProjetDetailRepository projetDetailRepository;
    private final EquipeRepository equipeRepository;

    @Transactional
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public List<Projet> retrieveAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet retrieveProjet(Long projetId) {
        return projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID: " + projetId));
    }

    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    @Override
    public Projet modifyProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Transactional
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID: " + projetId));

        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId)
                .orElseThrow(() -> new RuntimeException("ProjetDetail non trouvé avec l'ID: " + projetDetailId));

        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    @Transactional
    public Projet desaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID: " + projetId));

        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }

    @Transactional
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID: " + projetId));

        Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new RuntimeException("Équipe non trouvée avec l'ID: " + equipeId));

        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    @Transactional
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId)
                .orElseThrow(() -> new RuntimeException("ProjetDetail non trouvé avec l'ID: " + projetDetailId));

        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }
}
