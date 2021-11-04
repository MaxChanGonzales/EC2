/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis.controller;

import com.example.mybatis.entity.Libro;
import com.example.mybatis.repository.EditorialMyBatisRepository;
import com.example.mybatis.repository.LibroMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Max
 */
@Controller
public class LibroController {
 
    @Autowired
    private EditorialMyBatisRepository editorialMyBatisRepository;
    
    @Autowired
    private LibroMyBatisRepository libroMyBatisRepository;
    private int idlibro;
    
    @RequestMapping("/prods")
    public String prods(Model model) {
        model.addAttribute("prods", libroMyBatisRepository.findAll());
        return "Libro/prods";
    }
    
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("cats", editorialMyBatisRepository.findAll());
        return "Libro/addlibro";
    }
    
    @RequestMapping("/prodadd")
    public String guardar(@RequestParam String nombre, @RequestParam int idcar, Model model) {
        Libro prod = new Libro();
        prod.setNombre(nombre);
        prod.setIdeditorial(idcar);
        libroMyBatisRepository.insert(prod);
        return "redirect:/prods";
    }
    
    @RequestMapping("/dellibro/{id}")
    public String deleteprod(@PathVariable(value="id") int id) {
        libroMyBatisRepository.deleteById(id);
        return "redirect:/prods";
    }
    
    @RequestMapping("/editlibro/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("cats", editorialMyBatisRepository.findAll());
        model.addAttribute("prod", libroMyBatisRepository.readLibro(id));
        return "Libro/editlibro";
    }
    @RequestMapping("/updatelibro")
    public String update(@RequestParam int idalumno, @RequestParam String nombre,@RequestParam int ideditorial) {
        System.out.println(idalumno+"/"+nombre+"/"+ideditorial);
        Libro prod = (Libro) libroMyBatisRepository.readLibro(idlibro);
        prod.setNombre(nombre);
        prod.setIdeditorial(ideditorial);
        libroMyBatisRepository.update(prod);
        return "redirect:/prods";
    }
} 
    

