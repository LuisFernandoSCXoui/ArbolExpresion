package com.company;

import java.util.*;


public class ArbolExpresion {
    private Pila pOperandos;
    private Pila pOperadores;
    private final String blanco;
    private final String operadores;
    private Stack<Object> resutado = new Stack<>();
    private float a, b,c;
    private String ope;


    public ArbolExpresion() {
        pOperandos = new Pila();
        pOperadores = new Pila();
        blanco = " \t";
        operadores = ")+-*/%^(";  //acomodados por precedencia;
    }


    public NodoArbol construirArbol(String expresion) {
        StringTokenizer tokenizer;
        String token;
        NodoArbol raiz = null;

        tokenizer = new StringTokenizer(expresion, blanco + operadores, true);
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (blanco.indexOf(token) >= 0)
                ;               // Es un espacio en blanco, se ignora
            else if (operadores.indexOf(token) < 0) {
                // Es operando y lo guarda como nodo del arbol
                pOperandos.push(new NodoArbol(token));
            } else if (token.equals(")")) { // Saca elementos hasta encontrar (
                while (!pOperadores.estaVacia() && !pOperadores.top().equals("(")) {
                    guardarSubArbol();
                }
                pOperadores.pop();  // Saca el parentesis izquierdo
            } else {
                if (!token.equals("(") && !pOperadores.estaVacia()) {
                    //operador diferente de cualquier parentesis
                    String op = (String) pOperadores.top();
                    while (!op.equals("(") && !pOperadores.estaVacia()
                            && operadores.indexOf(op) >= operadores.indexOf(token)) {
                        guardarSubArbol();
                        if (!pOperadores.estaVacia())
                            op = (String) pOperadores.top();
                    }
                }
                pOperadores.push(token);  //Guarda el operador
            }
        }
        //Sacar todo lo que queda
        raiz = (NodoArbol) pOperandos.top();
        while (!pOperadores.estaVacia()) {
            if (pOperadores.top().equals("(")) {
                pOperadores.pop();
            } else {
                guardarSubArbol();
                raiz = (NodoArbol) pOperandos.top();
            }
        }
        return raiz;
    }

    /*
     * Metodo privado para almacenar en la pila un subarbol
     */
    private void guardarSubArbol() {
        NodoArbol op2 = (NodoArbol) pOperandos.pop();
        NodoArbol op1 = (NodoArbol) pOperandos.pop();
        pOperandos.push(new NodoArbol(op1, pOperadores.pop(), op2));

    }


    public void imprime(NodoArbol n) {
        if (n != null) {
            imprime(n.izquierda);
            System.out.print(n.valor + " ");
            imprime(n.derecha);
        }
    }

    public void res() {
        System.out.println("El resultado es: " + resutado.peek());
    }


    public void imprimePos(NodoArbol n) {
        if (n != null) {
            imprimePos(n.izquierda);
            imprimePos(n.derecha);
            System.out.print(n.valor + " ");
            try{
                c=Float.parseFloat((String) n.valor);
                resutado.push(c);
            }
            catch (Exception e){
                ope=(String)n.valor;
                a=Float.parseFloat(String.valueOf(resutado.pop()));
                b=Float.parseFloat(String.valueOf(resutado.pop()));
                switch (ope){
                    case"+":
                        resutado.push(b+a);
                        break;
                    case"-":
                        resutado.push(b-a);
                        break;
                    case"*":
                        resutado.push(b*a);
                        break;
                    case"/":
                        resutado.push(b/a);
                        break;
                    case"^":
                        resutado.push(Math.pow(b,a));
                        break;
                }
            }
        }
    }


    public void imprimePre(NodoArbol n) {
        if (n != null) {
            System.out.print(n.valor + " ");
            imprimePre(n.izquierda);
            imprimePre(n.derecha);
        }
    }
}

