package fr.epsi.b33.MSPR.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.minidev.json.annotate.JsonIgnore;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column(unique = true)
    @JsonIgnore
    @JsonProperty(value = "email", access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @Column
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column
    @JsonProperty(value = "type_user", access = JsonProperty.Access.READ_ONLY)
    private String type_user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PlantPost> plantPosts;

    public User() {
    }

    public User( String lastname, String firstname, String email, String password, String type_user) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.type_user = type_user;
        this.plantPosts = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public Set<PlantPost> getPlantPosts() {
        return plantPosts;
    }

    public void setPlantPosts(Set<PlantPost> plantPosts) {
        this.plantPosts = plantPosts;
    }
}
