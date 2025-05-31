package OAuth2.ResourceServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.oauth2.server.resource.introspection.SpringOpaqueTokenIntrospector;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
   {
	   http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
	       .oauth2ResourceServer((opaque) -> opaque.opaqueToken(Customizer.withDefaults()));
	   return http.build();
   }
   
   @SuppressWarnings("removal")
   @Bean
   public OpaqueTokenIntrospector opaqueTokenIntrospector()
   {
	   return new SpringOpaqueTokenIntrospector("https://my-auth-server.com/oauth2/introspect", "my-client-id", "my-client-secret");
   }
}
