package com.company;

public class NodoPila {
    public Object elemento;
    public NodoPila sgte;


    NodoPila(Object valor) {
        this (valor, null);
    }

    NodoPila(Object valor, NodoPila n) {
        elemento = valor;
        sgte = n;
    }


    public Object obtenerElemento () { return elemento; }


    public NodoPila obtenerSgte() { return sgte;}
}
