package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetails;

import java.util.List;

public interface IProjetDetailsService {
    public List<ProjetDetails> retrieveAllProjetDetails();
    public ProjetDetails retrieveProjetDetails(Long blocId);
    public ProjetDetails addProjetDetails(ProjetDetails b);
    public void removeProjetDetails(Long blocId);
    public ProjetDetails modifyProjetDetails(ProjetDetails bloc);
    public List<ProjetDetails> findProjetDetails(String pro);
    public List<ProjetDetails> fiindProjetDetails(String pro);
    public List<ProjetDetails> fiiindProjetDetails(String pro);
}