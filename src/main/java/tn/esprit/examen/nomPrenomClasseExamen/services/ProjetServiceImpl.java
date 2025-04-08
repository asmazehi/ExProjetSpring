package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetails;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailsRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements IProjetService {
    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    private ProjetDetailsRepository projetDetailsRepository;
    @Autowired
    EquipeRepository equipeRepository ;

    @Override
    public List<Projet> retrieveAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet retrieveProjet(Long blocId) {
        return projetRepository.findById(blocId).get();
    }

    @Override
    public Projet addProjet(Projet b) {
        return projetRepository.save(b);
    }

    @Override
    public void removeProjet(Long blocId) {
        projetRepository.deleteById(blocId);
    }

    @Override
    public Projet modifyProjet(Projet bloc) {
        return projetRepository.save(bloc);
    }
    @Override
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }
    @Override
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetails projetDetail = projetDetailsRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetdetails(projetDetail);
        projetRepository.save(projet);
    }
    @Override
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetails projetDetail = projetDetailsRepository.findById(projetDetailId).get();
        // on setle fils dans le parent :
        projet.setProjetdetails(projetDetail);
        return projetRepository.save(projet);
    }
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetdetails(null);
        return projetRepository.save(projet);
    }
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        // on enlève le fils du parent :
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
    @Override
    public void assignProjetsToEquipe(List<Long> projetIds, Long equipeId) {
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow(() -> new RuntimeException("Equipe non trouvée"));

        List<Projet> projets = projetRepository.findAllById(projetIds);

        equipe.getProjets().addAll(projets);
        equipeRepository.save(equipe);
    }

    @Override
    public List<Projet> findProjetpartech(String tech) {
        return projetRepository.findByProjetdetailsTechnologieContaining(tech);
    }
    @Override
    public List<Projet> findProjetparequipe(Long id) {
        return projetRepository.findByEquipesId(id);
    }
    @Override
    public List<Projet> findProjetparequipeetdescriptionnotnull(Long id) {
        return projetRepository.findByEquipesIdAndProjetdetailsDescriptionNotNull(id);
    }

}

