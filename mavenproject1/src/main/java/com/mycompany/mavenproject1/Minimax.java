/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Majo
 * Minimax, busca el mejor movimiento para la computadora 
 * considerando el peor escenario posible por parte del jugador humano.
 */
import java.util.List;

public class Minimax {

    public Movimiento obtenerMejorMovimiento(Tablero tablero, char jugador) {
        Nodo raiz = construirArbol(tablero, jugador);
        List<Nodo> movimientosLegales = raiz.obtenerHijos();

        int mejorValor = Integer.MIN_VALUE;
        Movimiento mejorMovimiento = null;

        for (Nodo nodo : movimientosLegales) {
            int valorMinimax = minimax(nodo, 0, false);

            if (valorMinimax > mejorValor) {
                mejorValor = valorMinimax;
                mejorMovimiento = nodo.obtenerMovimiento();
            }
        }

        return mejorMovimiento;
    }

    private Nodo construirArbol(Tablero tablero, char jugador) {
        Nodo raiz = new Nodo(null, tablero, jugador); // Modificado para aceptar el nodo padre como null
        List<Movimiento> movimientosLegales = tablero.obtenerMovimientosLegales();

        for (Movimiento movimiento : movimientosLegales) {
            Tablero nuevoTablero = clonarTablero(tablero);
            nuevoTablero.hacerMovimiento(movimiento.fila, movimiento.columna, jugador);
            Nodo hijo = new Nodo(movimiento, nuevoTablero, (jugador == 'X') ? 'O' : 'X');
            raiz.agregarHijo(hijo);
        }

        return raiz;
    }

    private int minimax(Nodo nodo, int profundidad, boolean esMaximizando) {
        Tablero tablero = nodo.obtenerTablero();

        if (tablero.hayGanador('X')) {
            return -1; // Valor para jugador 'X'
        } else if (tablero.hayGanador('O')) {
            return 1; // Valor para jugador 'O'
        } else if (tablero.estaCompleto()) {
            return 0; // Empate
        }

        if (esMaximizando) {
            int mejorValor = Integer.MIN_VALUE;
            List<Nodo> movimientosLegales = nodo.obtenerHijos();

            for (Nodo hijo : movimientosLegales) {
                int valor = minimax(hijo, profundidad + 1, false);
                mejorValor = Math.max(mejorValor, valor);
            }
            return mejorValor;
        } else {
            int mejorValor = Integer.MAX_VALUE;
            List<Nodo> movimientosLegales = nodo.obtenerHijos();

            for (Nodo hijo : movimientosLegales) {
                int valor = minimax(hijo, profundidad + 1, true);
                mejorValor = Math.min(mejorValor, valor);
            }
            return mejorValor;
        }
    }

    private Tablero clonarTablero(Tablero tablero) {
        Tablero nuevoTablero = new Tablero();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nuevoTablero.hacerMovimiento(i, j, tablero.obtenerEstado(i, j));
            }
        }
        return nuevoTablero;
    }
}
