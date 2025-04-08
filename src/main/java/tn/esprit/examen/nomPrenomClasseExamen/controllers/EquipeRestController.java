package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.services.IEquipeService;

import java.util.List;

@Tag(name="Gestion Equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    @Autowired
    IEquipeService equipeService;
    @Operation(description = "récupérer toutes les equipes de la base de données")
    // http://localhost:8089/newpro/equipe/retrieve-all-equpes
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipes = equipeService.retrieveAllEquipe();
        return listEquipes;
    }

    // http://localhost:8089/newpro/equipe/retrieve-equipe/8
    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Long blId) {
        Equipe equipe = equipeService.retrieveEquipe(blId);
        return equipe;

    }
    // http://localhost:8089/newpro/equipe/add-equipe
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe b) {
        Equipe equipe = equipeService.addEquipe(b);
        return equipe;
    }
    // http://localhost:8089/newpro/equipe/remove-equipe/{equipe-id}
    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("bloc-id") Long blId) {
        equipeService.removeEquipe(blId);
    }

    // http://localhost:8089/newpro/equipe/modify-equipe
    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe b) {
        Equipe equipe = equipeService.modifyEquipe(b);
        return equipe;
    }
    @GetMapping("/findequipesbyprojetdetail/{technologie}")
    public List<Equipe> findequipesbyprojetdetail(@PathVariable("technologie") String technologie) {
        List<Equipe> listEquipes = equipeService.findEquipebyprojetdetails(technologie);
        return listEquipes;
    }

}