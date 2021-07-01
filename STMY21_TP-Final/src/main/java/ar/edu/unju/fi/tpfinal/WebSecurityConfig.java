package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.service.imp.LoginUserServiceImp;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	ManejadorAUTH autenticacion;
	String[] resources = new String[] {
			"/include/**","/css/**","/assets/**","/js/**","/layer/**","/webjars/**"
	};
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/","/home","/index").permitAll()
				.antMatchers("/office/**","/employee/**").hasAuthority("ADMINISTRADOR")
				//.antMatchers("/producto").hasAuthority("administrador")
				//.antMatchers("/cargarRegistro/","/buscarPersona","/cargarPersona", "/guardarCondicion", "/").hasAuthority("CLIENTE")
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().accessDeniedPage("/")
				.and()
			.formLogin()				
				.loginPage("/login").permitAll()
				.successHandler(autenticacion)				
				.failureUrl("/login?error=true")
				.usernameParameter("usuario")
				.passwordParameter("password")
				.and()
			.logout()
				.permitAll()		
				.logoutSuccessUrl("/login");	
				//http.csrf().disable();
	}
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
	
	@Autowired
    LoginUserServiceImp userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    
    }
}
