package fr.epsi.b33.MSPR.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plant")
public class Plant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Asset photo;
    @Column
    private String advice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "plant")
    private Set<PlantPost> plantPosts;

    public Plant() {
    }

    public Plant(String libelle, String type, Asset photo, String advice) {
        this.libelle = libelle;
        this.type = type;
        this.photo = photo;
        this.advice = advice;
        this.plantPosts = new HashSet<>();
    }

    public Plant (String libelle){
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Asset getPhoto() {
        return photo;
    }

    public void setPhoto(Asset photo) {
        this.photo = photo;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<PlantPost> getPlantPosts() {
        return plantPosts;
    }

    public void setPlantPosts(Set<PlantPost> plantPosts) {
        this.plantPosts = plantPosts;
    }
}
