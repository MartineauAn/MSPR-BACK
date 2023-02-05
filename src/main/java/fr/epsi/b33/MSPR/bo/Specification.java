package fr.epsi.b33.MSPR.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "specification")
public class Specification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comment;

    @JoinColumn(name = "id_plant_post")
    @ManyToOne
    private PlantPost plantPost;

    public Specification() {
    }

    public Specification(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PlantPost getPlantPost() {
        return plantPost;
    }

    public void setPlantPost(PlantPost plantPost) {
        this.plantPost = plantPost;
    }
}
