/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mybatis.repository;

import com.example.mybatis.entity.Libro;
import java.util.List;
import java.util.Map;
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
public interface LibroMyBatisRepository {


    @Select("select p.idlibro, p.nombre, c.ideditorial, c.nombre as editorial from libro as p " +
    "inner join editorial as c on p.ideditorial = c.ideditorial")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from libro where idlibro=#{id}")
    public Libro readLibro(Integer id);

    @Delete("DELETE FROM libro WHERE idlibro = #{id}")
    public int deleteById(Integer id);
    
    @Insert("INSERT INTO libro(nombre, ideditorial) VALUES (#{nombre}, #{ideditorial})")
    public int insert(Libro libro);
    
    @Update("Update Libro set nombre=#{nombre}, ideditorial=#{ideditorial} where idlibro=#{idlibro}")
    public int update(Libro libro);
}