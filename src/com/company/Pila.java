package com.company;

public class Pila implements Apilable{
    private NodoPila tope;                // Tope de la pila
    private int nDatos;               // Cantidad de datos en la pila

    /**
     * Construye la pila vacia.
     */
    public Pila() {
        tope = null;
        nDatos = 0;
    }

    /**
     * Verifica que la pila este vacia.
     * @return true si lo esta y falso en otro caso.
     */
    public boolean estaVacia (){
        return tope == null;
    }

    /**
     * Vacia una pila.
     */
    public void vaciar() {
        tope = null;
        nDatos = 0;
    }

    /**
     * Metodo para conocer el tamano de una pila
     * @return int -- cantidad de elementos en la pila
     */
    public int tamanio() {
        return nDatos;
    }

    /**
     * Devuelve el elemento del tope de la pila (sin alterar esta)
     * o bien null si se encuentra vacia.
     * @return Object -- objeto del tope de la pila
     */
    public Object top() {
        return (estaVacia()) ? null : tope.elemento;
    }

    /**
     * Extrae el elemento del tope de la pila.
     * Devuelve null si la pila esta vacia.
     * @return Object -- objeto del tope de la pila
     */
    public Object pop() {
        if (estaVacia())
            return null;

        Object dato = tope.elemento;
        tope = tope.sgte;
        nDatos --;
        return dato;
    }

    /**
     * Inserta un nuevo elemento en la pila.
     * @param x el elemento a insertar.
     */
    public void push(Object x) {
        tope = new NodoPila(x, tope);
        nDatos++;
    }

    /**
     * Iterador para moverse sobre los elementos de la pila sin alterarla.
     */
    public java.util.Iterator iterador() {
        return new MiIterador();
    }

    private class MiIterador implements java.util.Iterator {
        private NodoPila posicion = tope;

        public boolean hasNext() { return posicion != null;}

        public Object next() {
            if (hasNext()) {
                Object o = posicion.elemento;
                posicion = posicion.sgte;
                return o;
            }
            return null;
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }
}
