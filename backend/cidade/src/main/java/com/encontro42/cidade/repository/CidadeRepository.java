package com.encontro42.cidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encontro42.cidade.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
