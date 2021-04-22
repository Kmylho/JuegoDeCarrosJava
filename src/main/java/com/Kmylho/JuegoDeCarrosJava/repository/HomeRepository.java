package com.Kmylho.JuegoDeCarrosJava.repository;

import com.Kmylho.JuegoDeCarrosJava.entity.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}
