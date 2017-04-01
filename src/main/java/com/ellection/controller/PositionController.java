package com.ellection.controller;

import com.ellection.models.Position;
import com.ellection.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by faos7 on 01.04.17.
 */

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public ResponseEntity<Position> getPositeionWithId(@PathVariable String name){
        return new ResponseEntity<>(service.getPosByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ResponseEntity<Position> createCandidate(@RequestParam String name){
        return new ResponseEntity<>( service.create(name), HttpStatus.OK);
    }
}
