package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.services.EquipeServiceImpl;
import tn.esprit.examen.nomPrenomClasseExamen.services.ProjetDetailServiceImpl;

@RestController
@RequestMapping("/tp8/equipe")
@AllArgsConstructor
public class EquipeRestController {
    private final tn.esprit.examen.nomPrenomClasseExamen.services.EquipeServiceImpl equipeService;

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }

    @PutMapping("/affecter-projet/{equipe-id}/{projet-id}")
    public void affecterProjetAEquipe(@PathVariable("equipe-id") Long equipeId,
                                      @PathVariable("projet-id") Long projetId) {
        equipeService.assignProjetToEquipe(projetId, equipeId);
    }

    @PutMapping("/desaffecter-projet/{equipe-id}/{projet-id}")
    public void desaffecterProjetDeEquipe(@PathVariable("equipe-id") Long equipeId,
                                          @PathVariable("projet-id") Long projetId) {
        equipeService.desaffecterProjetFromEquipe(projetId, equipeId);
    }
}