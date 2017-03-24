package com.javastaff.spring.boot.restjpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "articoli", path = "articoli")
public interface ArticoloRepository extends PagingAndSortingRepository<Articolo, Long> {

	List<Articolo> findByTitolo(@Param("titolo") String titolo);
	List<Articolo> findByTaglistIn(@Param("tags") List<String> tags);
	
	@Override
	@RestResource(exported = false)
	void delete(Articolo articolo);
	
	@Override
	@RestResource(exported = false)
	void delete(Iterable<? extends Articolo> articoli);
	
	@Override
	@RestResource(exported = false)
	void delete(Long id);
	
	@Override
	@RestResource(exported = false)
	void deleteAll();

}