package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetails;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> retrieveAllEquipe();
    public Equipe retrieveEquipe(Long blocId);
    public Equipe addEquipe(Equipe b);
    public void removeEquipe(Long blocId);
    public Equipe modifyEquipe(Equipe bloc);
    public List<Equipe> findEquipebyprojetdetails(String projet);
}
