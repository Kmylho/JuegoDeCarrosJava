package com.Kmylho.JuegoDeCarrosJava.service;

import com.Kmylho.JuegoDeCarrosJava.entity.models.Home;
import com.Kmylho.JuegoDeCarrosJava.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public Iterable<Home> list(){
        return homeRepository.findAll();
    }

    public Home save(Home home){
        return homeRepository.save(home);
    }

    public void delete(Long id){
        homeRepository.delete(get(id));
    }

    public Home get(Long id){
        return homeRepository.findById(id).orElseThrow();
    }

}

