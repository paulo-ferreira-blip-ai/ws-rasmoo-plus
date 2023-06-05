package com.cliente.ws.rasmooplus.configuration.security;

import com.cliente.ws.rasmooplus.model.UserCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenConfig {

    //esse método faz a validação do token enviado na requisição, primeiramente criamoss um token
    //depois codificamos e por fim decotificamos e validamos se o token esta em conformidade com as regras

    @Value("${webservices.rasplus.jwt.expiration}")
    private String expiration;
    @Value("${webservices.rasplus.jwt.secret}")
    private String secret;
    private static final String EMISSOR = "API Rasmoo Plus";
    private static final Date TODAY = new Date();


    public String codificarToken(Authentication auth) {

        Date expirationDate = new Date(TODAY.getTime() + Long.parseLong(String.valueOf(expiration)));
        UserCredentials user = (UserCredentials) auth.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuer(EMISSOR)
                .setIssuedAt(TODAY)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }


//    public static Authentication decodificarToken(HttpServletRequest request) {
//
//        try {
//            String jwtToken = request.getHeader("Authorization");
//            jwtToken = jwtToken.replace(TOKEN_HEADER, "");
//
//            //fará o leitura do token
//            Jws<Claims> jwsClaims = Jwts.parserBuilder()
//                    .setSigningKey(TOKEN_KEY.getBytes())
//                    .build().parseClaimsJws(jwtToken);
//
//            //extraindo as informações do token
//            String usuario = jwsClaims.getBody().getSubject();
//            String emissor = jwsClaims.getBody().getIssuer();
//            Date validade = jwsClaims.getBody().getExpiration();
//
//            if (usuario.length() > 0 && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {
//
//                //caso a requisição tenha cabeçalho correto,
//                // aqui será gerado um token interno com as informações que for considerada relevantes.
//                return new UsernamePasswordAuthenticationToken("user",//nome do usuario, pode ser userName
//                        null,//quais as credencias que o usuario pode ter: usuario comum, admin
//                        Collections.emptyList());//aqui podemos listar os endpoints que o usuario terá acesso
//
//            }
//
//        } catch (Exception e) {
//            System.out.println("DEBUG - Erro ao decodificar Token");
//        }
//        return null;
//    }
}
