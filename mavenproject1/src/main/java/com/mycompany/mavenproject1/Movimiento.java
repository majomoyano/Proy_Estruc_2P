/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Majo
 */
public class Movimiento {
    int fila;
    int columna;

    public Movimiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() {
        return columna;
    }
}
