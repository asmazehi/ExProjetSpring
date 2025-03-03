package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.services.ProjetServiceImpl;

@RestController
@RequestMapping("/projet")
@AllArgsConstructor
public class ProjetRestController {
    private final ProjetServiceImpl projetService;

    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p) {
        return projetService.addProjetAndProjetDetailAndAssign(p);
    }

    @PutMapping("/affecter-projet-detail/{projet-id}/{projet-detail-id}")
    public void affecterProjetDetail(@PathVariable("projet-id") Long projetId,
                                     @PathVariable("projet-detail-id") Long projetDetailId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailId);
    }

    @PutMapping("/desaffecter-projet-detail/{projet-id}")
    public Projet desaffecterProjetDetail(@PathVariable("projet-id") Long projetId) {
        return projetService.desaffecterProjetDetailFromProjet(projetId);
    }

    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetAProjetDetail(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("projet-details-id") Long projetDetailsId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailsId);
    }

    @PostMapping("/creer-projet-et-affecter-projet-detail-a-projet/{projet-detail-id}")
    public Projet addProjetAndAssignProjetToProjetDetail(@RequestBody Projet projet,
                                                         @PathVariable("projet-detail-id") Long projetDetailId) {
        return projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailId);
    }

    @PutMapping("/desaffecter-projet-de-equipe/{projet-id}/{equipe-id}")
    public void desaffecterProjetFromEquipe(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("equipe-id") Long equipeId) {
        projetService.desaffecterProjetFromEquipe(projetId, equipeId);
    }
}
