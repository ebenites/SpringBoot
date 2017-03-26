package pe.edu.tecsup.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(sitecAuthenticationProvider);
		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/"/*, "/**"*/).permitAll()
				.antMatchers("/admin/**").authenticated()
				.and()
//                    .formLogin().loginPage("/login").loginProcessingUrl("/authenticate").defaultSuccessUrl("/admin/").failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
				.httpBasic()
				.and()
//                    .logout().logoutUrl("/logout").logoutSuccessUrl("/")
					.logout().logoutUrl("/logout").logoutSuccessUrl("http://BADNAME@localhost:8080/")
				.and()
					.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}