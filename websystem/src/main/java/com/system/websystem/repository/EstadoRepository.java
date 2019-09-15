package com.system.websystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.system.websystem.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
List<Estado> findByNome(String nome);
	
	@Query("select e from Estado e where e.nome like %?1%")
	List<Estado> buscarPorNome(String nome);


}
