package io.javaExpert.InfoService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaExpert.InfoService.Model.Info;

@Repository
public interface InfoRepository extends JpaRepository<Info, Integer>{

}
