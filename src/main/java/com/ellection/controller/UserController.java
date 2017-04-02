package com.ellection.controller;

import com.ellection.models.User;
import com.ellection.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by faos7 on 02.04.17.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CandidateService candidateService;


    @RequestMapping(method = RequestMethod.GET, value = "/username/{username}")
    public ResponseEntity<User> getUserWithUsername(@PathVariable String username){
        return new ResponseEntity<>(candidateService.getUserByUsername(username), HttpStatus.OK);
    }


}
