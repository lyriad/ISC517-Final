package com.isc517final.microservices.users.Utils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Component;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;

@Component
public class JWTUtils {

    public String createJWT(String id, String issuer, String subject, String email) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + 3600000;
        Date exp = new Date(expMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("THISISASTUPIDPRIVATEKEY1234567890");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
                .claim("email", email).signWith(signatureAlgorithm, signingKey).setExpiration(exp);

        return builder.compact();
    }

    public boolean decodeJWT(String jwt) {

        try {
            Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("THISISASTUPIDPRIVATEKEY1234567890"))
                .parseClaimsJws(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
