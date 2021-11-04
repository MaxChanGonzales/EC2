/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis.controller;

import com.example.mybatis.entity.Autor;
import com.example.mybatis.repository.AutorMyBatisRepository;
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
public class AutorController {
    @Autowired
    private AutorMyBatisRepository autorMyBatisRepository;
    @RequestMapping("/")
    public String mensaje(Model model){
        model.addAttribute("menaje", "Bienvenidos Thymeleaf");
        return "index";
    }
    @RequestMapping("/autors")
    public String autor(Model model){
        model.addAttribute("autors", autorMyBatisRepository.findAll());
        return "autor/autor";
    }
    @RequestMapping("/form")
    public String create(Model model) {
        return "autor/add";
    }
    @RequestMapping("/add")
    public String guardar(@RequestParam String nombres, @RequestParam String apellidos, Model model) {
        Autor autor = new Autor();
        autor.setNombres(nombres);
        autor.setApellidos(apellidos);
        System.out.println("sout:"+autor.getNombres()+"/"+autor.getApellidos());
        autorMyBatisRepository.insert(autor);
        return "redirect:/autors";
    }
    
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
        System.out.println("ID: "+id);
        autorMyBatisRepository.deleteById(id);
        return "redirect:/autors";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("autor", autorMyBatisRepository.readAutor(id));
        return "autor/edit";
    }
    @RequestMapping("/autor/update")
    public String update(@RequestParam int id, @RequestParam String nombres, @RequestParam String apellidos) {
        Autor autor = autorMyBatisRepository.readAutor(id);
        autor.setNombres(nombres);
        autor.setApellidos(apellidos);
        autorMyBatisRepository.update(autor);
        return "redirect:/autors";
    }
}