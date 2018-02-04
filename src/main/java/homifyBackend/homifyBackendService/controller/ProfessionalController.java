package homifyBackend.homifyBackendService.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import homifyBackend.homifyBackendService.App;
import homifyBackend.homifyBackendService.model.Professional;
import homifyBackend.homifyBackendService.service.ProfessionalService;
import homifyBackend.homifyBackendService.util.CustomErrorType;

@RestController
public class ProfessionalController {
    public static final Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    ProfessionalService professionalService;

    @RequestMapping(value = "/professional", method = RequestMethod.GET)
    public Collection<Professional> listAllProfessionals() {
        List<Professional> users = professionalService.findAllProfessional();
        if (users.isEmpty()) {
            return Collections.EMPTY_LIST;
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ArrayList<Professional>(users);
    }

    @RequestMapping(value = "/professional/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Professional user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", user);

        if (professionalService.isProfessionalExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getFirstName());
            return new ResponseEntity(
                    new CustomErrorType(
                            "Unable to create. A User with name " + user.getFirstName() + " already exist."),
                    HttpStatus.CONFLICT);
        }
        professionalService.saveProfessional(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/professional/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateprofessional(@PathVariable("id") long id, @RequestBody Professional user) {
        logger.info("Updating User with id {}", id);

        Professional currentUser = professionalService.findById(id);

        if (currentUser == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
//        currentUser.setFirstName(user.getFirstName());
        professionalService.updateProfessional(currentUser);
        return new ResponseEntity<Professional>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/professional/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProfessional(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id {}", id);

        Professional user = professionalService.findById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        professionalService.deleteProfessionalById(id);
        return new ResponseEntity<Professional>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/professional/", method = RequestMethod.DELETE)
    public ResponseEntity<Professional> deleteAllProfessionals() {
        logger.info("Deleting All Users");

        professionalService.deleteAllProfessional();
        return new ResponseEntity<Professional>(HttpStatus.NO_CONTENT);
    }
}