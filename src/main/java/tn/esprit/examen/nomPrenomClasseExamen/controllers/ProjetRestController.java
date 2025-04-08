package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.services.ProjetServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/projet")
@AllArgsConstructor
public class ProjetRestController {

    private final ProjetServiceImpl projetService;

    @PostMapping("/ajouter-et-affecter-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p) {
        return projetService.addProjetAndProjetDetailAndAssign(p);
    }

    @PutMapping("/affecter-detail/{projet-id}/{projet-detail-id}")
    public void affecterProjetDetail(@PathVariable("projet-id") Long projetId,
                                     @PathVariable("projet-detail-id") Long projetDetailId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailId);
    }

    @PutMapping("/desaffecter-detail/{projet-id}")
    public Projet desaffecterProjetDetail(@PathVariable("projet-id") Long projetId) {
        return projetService.desaffecterProjetDetailFromProjet(projetId);
    }

    @PostMapping("/creer-et-affecter-detail/{projet-detail-id}")
    public Projet addProjetAndAssignProjetToProjetDetail(@RequestBody Projet projet,
                                                         @PathVariable("projet-detail-id") Long projetDetailId) {
        return projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailId);
    }

    @PutMapping("/desaffecter-de-equipe/{projet-id}/{equipe-id}")
    public void desaffecterProjetFromEquipe(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("equipe-id") Long equipeId) {
        projetService.desaffecterProjetFromEquipe(projetId, equipeId);
    }

    @PutMapping("/affecter-plusieurs-a-equipe/{projet-ids}/{equipe-id}")
    public void assignProjetsToEquipe(@PathVariable("projet-ids") List<Long> projetIds,
                                      @PathVariable("equipe-id") Long equipeId) {
        projetService.assignProjetsToEquipe(projetIds, equipeId);
    }
    @GetMapping("/retrieveProjetSelonTech/{tech}")
    public List<Projet> findProjet(@RequestParam("tech") String tech) {
        List<Projet> listProjets = projetService.retrieveProjetSelonTech(tech);
        return listProjets;
    }
    @GetMapping("/retrieve-projet-detail-par-technologie/{technologie}")
    public List<Projet> retrieveProjetDetailparTechnologie(@PathVariable("technologie") String technologie) {
        return projetService.retrieveProjetDetailparTechnologie(technologie);
    }
    @GetMapping("/findProjetequipe/{equipe}")
    public List<Projet> findProjetequipe(@RequestParam("equipe") Long equipeid) {
        List<Projet> listProjets = projetService.findProjetparequipe(equipeid);
        return listProjets;
    }
    @GetMapping("/findProjetequipeanddescriptionnotnull/{equipe}")
    public List<Projet> findProjetequipeanddescriptionnotnull(@RequestParam("equipe") Long equipeid) {
        List<Projet> listProjets = projetService.findProjetparequipeetdescriptionnotnull(equipeid);
        return listProjets;
    }
}
