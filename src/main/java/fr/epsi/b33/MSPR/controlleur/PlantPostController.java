package fr.epsi.b33.MSPR.controlleur;

import fr.epsi.b33.MSPR.bo.Asset;
import fr.epsi.b33.MSPR.bo.Plant;
import fr.epsi.b33.MSPR.bo.PlantPost;
import fr.epsi.b33.MSPR.bo.User;
import fr.epsi.b33.MSPR.dal.PlantDAO;
import fr.epsi.b33.MSPR.dal.UserDAO;
import fr.epsi.b33.MSPR.dto.MessageResponse;
import fr.epsi.b33.MSPR.repo.PlantPostRepository;
import fr.epsi.b33.MSPR.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PlantPostController {

    @Autowired
    private AssetService assetService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PlantDAO plantDAO;

    @Autowired
    private PlantPostRepository plantPostRepository;

    @GetMapping("/api/planPosts")
    public List<PlantPost> all(){
        return  plantPostRepository.findAll();
    }

    @GetMapping("/api/planPosts/{planPost_id}")
    public PlantPost get(@PathVariable Integer planPost_id){
        return  plantPostRepository.findById(planPost_id).orElseThrow();
    }

    @PostMapping(value = "/api/{user_id}/plantPost", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> create (@PathVariable Integer user_id,
                                     @RequestPart MultipartFile photo,
                                     @RequestPart String start_date,
                                     @RequestPart String end_date,
                                     @RequestPart String title,
                                     @RequestPart String description,
                                     @RequestPart String surname,
                                     @RequestPart String city,
                                     @RequestPart String address,
                                     @RequestPart String post_code,
                                     @RequestPart Integer plant_id){

        String message;
        try {
            Optional<User> user = userDAO.findById(user_id);

            if (user.isPresent()){

                Optional<Plant> plant = plantDAO.findById(plant_id);

                if (plant.isPresent()){
                    Plant plantValue = plant.get();

                    User userValue = user.get();
                    Asset asset = assetService.PlantPostPhoto(photo);

                    PlantPost plantPost = new PlantPost(Date.from(Instant.now()),LocalDateTime.parse(start_date),LocalDateTime.parse(end_date),title,description,surname,city,address,post_code);

                    plantPost.setPhoto(asset);
                    plantPost.setUser(userValue);
                    plantPost.setPlant(plantValue);
                    plantPostRepository.save(plantPost);

                    message = "Success";

                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessageResponse( message ));
                }
                else {
                    message = "Unable to find plant with id (" + plant_id + ")";
                }
            }
            else {
                message = "Unable to find user with id (" + user_id + ")";
            }

            return ResponseEntity.status( HttpStatus.EXPECTATION_FAILED ).body( new MessageResponse( message ) );

        } catch ( Exception e ) {
            message = "An error as occured, please try again !";
            return ResponseEntity.status( HttpStatus.EXPECTATION_FAILED ).body( new MessageResponse( message ) );
        }
    }

    @GetMapping("/api/plantPosts/photos/{photo_uuid}")
    public ResponseEntity<byte[]> getPhoto (@PathVariable String photo_uuid){
        Asset photo = assetService.getPhoto( photo_uuid );
        return ResponseEntity.ok()
                .header( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getFileName() + "\"" )
                .body( photo.getContent() );
    }

}
