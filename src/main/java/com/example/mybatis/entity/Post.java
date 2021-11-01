/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BReyna
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Post implements Serializable{
    private int idpost;
    private String titulo;
    private String descripcion;
}