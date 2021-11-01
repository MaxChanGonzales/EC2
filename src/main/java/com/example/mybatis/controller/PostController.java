/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.controller;

import com.example.mybatis.entity.Post;
import com.example.mybatis.repository.PostMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author BReyna
 */
@Controller
public class PostController {
   @Autowired
    private PostMyBatisRepository postMyBatisRepository;
    @RequestMapping("/")
    public String mensaje(Model model){
        model.addAttribute("menaje", "Bienvenidos Thymeleaf");
        return "index";
    }
    @RequestMapping("/posts")
    public String post(Model model){
        model.addAttribute("posts", postMyBatisRepository.findAll());
        return "post/post";
    }
    @RequestMapping("/form")
    public String create(Model model) {
        return "post/add";
    }
    @RequestMapping("/add")
    public String guardar(@RequestParam String titulo, @RequestParam String descripcion, Model model) {
        Post post = new Post();
        post.setTitulo(titulo);
        post.setDescripcion(descripcion);
        System.out.println("sout:"+post.getTitulo()+"/"+post.getDescripcion());
        postMyBatisRepository.insert(post);
        return "redirect:/posts";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
        System.out.println("ID: "+id);
        postMyBatisRepository.deleteById(id);
        return "redirect:/posts";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("post", postMyBatisRepository.readPost(id));
        return "post/edit";
    }
    @RequestMapping("/post/update")
    public String update(@RequestParam int id, @RequestParam String titulo, @RequestParam String descripcion) {
        Post post = postMyBatisRepository.readPost(id);
        post.setTitulo(titulo);
        post.setDescripcion(descripcion);
        postMyBatisRepository.update(post);
        return "redirect:/posts";
    }
}
