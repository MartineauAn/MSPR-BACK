package fr.epsi.b33.MSPR.bo;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String type;

    @Lob
    @Column(nullable = false)
    private Blob photo;
    @Column
    private String advice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Plant() {
    }

    public Plant(String libelle, String type, Blob photo, String advice) {
        this.libelle = libelle;
        this.type = type;
        this.photo = photo;
        this.advice = advice;
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

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
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
}
