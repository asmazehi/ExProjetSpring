package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetDetailServiceImpl implements IProjetDetailService {
    ProjetDetailRepository projetDetailRepository;
    ProjetRepository projetRepository;

    @Override
    public List<ProjetDetail> retrieveAllProjetDetail() {
        return projetDetailRepository.findAll();
    }

    @Override
    public ProjetDetail retrieveProjetDetail(Long projetDetailId) {
        return projetDetailRepository.findById(projetDetailId).get();
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail b) {
        return projetDetailRepository.save(b);
    }

    @Override
    public void removeProjetDetail(Long projetDetailId) {
        projetDetailRepository.deleteById(projetDetailId);
    }

    @Override
    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }
    @Override
    public List<ProjetDetail> findProjetDetail(String blocId) {
        return projetDetailRepository.findByTechnologieLike(blocId);
    }
    @Override
    public List<ProjetDetail> fiindProjetDetail(String blocId) {
        return projetDetailRepository.findByTechnologieContains(blocId);
    }
    @Override
    public List<ProjetDetail> fiiindProjetDetail(String blocId) {
        return projetDetailRepository.findByTechnologieContaining(blocId);
    }

}
