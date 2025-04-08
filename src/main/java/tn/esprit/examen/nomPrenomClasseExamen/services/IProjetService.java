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
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);
    public Projet DesaffecterProjetDetailFromProjet(Long projetId);
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId);
    public void assignProjetsToEquipe(List<Long> projetIds, Long equipeId);
    List<Projet> retrieveProjetSelonTech(String technologie);
    public List<Projet> retrieveProjetDetailparTechnologie(String technologie);
    List<Projet> findProjetparequipe(Long id);
    public List<Projet> findProjetparequipeetdescriptionnotnull(Long id);
}