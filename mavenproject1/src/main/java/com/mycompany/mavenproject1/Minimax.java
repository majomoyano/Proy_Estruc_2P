/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class Minimax {
    
    public Movimiento obtenerMejorMovimiento(Tablero tablero, char jugador) {
        List<Movimiento> movimientosLegales = obtenerMovimientosLegales(tablero);

        int mejorValor = Integer.MIN_VALUE;
        Movimiento mejorMovimiento = null;

        for (Movimiento movimiento : movimientosLegales) {
            Tablero nuevoTablero = clonarTablero(tablero);
            nuevoTablero.hacerMovimiento(movimiento.fila, movimiento.columna, jugador);

            int valorMinimax = minimax(nuevoTablero, 0, false);

            if (valorMinimax > mejorValor) {
                mejorValor = valorMinimax;
                mejorMovimiento = movimiento;
            }
        }

        return mejorMovimiento;
    }

    private List<Movimiento> obtenerMovimientosLegales(Tablero tablero) {
        // Implementar lógica para obtener movimientos legales
        return tablero.obtenerMovimientosLegales();
    }

    private int minimax(Tablero tablero, int profundidad, boolean esMaximizando) {
        if (tablero.hayGanador('X')) {
            return -1; // Valor para jugador 'X'
        } else if (tablero.hayGanador('O')) {
            return 1; // Valor para jugador 'O'
        } else if (tablero.estaCompleto()) {
            return 0; // Empate
        }

        if (esMaximizando) {
            int mejorValor = Integer.MIN_VALUE;
            List<Movimiento> movimientosLegales = tablero.obtenerMovimientosLegales();

            for (Movimiento movimiento : movimientosLegales) {
                Tablero nuevoTablero = clonarTablero(tablero);
                nuevoTablero.hacerMovimiento(movimiento.fila, movimiento.columna, 'O');
                int valor = minimax(nuevoTablero, profundidad + 1, false);
                mejorValor = Math.max(mejorValor, valor);
            }
            return mejorValor;
        } else {
            int mejorValor = Integer.MAX_VALUE;
            List<Movimiento> movimientosLegales = tablero.obtenerMovimientosLegales();

            for (Movimiento movimiento : movimientosLegales) {
                Tablero nuevoTablero = clonarTablero(tablero);
                nuevoTablero.hacerMovimiento(movimiento.fila, movimiento.columna, 'X');
                int valor = minimax(nuevoTablero, profundidad + 1, true);
                mejorValor = Math.min(mejorValor, valor);
            }
            return mejorValor;
        }
    }

    private Tablero clonarTablero(Tablero tablero) {
        // Implementar la lógica para clonar el tablero
        Tablero nuevoTablero = new Tablero();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nuevoTablero.hacerMovimiento(i, j, tablero.obtenerEstado(i, j));
            }
        }
        return nuevoTablero;
    }

    
}
