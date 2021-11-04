/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Max
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {
        private static final long serialVersionUID = 3754851399214200439L;
	private int idlibro;
	private String nombre;
        private int ideditorial;
}
