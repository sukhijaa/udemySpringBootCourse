package com.sukhijaa.springrest.sukhijaaspringbootrest;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SukhijaaSpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SukhijaaSpringBootRestApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver sessionLocale = new AcceptHeaderLocaleResolver();
		sessionLocale.setDefaultLocale(Locale.US);
		return sessionLocale;
	}

}
