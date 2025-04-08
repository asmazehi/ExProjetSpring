package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetails;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailsRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjetDetailsServiceImpl implements IProjetDetailsService {
    @Autowired
    ProjetDetailsRepository projetDetailsRepository;
    @Override
    public List<ProjetDetails> retrieveAllProjetDetails() {
        return projetDetailsRepository.findAll();
    }

    @Override
    public ProjetDetails retrieveProjetDetails(Long blocId) {
        return projetDetailsRepository.findById(blocId).get();
    }

    @Override
    public ProjetDetails addProjetDetails(ProjetDetails b) {
        return projetDetailsRepository.save(b);
    }

    @Override
    public void removeProjetDetails(Long blocId) {
        projetDetailsRepository.deleteById(blocId);
    }

    @Override
    public ProjetDetails modifyProjetDetails(ProjetDetails bloc) {
        return projetDetailsRepository.save(bloc);
    }
    @Override
    public List<ProjetDetails> findProjetDetails(String blocId) {
        return projetDetailsRepository.findByTechnologieLike(blocId);
    }
    @Override
    public List<ProjetDetails> fiindProjetDetails(String blocId) {
        return projetDetailsRepository.findByTechnologieContains(blocId);
    }
    @Override
    public List<ProjetDetails> fiiindProjetDetails(String blocId) {
        return projetDetailsRepository.findByTechnologieContaining(blocId);
    }

}
