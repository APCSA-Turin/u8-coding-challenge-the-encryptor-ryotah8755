package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    private static int rowEncrypt;
    private static int rowDecrypt;

    public static int determineColumns(int messageLen, int rows){
        if(messageLen==0){ 
            return 1;
        }
        boolean done = false;
        int n = 0;
        while(!done) { 
            if(rows* n >= messageLen) { 
                done = true;
                break;
            }
            n++;
        }
        return n;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int rowEncrypt = rows;
        int messageLen = message.length();
        int cols = determineColumns(messageLen, rows);
        String[][] arr = new String[rows][cols];
        int index = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < messageLen) {
                    arr[i][j] = String.valueOf(message.charAt(index));
                    index++;
                } else {
                    arr[i][j] = "=";
                }
            }
        }
        return arr;
    }

    public static String encryptMessage(String message, int rows){
        if(message.length() == 0) { 
            return "";
        }
        String[][] encryptArr = generateEncryptArray(message, rows);
        String encryptString = ""; 
        int cols = encryptArr[0].length;
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                encryptString += encryptArr[row][col];
            }
        }
        return encryptString;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        if(encryptedMessage.length() == 0) { 
            return "";
        }
        int messageLen = encryptedMessage.length();
        int cols = determineColumns(messageLen, rows);
        String[][] decryptArr = new String[rows][cols];
        int index = 0;
        if(messageLen < rows * cols) { 
            return "Not possible!";
        }
        
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                decryptArr[row][col] = encryptedMessage.substring(index, index + 1);
                index++;
            }
        }
        
        String decryptedMessage = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!decryptArr[i][j].equals("=")) {
                    decryptedMessage += decryptArr[i][j];
                }
            }
        }
        return decryptedMessage;
    }
}