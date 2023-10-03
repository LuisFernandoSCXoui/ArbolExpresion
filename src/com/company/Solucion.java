package com.company;

public class Solucion {
    public void mostrar (String guardar){
        ArbolExpresion expresion = new ArbolExpresion();
        NodoArbol raiz = expresion.construirArbol(guardar);
       // System.out.println("Arbol: ");
       // expresion.imprime(raiz);
       // System.out.println("");
        System.out.println(" PreOrden: ");
        expresion.imprimePre(raiz);
        System.out.println("");
        System.out.println(" PosOrden: ");
        expresion.imprimePos(raiz);
        System.out.println("");
        expresion.res();
    }
}
