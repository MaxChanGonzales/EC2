/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.repository;

import com.example.mybatis.entity.Alumno;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author LAN CENTER LEONPERU
 */
@Mapper
public interface AlumnoMyBatisRepository {
    
    @Select("select p.idalumno, p.nombre, p.telefono, p.correo, c.idcarrera, c.nombre as carrera from alumno as p " +
    "inner join carrera as c on p.idcarrera = c.idcarrera")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from alumno where idalumno=#{id}")
    public Alumno readAlumno(Integer id);

    @Delete("DELETE FROM alumno WHERE idalumno = #{id}")
    public int deleteById(Integer id);
    
    @Insert("INSERT INTO alumno(nombre, telefono, correo, idcarrera) VALUES (#{nombre}, #{telefono}, #{correo}, #{idcarrera})")
    public int insert(Alumno alumno);
    //UPDATE `bdejemplo`.`producto` SET `nombre` = 'www', `precio` = '5', `idcategoria` = '2' WHERE (`idproducto` = '19');
    @Update("Update Alumno set nombre=#{nombre}, telefono=#{telefono}, correo=#{correo}, idcarrera=#{idcarrera} where idalumno=#{idalumno}")
    public int update(Alumno alumno);
}
