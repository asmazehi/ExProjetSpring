package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;

import tn.esprit.examen.nomPrenomClasseExamen.services.IProjetDetailService;


import java.util.List;
@Tag(name="Gestion projetsdetails")
@RestController
@AllArgsConstructor
@RequestMapping("/projetsdetails")
public class ProjetDetailRestController {

    @Autowired
    IProjetDetailService projetsdetailsService;
    @Operation(description = "récupérer toutes les projetsdetails de la base de données")
    // http://localhost:8089/newpro/ProjetDetail/retrieve-all-ProjetDetail
    @GetMapping("/retrieve-all-projetsdetails")
    public List<ProjetDetail> getProjetDetail() {
        List<ProjetDetail> listProjetDetails = projetsdetailsService.retrieveAllProjetDetail();
        return listProjetDetails;
    }
    // http://localhost:8089/newpro/ProjetDetail/retrieve-ProjetDetail/8
    @GetMapping("/retrieve-ProjetDetail/{ProjetDetail-id}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("ProjetDetail-id") Long blId) {
        ProjetDetail ProjetDetail = projetsdetailsService.retrieveProjetDetail(blId);
        return ProjetDetail;

    }
    // http://localhost:8089/newpro/ProjetDetail/add-ProjetDetail
    @PostMapping("/add-ProjetDetail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail b) {
        ProjetDetail ProjetDetail = projetsdetailsService.addProjetDetail(b);
        return ProjetDetail;
    }
    // http://localhost:8089/newpro/ProjetDetail/remove-ProjetDetail/{ProjetDetail-id}
    @DeleteMapping("/remove-ProjetDetail/{ProjetDetail-id}")
    public void removeProjetDetail(@PathVariable("ProjetDetail-id") Long blId) {
        projetsdetailsService.removeProjetDetail(blId);
    }

    // http://localhost:8089/newpro/ProjetDetail/modify-ProjetDetail
    @PutMapping("/modify-ProjetDetail")
    public ProjetDetail modifyProjetDetail(@RequestBody ProjetDetail b) {
        ProjetDetail ProjetDetail = projetsdetailsService.modifyProjetDetail(b);
        return ProjetDetail;
    }
    @GetMapping("/find-projetsdetails/{tech}")
    public List<ProjetDetail> findProjetDetail(@PathVariable ("tech") String tech) {
        List<ProjetDetail> listProjetDetails = projetsdetailsService.findProjetDetail(tech);
        return listProjetDetails;
    }
    @GetMapping("/fiind-projetsdetails/{tech}")
    public List<ProjetDetail> fiindProjetDetail(@PathVariable ("tech") String tech) {
        List<ProjetDetail> listProjetDetails = projetsdetailsService.fiindProjetDetail(tech);
        return listProjetDetails;
    }
    @GetMapping("/fiiind-projetsdetails/{tech}")
    public List<ProjetDetail> fiiindProjetDetail(@PathVariable ("tech") String tech) {
        List<ProjetDetail> listProjetDetails = projetsdetailsService.fiiindProjetDetail(tech);
        return listProjetDetails;
    }
}
