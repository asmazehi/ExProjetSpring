package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetails;

import tn.esprit.examen.nomPrenomClasseExamen.services.IProjetDetailsService;


import java.util.List;
@Tag(name="Gestion projetsdetails")
@RestController
@AllArgsConstructor
@RequestMapping("/projetsdetails")
public class ProjetDetailsRestController {

    @Autowired
    IProjetDetailsService projetsdetailsService;
    @Operation(description = "récupérer toutes les projetsdetails de la base de données")
    // http://localhost:8089/newpro/projetDetails/retrieve-all-projetDetails
    @GetMapping("/retrieve-all-projetsdetails")
    public List<ProjetDetails> getProjetDetails() {
        List<ProjetDetails> listProjetDetailss = projetsdetailsService.retrieveAllProjetDetails();
        return listProjetDetailss;
    }
    // http://localhost:8089/newpro/projetDetails/retrieve-projetDetails/8
    @GetMapping("/retrieve-projetDetails/{projetDetails-id}")
    public ProjetDetails retrieveProjetDetails(@PathVariable("projetDetails-id") Long blId) {
        ProjetDetails projetDetails = projetsdetailsService.retrieveProjetDetails(blId);
        return projetDetails;

    }
    // http://localhost:8089/newpro/projetDetails/add-projetDetails
    @PostMapping("/add-projetDetails")
    public ProjetDetails addProjetDetails(@RequestBody ProjetDetails b) {
        ProjetDetails projetDetails = projetsdetailsService.addProjetDetails(b);
        return projetDetails;
    }
    // http://localhost:8089/newpro/projetDetails/remove-projetDetails/{projetDetails-id}
    @DeleteMapping("/remove-projetDetails/{projetDetails-id}")
    public void removeProjetDetails(@PathVariable("projetDetails-id") Long blId) {
        projetsdetailsService.removeProjetDetails(blId);
    }

    // http://localhost:8089/newpro/projetDetails/modify-projetDetails
    @PutMapping("/modify-projetDetails")
    public ProjetDetails modifyProjetDetails(@RequestBody ProjetDetails b) {
        ProjetDetails projetDetails = projetsdetailsService.modifyProjetDetails(b);
        return projetDetails;
    }
    @GetMapping("/find-projetsdetails/{tech}")
    public List<ProjetDetails> findProjetDetails(@PathVariable ("tech") String tech) {
        List<ProjetDetails> listProjetDetailss = projetsdetailsService.findProjetDetails(tech);
        return listProjetDetailss;
    }
    @GetMapping("/fiind-projetsdetails/{tech}")
    public List<ProjetDetails> fiindProjetDetails(@PathVariable ("tech") String tech) {
        List<ProjetDetails> listProjetDetailss = projetsdetailsService.fiindProjetDetails(tech);
        return listProjetDetailss;
    }
    @GetMapping("/fiiind-projetsdetails/{tech}")
    public List<ProjetDetails> fiiindProjetDetails(@PathVariable ("tech") String tech) {
        List<ProjetDetails> listProjetDetailss = projetsdetailsService.fiiindProjetDetails(tech);
        return listProjetDetailss;
    }
}