package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.services.ProjetServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/projet")
@AllArgsConstructor
public class ProjetRestController {
    private final ProjetServiceImpl projetService;

    @PostMapping("/ajouter-projet-et-projet-detail")
    public ResponseEntity<Projet> addProjetAndProjetDetail(@RequestBody Projet p) {
        Projet projet = projetService.addProjetAndProjetDetailAndAssign(p);
        return ResponseEntity.ok(projet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjets() {
        return ResponseEntity.ok(projetService.retrieveAllProjet());
    }

    @PutMapping("/affecter-projet-detail/{projet-id}/{projet-detail-id}")
    public ResponseEntity<Void> affecterProjetDetail(@PathVariable("projet-id") Long projetId,
                                                     @PathVariable("projet-detail-id") Long projetDetailId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/desaffecter-projet-detail/{projet-id}")
    public ResponseEntity<Projet> desaffecterProjetDetail(@PathVariable("projet-id") Long projetId) {
        return ResponseEntity.ok(projetService.desaffecterProjetDetailFromProjet(projetId));
    }

    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public ResponseEntity<Void> affecterProjetAProjetDetail(@PathVariable("projet-id") Long projetId,
                                                            @PathVariable("projet-details-id") Long projetDetailsId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailsId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/creer-projet-et-affecter-projet-detail-a-projet/{projet-detail-id}")
    public ResponseEntity<Projet> addProjetAndAssignProjetToProjetDetail(@RequestBody Projet projet,
                                                                         @PathVariable("projet-detail-id") Long projetDetailId) {
        return ResponseEntity.ok(projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailId));
    }
}
