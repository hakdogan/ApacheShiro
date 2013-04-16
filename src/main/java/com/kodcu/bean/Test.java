/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodcu.bean;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

/**
 *
 * @author hakdogan
 */
public class Test {
    
    public static void main(String args[]){
        
        Sha256Hash sha256Hash; 
        String result = "";
        
        sha256Hash = new Sha256Hash("12345", (new SimpleByteSource("hakdogan")).getBytes());
        result = sha256Hash.toHex();
        System.out.println(result);
        
        sha256Hash = new Sha256Hash("12345");
        result = sha256Hash.toHex();
        System.out.println(result);
 
    }
    
}
