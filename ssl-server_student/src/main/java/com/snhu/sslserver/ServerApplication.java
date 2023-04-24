package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class ServerApplication {
	public static void main(String[] args) throws NoSuchAlgorithmException{
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException {
        String data = "My name is Afshin Ahvazi of Global Rain";

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedDataInBytes = messageDigest.digest(data.getBytes());

        // Hex.encode from org.springframework.security is used to convert byte[] to char[], which is then converted to
        // a String
        return "<p>data: "+ data + "</p>" +
                "<p>Algorithm used: SHA-256</p>" +
                "<p>Hash value: " + new String(Hex.encode(hashedDataInBytes)) + "</p>";
    }
}
