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
public class  Tablero {
    private char[][] estado;

    public Tablero() {
        estado = new char[3][3];
        // Inicializar el tablero con caracteres vacíos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                estado[i][j] = ' ';
            }
        }
    }

    public void hacerMovimiento(int fila, int columna, char jugador) {
        estado[fila][columna] = jugador;
    }

    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(estado[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Métodos para verificar el estado del juego y obtener movimientos legales...y que no hayan trampillas jeje xd
    public boolean hayGanador(char jugador) {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((estado[i][0] == jugador && estado[i][1] == jugador && estado[i][2] == jugador) ||
                (estado[0][i] == jugador && estado[1][i] == jugador && estado[2][i] == jugador)) {
                return true;
            }
        }

        // Verificar diagonales
        if ((estado[0][0] == jugador && estado[1][1] == jugador && estado[2][2] == jugador) ||
            (estado[0][2] == jugador && estado[1][1] == jugador && estado[2][0] == jugador)) {
            return true;
        }

        return false;
    }

    public boolean estaCompleto() {
        // Verificar si el tablero está completo (que no haya espacios vacíos)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Movimiento> obtenerMovimientosLegales() {
        // Obtener movimientos legales (casillas vacías)
        List<Movimiento> movimientosLegales = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j] == ' ') {
                    movimientosLegales.add(new Movimiento(i, j));
                }
            }
        }

        return movimientosLegales;
    }
    
    public char obtenerEstado(int fila, int columna) {
        // Obtener el estado de una celda específica
        return estado[fila][columna];
    }
    
}