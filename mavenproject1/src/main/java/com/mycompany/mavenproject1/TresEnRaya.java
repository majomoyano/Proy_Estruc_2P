/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class TresEnRaya {

    public static void main(String[] args) {
        // Ejemplo de uso
        Tablero tablero = new Tablero();
        tablero.hacerMovimiento(1, 1, 'X'); // Movimiento del jugador humano
        tablero.mostrarTablero();

        Minimax minimax = new Minimax();
        Movimiento mejorMovimiento = minimax.obtenerMejorMovimiento(tablero, 'O');
        tablero.hacerMovimiento(mejorMovimiento.fila, mejorMovimiento.columna, 'O'); // Movimiento de la computadora
        tablero.mostrarTablero();
    }
}
