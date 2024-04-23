/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication37;

import java.util.Iterator;

/**
 *
 * @author Acer

import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class SimbolTable<Key extends Comparable<? super Key>, Value> implements Iterable<Key> {

    Node primero;

    private class Node {

        Key key;
        Value value;
        Node next;

        //constructor
        private Node() {
            this.next = null;
            this.key = null;
            this.value = null;
        }

        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    //COnstructor
    public SimbolTable() {
        primero = null;
    }

    //Metodos API
    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        Node recorre = primero;
        return size(recorre);
    }

    //Adicionar un elemento a la lista ordenada, garantizando que siga ordenada
    public void put(Key key, Value value) {
        Node actual, anterior = null;
        //Inicializar el elemento a adicionar
        Node nuevo = new Node(key, value);
        //UNa lista ordenada es null
        if (primero == null) {
            //UNa lista con un elemento es una lista ordenada
            System.out.println("lista con un elemento");
            primero = nuevo;
            return;
        }
        actual = primero;
        //El nuevo elemento es el primero de la lista
        if (key.compareTo(actual.key) <= 0) {
            System.out.println("El nuevo elemento es el primero de la lista");
            nuevo.next = primero;
            primero = nuevo;
            return;
        }
        //EL nuevo elemento se adiciona entre otros
        while (actual.next != null && key.compareTo(actual.next.key) >= 0) {
            actual = actual.next;
        }
        //Agregar el elemento entre actual y actual.next
        nuevo.next = actual.next;
        actual.next = nuevo;
        return;

    }

    public Value get(Key key) {
        Node actual = primero;
        while (actual != null) {
            if (actual.key.equals(key)) {
                return actual.value;
            }
            actual = actual.next;
        }
        return null;
    }

    public void delete(Key key) {
        Node anterior = null;
        Node actual = primero;
        while (actual != null) {
            if (actual.key.equals(key)) {
                System.out.println("Se va a eliminar " + actual.key + ":" + actual.value);
                if (anterior != null) {
                    anterior.next = actual.next;
                }
                if (actual == primero) {
                    primero = actual.next;
                }

            }
            anterior = actual;
            actual = actual.next;
        }

        actual = null;
    }

    public int size(Node temp) {
        if (temp == null) {
            return 0;
        }
        return 1 + size(temp.next);
    }

    public Iterator<Key> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Key> {

        //Declarar un atributo que tenga la referencia al primero
        private Node actual = primero;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Key next() {
            Key key = actual.key;
            Value value = actual.value;
            actual = actual.next;
            System.out.print(" key: " + key.toString() + " Valor " + value.toString());
            return key;
        }

    }

}

