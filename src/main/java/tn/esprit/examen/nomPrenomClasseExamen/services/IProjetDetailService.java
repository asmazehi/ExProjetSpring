package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {
    public List<ProjetDetail> retrieveAllProjetDetail();
    public ProjetDetail retrieveProjetDetail(Long ProjetDetailId);
    public ProjetDetail addProjetDetail(ProjetDetail b);
    public void removeProjetDetail(Long projetDetailId);
    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail);
    public List<ProjetDetail>findProjetDetail(String tech);
    public List<ProjetDetail> fiindProjetDetail(String tech);
    public List<ProjetDetail> fiiindProjetDetail(String tech);

}