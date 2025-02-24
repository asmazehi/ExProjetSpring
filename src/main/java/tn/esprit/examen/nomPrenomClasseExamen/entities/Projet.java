package tn.esprit.examen.nomPrenomClasseExamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;

    @OneToOne(cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public ProjetDetail getProjetDetail() {
        return projetDetail;
    }

    public void setProjetDetail(ProjetDetail projetDetail) {
        this.projetDetail = projetDetail;
    }
    @ManyToMany(mappedBy = "projets")
    @JsonIgnore
    private Set<Equipe> equipes = new HashSet<>();
}
