package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;


public class Main { 
    public static void main(String[] args) {
        String message = "aul t  auy'?sefantibidiiT t a" ;
        int rows = 6;
        String encryptedMessage = Encryptor.encryptMessage(message, rows);
        System.out.println(Encryptor.decryptMessage(encryptedMessage, rows));
    }
}