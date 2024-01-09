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
        
        Tablero tablero = new Tablero();
    
        Minimax minimax = new Minimax();
        // Supongamos que el juego continúa hasta que alguien gane o el tablero se llene
        while (!tablero.estaCompleto() && !tablero.hayGanador('X') && !tablero.hayGanador('O')) {
            
            // Movimiento del jugador humano
            tablero.hacerMovimiento(1, 1, 'X'); 
            tablero.mostrarTablero();
            
            // Mostrar recomendaciones después del movimiento del jugador humano
            if (!tablero.estaCompleto()) {
                Movimiento recomendacion = minimax.recomendarMovimientoHumano(tablero, 'X');
                System.out.println("Recomendación: mover en fila " + recomendacion.obtenerFila() + ", columna " + recomendacion.obtenerColumna());
            }
            
            //movimiento de la computadora
            if (!tablero.estaCompleto()) {
                Movimiento mejorMovimiento = minimax.obtenerMejorMovimiento(tablero, 'O');
                tablero.hacerMovimiento(mejorMovimiento.fila, mejorMovimiento.columna, 'O');
                tablero.mostrarTablero();
            }
        
        }
        // Determinar el ganador o declarar un empate
        if (tablero.hayGanador('X')) {
            System.out.println("¡El jugador X ha ganado!");
        } else if (tablero.hayGanador('O')) {
            System.out.println("¡La computadora ha ganado!");
        } else {
            System.out.println("Es un empate.");
        }
    }
}