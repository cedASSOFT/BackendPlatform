package back.platform.security.jwt.filters;

import back.platform.security.jwt.authorizationHeader.ResponseHeader;
import back.platform.security.securityParameters.SecurityParams;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    static final Logger LOGGER = Logger.getLogger(JWTAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        response.addHeader(ResponseHeader.ACCESS_CONTROL_ORIGIN, ResponseHeader.STAR);
        response.addHeader(ResponseHeader.ACCESS_CONTROL_HEADERS, ResponseHeader.ALLOW_HEADERS);
        response.addHeader(ResponseHeader.ACCESS_CONTROL_EXPOSE_HEADERS, ResponseHeader.ALLOW_EXPOSE_HEADER);

        if (request.getMethod().equals("OPTION"))
            response.setStatus(HttpServletResponse.SC_OK);
        else {

            String jwtToken = request.getHeader(SecurityParams.JWT_HEADER_NAME);
            LOGGER.warn("JWT -> " + jwtToken);

            if (jwtToken == null || !jwtToken.startsWith(SecurityParams.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }

            Algorithm algorithm = Algorithm.HMAC256(SecurityParams.PRIVATE_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            String jwt = jwtToken.substring(SecurityParams.TOKEN_PREFIX.length(), jwtToken.length());

            DecodedJWT decodedJWT = verifier.verify(jwt);

            String username = decodedJWT.getSubject();

            LOGGER.debug("username recieved is " + username);

            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);

            Collection<GrantedAuthority> authorities = new ArrayList<>();

            roles.forEach(rolename -> {
                authorities.add(new SimpleGrantedAuthority(rolename));
            });

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        }
    }
}
