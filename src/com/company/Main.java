package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String guardar;
        System.out.println("INTRODUCE LA EXPRESION QUE DESEA RESOLVER");
        guardar = leer.nextLine();
      Solucion objeto= new Solucion();
      objeto.mostrar(guardar);
    }
}
