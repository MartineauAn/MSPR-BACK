package fr.epsi.b33.MSPR.controlleur;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControlleur {

    @GetMapping("/user")
    public String getUser(){
        return "issou zineb";
    }
}
