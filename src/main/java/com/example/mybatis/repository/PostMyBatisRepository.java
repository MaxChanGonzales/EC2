/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.repository;

import com.example.mybatis.entity.Post;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author BReyna
 */
@Mapper
public interface PostMyBatisRepository {

    @Select("select * from post")
    public List<Post> findAll();
    
    @Select("select * from post where idpost=#{id}")
    public Post readPost(Integer id);

    @Delete("DELETE FROM post WHERE idpost = #{id}")
    public int deleteById(Integer id);

    @Insert("INSERT INTO post(titulo, descripcion) VALUES (#{titulo}, #{descripcion})")
    public int insert(Post post);

    @Update("Update post set titulo=#{titulo}, descripcion=#{descripcion} where idpost=#{idpost}")
    public int update(Post post);
}
