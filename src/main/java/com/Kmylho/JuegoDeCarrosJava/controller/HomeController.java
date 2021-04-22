package com.Kmylho.JuegoDeCarrosJava.controller;

import com.Kmylho.JuegoDeCarrosJava.entity.models.Home;
import com.Kmylho.JuegoDeCarrosJava.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        model.setViewName("Home");
        return model;
    }

    @Autowired
    private HomeService service;

    @GetMapping(value= "api/index")
    public Iterable<Home> list(){
        return service.list();
    }

    @PostMapping(value= "api/home")
    public Home save(@RequestBody Home home){
        return service.save(home);
    }

    @PutMapping(value= "api/home")
    public Home update(@RequestBody Home home){
        if(home.getId() != null) {
            if (home.getPrimerPuesto() != null && home.getSegundoPuesto() != null && home.getTercerPuesto() != null){
                return service.save(home);
            }
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value= "api/{id}/home")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping(value= "api/{id}/home")
    public Home get(@PathVariable("id") Long id){
        return service.get(id);
    }
}
