package com.example.PROJECT.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	List<Country> findAll();

}
