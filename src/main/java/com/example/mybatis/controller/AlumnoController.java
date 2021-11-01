/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.controller;

import com.example.mybatis.entity.Alumno;
import com.example.mybatis.repository.AlumnoMyBatisRepository;
import com.example.mybatis.repository.CarreraMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LAN CENTER LEONPERU
 */
@Controller
public class AlumnoController {
      

    @Autowired
    private CarreraMyBatisRepository carreraMyBatisRepository;

    @Autowired
    private AlumnoMyBatisRepository alumnoMyBatisRepository;

    @RequestMapping("/prods")
    public String prods(Model model) {
        model.addAttribute("prods", alumnoMyBatisRepository.findAll());
        return "Alumno/prods";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("cats", carreraMyBatisRepository.findAll());
        return "Alumno/addalum";
    }

    @RequestMapping("/prodadd")
    public String guardar(@RequestParam String nombre, @RequestParam String telefono, @RequestParam String correo , @RequestParam int idcar, Model model) {
        Alumno prod = new Alumno();
        prod.setNombre(nombre);
        prod.setTelefono(telefono);
        prod.setCorreo(correo);
        prod.setIdcarrera(idcar);
       alumnoMyBatisRepository.insert(prod);
        return "redirect:/prods";
    }
    @RequestMapping("/delalum/{id}")
    public String deleteprod(@PathVariable(value="id") int id) {
        alumnoMyBatisRepository.deleteById(id);
        return "redirect:/prods";
    }
    @RequestMapping("/editalum/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("cats", carreraMyBatisRepository.findAll());
        model.addAttribute("prod", alumnoMyBatisRepository.readAlumno(id));
        return "Alumno/editalum";
    }
    @RequestMapping("/updatealum")
    public String update(@RequestParam int idalumno, @RequestParam String nombre, 
            @RequestParam String telefono,  @RequestParam String correo, @RequestParam int idcarrera) {
        System.out.println(idalumno+"/"+nombre+"/"+telefono+"/"+correo+"/"+idcarrera);
        Alumno prod = alumnoMyBatisRepository.readAlumno(idalumno);
        prod.setNombre(nombre);
        prod.setTelefono(telefono);
        prod.setCorreo(correo);
        prod.setIdcarrera(idcarrera);
        alumnoMyBatisRepository.update(prod);
        return "redirect:/prods";
    }
    }
    
    

