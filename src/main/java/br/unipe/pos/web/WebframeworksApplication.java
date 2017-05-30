package br.unipe.pos.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.unipe.pos.web.model"})
@EnableJpaRepositories(basePackages = {"br.unipe.pos.web.dao"})
@ComponentScan(basePackages = {"br.unipe.pos.web.controller"})
public class WebframeworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebframeworksApplication.class, args);
	}
}
