package com.company;

public class NodoArbol {
    public Object valor;           //Valor que almacenado en el nodo
    public NodoArbol izquierda;    //Liga a la izquierda
    public NodoArbol derecha;      //Liga a la derecha


    public NodoArbol () {
        this (null, null, null);
    }


    public NodoArbol (Object valor) {
        this (null, valor, null);
    }


    public NodoArbol (NodoArbol iz, Object v, NodoArbol der) {
        valor = v;
        izquierda = iz;
        derecha = der;
    }
}
