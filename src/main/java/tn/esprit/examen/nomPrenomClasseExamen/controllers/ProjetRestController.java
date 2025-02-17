package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.services.ProjetServiceImpl;

@RestController
@RequestMapping("/tp8/projet")
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
}

