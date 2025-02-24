package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;

import java.util.List;

public interface IProjetService {
    Projet addProjetAndProjetDetailAndAssign(Projet projet);
    public List<Projet> retrieveAllProjet();
    public Projet retrieveProjet(Long ProjetId);
    public Projet addProjet(Projet b);
    public void removeProjet(Long projetId);
    public Projet modifyProjet(Projet projet);
}