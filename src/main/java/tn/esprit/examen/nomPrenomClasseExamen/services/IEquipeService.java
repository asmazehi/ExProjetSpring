package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;

import java.util.List;

public interface IEquipeService {
    public List<Projet> retrieveAllProjet();
    public Projet retrieveProjet(Long ProjetId);
    public Projet addProjet(Projet b);
    public void removeProjet(Long projetId);
    public Projet modifyProjet(Projet projet);
    public List<Equipe> findEquipebyprojetdetails(String projet);

}
