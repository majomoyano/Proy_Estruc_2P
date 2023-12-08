/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Majo
 *  cada instancia de la clase Nodo representa un 
 * estado del tablero y tiene una lista de nodos hijos que representan los posibles movimientos a partir de ese estado.
 */

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private Movimiento movimiento;
    private Tablero tablero;
    private char jugadorActual;
    private List<Nodo> hijos;

    public Nodo(Movimiento movimiento, Tablero tablero, char jugadorActual) {
        this.movimiento = movimiento;
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
        this.hijos = new ArrayList<>();
    }

    public Movimiento obtenerMovimiento() {
        return movimiento;
    }

    public List<Nodo> obtenerHijos() {
        return hijos;
    }

    public Tablero obtenerTablero() {
        return tablero;
    }

    public char obtenerJugadorActual() {
        return jugadorActual;
    }

    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }
}
