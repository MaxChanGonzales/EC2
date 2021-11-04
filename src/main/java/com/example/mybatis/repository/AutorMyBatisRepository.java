/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mybatis.repository;

import com.example.mybatis.entity.Autor;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 *
 * @author Max
 */
@Mapper
public interface AutorMyBatisRepository {

    @Select("select * from autor")
    public List<Autor> findAll();
    
    @Select("select * from autor where idautor=#{id}")
    public Autor readAutor(Integer id);

    @Delete("DELETE FROM autor WHERE idautor = #{id}")
    public int deleteById(Integer id);

    @Insert("INSERT INTO autor(nombres, apellidos) VALUES (#{nombres}, #{apellidos})")
    public int insert(Autor autor);

    @Update("Update autor set nombres=#{nombres}, apellidos=#{apellidos} where idautor=#{idautor}")
    public int update(Autor autor);
    
}
