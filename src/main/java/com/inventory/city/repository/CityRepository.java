package com.inventory.city.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.city.model.City;


@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query(value="select * from city c where c.name like %:keyword% or c.photo like %:keyword%" , nativeQuery = true)
	List<City> findByKeyword(@Param("keyword") String keyword);

}
