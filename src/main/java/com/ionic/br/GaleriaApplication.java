package com.ionic.br;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ionic.br.Model.Galeria;
import com.ionic.br.Repository.GaleriaRepositories;

@SpringBootApplication
public class GaleriaApplication implements CommandLineRunner {

	@Autowired
	private GaleriaRepositories galeriaRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(GaleriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Galeria gal = new Galeria(null, "Album Eneylton", "ene.jpeg");
		
		galeriaRepos.saveAll(Arrays.asList(gal));
		
		
	}

}
