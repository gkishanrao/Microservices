package com.edayspractice.userInfo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edayspractice.userInfo.model.CatalogItems;


  
@Repository
public interface CatalogRepository extends JpaRepository<CatalogItems, Integer> {

	
}
