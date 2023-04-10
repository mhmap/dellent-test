/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DellentApplication.controller;

import com.example.DellentApplication.service.LabSeqService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mario.pacheco
 */
@RestController
public class LabSeqController {

    @Autowired
    private LabSeqService service;

    
    @GetMapping(value = "/labseq/{n}", produces = {"application/json", "application/xml"})
    public ResponseEntity getMachineById(@PathVariable int n) {
        try {
            return ResponseEntity.ok().body(service.labseq(n));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
