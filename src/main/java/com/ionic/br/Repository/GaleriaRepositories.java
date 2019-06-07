package com.ionic.br.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionic.br.Model.Galeria;

@Repository
public interface GaleriaRepositories extends JpaRepository<Galeria, Integer> {

}
