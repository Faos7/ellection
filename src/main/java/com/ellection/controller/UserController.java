package com.ellection.controller;

import com.ellection.models.CurrentUser;
import com.ellection.models.Position;
import com.ellection.models.User;
import com.ellection.service.CandidateService;
import com.ellection.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * Created by faos7 on 02.04.17.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CandidateService candidateService;

    @Autowired
    PositionService positionService;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @RequestMapping(method = RequestMethod.GET, value = "/username/{username}")
    public ResponseEntity<User> getUserWithUsername(@PathVariable String username){
        return new ResponseEntity<>(candidateService.getUserByUsername(username), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vote")
    public ResponseEntity<Position> voteForSmb(@PathVariable @RequestParam String username, String pos){

        candidateService.voteFor(new CurrentUser(candidateService.getUserByUsername(auth.getName())),
                username,pos);
        return new ResponseEntity<Position>(positionService.getPosByName(pos), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/foto")
    public ResponseEntity<User> upFoto(@RequestParam MultipartFile file){
        User user = candidateService.getUserByUsername(auth.getName());
        candidateService.setFoto(file, user.getId());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pos")
    public ResponseEntity<User> addCandidateToPos(@RequestParam String pos){
        User user = candidateService.getUserByUsername(auth.getName());
        candidateService.addCandidateToPosition(
                user.getUsername(), pos);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pos")
    public ResponseEntity<User> removeCandidateFromPos(@RequestParam String pos){
        User user = candidateService.getUserByUsername(auth.getName());
        candidateService.removeCandidateFromPosition(
                user.getUsername(), pos);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<User> register(@RequestParam String firstName, @RequestParam String secondName,
                                         @RequestParam  String thirdName, @RequestParam String username,
                                         @RequestParam String password, @RequestParam String email){
        User user = candidateService.save(email, username, password, firstName, secondName, thirdName);
        auth.setAuthenticated(true);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/activate")
    public ResponseEntity<User> activate(@RequestParam String activeCode,
                                         @RequestParam String firstName, @RequestParam String secondName,
                                         @RequestParam  String thirdName, @RequestParam String username,
                                         @RequestParam String password, @RequestParam String email){
        User user = candidateService.activate(email, username, password,
                firstName, secondName, thirdName, activeCode);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
