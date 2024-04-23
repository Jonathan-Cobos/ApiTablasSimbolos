/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication37;

import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Acer
 */
public class APISimbolos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     // Crear una instancia de SimbolTable
        SimbolTable<Integer, String> tablaDeSimbolos = new SimbolTable<>();
        Iterator<Integer> iterator = tablaDeSimbolos.iterator();

        // Agregar elementos a la tabla de símbolos
        tablaDeSimbolos.put(1, "Uno");
        tablaDeSimbolos.put(2, "Dos");
        tablaDeSimbolos.put(3, "Tres");

        // Imprimir el tamaño de la tabla de símbolos
        System.out.println("Tamaño de la tabla de símbolos: " + tablaDeSimbolos.size());

        // Obtener y mostrar el valor asociado
        System.out.println("Valor asociado a la key 2: " + tablaDeSimbolos.get(2));

        
        // Imprimir el tamaño después de la eliminación
        System.out.println("Tamaño después de eliminar: " + tablaDeSimbolos.size());

        // Iterar sobre las claves de la tabla de símbolos
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println( key);
        }
    }
}