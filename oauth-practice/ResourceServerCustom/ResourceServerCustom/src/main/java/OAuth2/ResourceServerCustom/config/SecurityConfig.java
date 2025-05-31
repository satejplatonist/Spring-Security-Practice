package OAuth2.ResourceServerCustom.config;

import java.io.InputStream;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.Resource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.converter.RsaKeyConverters;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
  @Value("${spring.security.oauth2.resourceserver.jwt.public-key-location}")
  private Resource publicKeyResource;
	
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
  {
	  http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
	      .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
	  return http.build();
  }
  
  @Bean
  public JwtDecoder jwtDecoder()
  {
	  return NimbusJwtDecoder.withPublicKey((publicKey())).build();
  }

  private RSAPublicKey publicKey() 
  {	
	  // 
	  return null;
  }
}
