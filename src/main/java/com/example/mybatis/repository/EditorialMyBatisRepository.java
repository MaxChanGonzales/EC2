/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mybatis.repository;

import com.example.mybatis.entity.Editorial;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
/**
 *
 * @author Max
 */
@Mapper
public interface EditorialMyBatisRepository {
    @Select("select * from editorial")
    public List<Editorial> findAll();
    
}
