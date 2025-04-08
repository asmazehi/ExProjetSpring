package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;


import java.util.List;

public interface IProjetService {
    public List<Projet> retrieveAllProjet();
    public Projet retrieveProjet(Long blocId);
    public Projet addProjet(Projet b);
    public void removeProjet(Long blocId);
    public Projet modifyProjet(Projet bloc);
    public Projet addProjetAndProjetDetailAndAssign(Projet projet);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);
    public Projet DesaffecterProjetDetailFromProjet(Long projetId);
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId);
    public void assignProjetsToEquipe(List<Long> projetIds, Long equipeId);
    public List<Projet> findProjetpartech(String tech);
    public List<Projet> findProjetparequipe(Long idequipe);
    public List<Projet> findProjetparequipeetdescriptionnotnull(Long id);
}
