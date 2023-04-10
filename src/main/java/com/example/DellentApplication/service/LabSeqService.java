/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DellentApplication.service;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;

/**
 *
 * @author mario.pacheco
 */
@Service
@Transactional

public class LabSeqService {
    private static final Logger log = LoggerFactory.getLogger(LabSeqService.class);

    public BigInteger[] labseq(int n) {
        long start = System.currentTimeMillis();
        BigInteger sum;
        BigInteger[] seq = new BigInteger[n];
        seq[0] = BigInteger.valueOf(0);
        seq[1] = BigInteger.valueOf(1);
        seq[2] = BigInteger.valueOf(0);
        seq[3] = BigInteger.valueOf(1);
        for (int i = 4; i < n; i++) {
            sum = seq[i - 4];
            seq[i] = sum.add(seq[i - 3]);
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        log.info("Elapsed time:" + timeElapsed / 1000 + " seconds");
        return seq;
    }
}
