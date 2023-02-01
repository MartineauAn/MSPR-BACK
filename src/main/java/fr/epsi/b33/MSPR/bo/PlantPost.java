package fr.epsi.b33.MSPR.bo;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plant_post")
public class PlantPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date publicationDate;
    @Column(nullable = false)
    private LocalDateTime start_date;
    @Column(nullable = false)
    private LocalDateTime end_date;

    @Lob
    @Column(nullable = false)
    private Blob photo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column
    private String surname;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private String post_code;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "plantPost")
    private Set<Specification> specifications;

    public PlantPost() {
    }

    public PlantPost(Date publicationDate, LocalDateTime start_date, LocalDateTime end_date, Blob photo, String title, String description, String surname, String city, String address, String post_code) {
        this.publicationDate = publicationDate;
        this.start_date = start_date;
        this.end_date = end_date;
        this.photo = photo;
        this.title = title;
        this.description = description;
        this.surname = surname;
        this.city = city;
        this.address = address;
        this.post_code = post_code;
        this.specifications = new HashSet<Specification>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<Specification> specifications) {
        this.specifications = specifications;
    }
}
