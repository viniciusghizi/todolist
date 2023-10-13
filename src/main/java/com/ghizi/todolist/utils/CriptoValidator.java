package com.ghizi.todolist.utils;

import java.math.BigInteger;
import java.security.MessageDigest;



import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CriptoValidator {
    private CriptoValidator() {
        throw new IllegalStateException("Classe não precisa ser instanciada");
    }

    public static String encrypt(String value) {
        MessageDigest md;
        MessageDigest reCript;
        String cript = "";

        try {
            md = MessageDigest.getInstance("SHA256");
            BigInteger hash = new BigInteger( 1,md.digest(value.getBytes()) );

            reCript = MessageDigest.getInstance("MD5");
            cript = hash.toString(120);
            
            BigInteger newHash = new BigInteger( 1,reCript.digest(cript.getBytes()) );
            cript = newHash.toString(32);
            
        } catch (Exception e) {
            log.info("Erro");
        }
        return cript;
    }

}
