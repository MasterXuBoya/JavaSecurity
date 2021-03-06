package org.kwok.testlib.DSA;

import org.apache.commons.codec.binary.Hex;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class Test_DSA {
	
    public static final String src = "dsa test";

    public static void main(String[] args) throws Exception {
    	
        jdkDSA();
        
    }

    private static void jdkDSA() throws Exception {
    	
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        
        Signature dsa = Signature.getInstance("SHA1withDSA");
        dsa.initSign(keyPair.getPrivate());
        dsa.update(src.getBytes());
        byte[] sign = dsa.sign();
        System.out.println("JDK DSA SIGN:" + Hex.encodeHexString(sign));
        
        dsa.initVerify(keyPair.getPublic());
        dsa.update(src.getBytes());
        boolean verify = dsa.verify(sign);
        System.out.println("JDK DSA VERIFY:" + verify);
        
    }
}
