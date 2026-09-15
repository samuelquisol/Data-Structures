package view;

import java.util.Scanner;
import controller.List;

public class SimpleList {

    private static Scanner scan = new Scanner(System.in);
    private static List objList = new List();

    public static void main(String[] args) {
        byte opc;

        do {
            opc = menu();

            switch (opc) {
                case 1 -> {
                    insertHead();
                }
                case 2 -> {
                    beginningInsert();
                }
                case 3 -> {
                    beginningDelete();
                }
                case 4 -> {
                    endInsert();
                }
                case 5 -> {
                    through();
                }
                case 6 -> {
                    throughRecursive();
                }
                case 7 -> {
                    destroy();
                }
            }
        } while (opc < 8);
    }

    private static byte menu() {
        System.out.println("\nGestion de Listas Simplemente Ligadas");
        System.out.println("1. Insertar");
        System.out.println("2. Insertar al inicio");
        System.out.println("3. Eliminar al inicio");
        System.out.println("4. Insertar al final");
        System.out.println("5. Mostrar los datos de la lista");
        System.out.println("6. Mostrar los datos de la lista recursivamente");
        System.out.println("7. Destruir la lista");
        System.out.println("8. Salir");

        byte opcMenu;
        do {
            System.out.println("Ingrese la opción: ");
            opcMenu = scan.nextByte();
        } while (opcMenu > 8);

        return opcMenu;
    }

    private static void insertHead() {
        System.out.println("\nIngresar numeros enteros a la lista");

        char next;
        int value;

        do {
            System.out.println("\nIngrese un numero: ");
            value = scan.nextInt();

            try {
                if (objList.insertHead(value)) {
                    System.out.println("Numero ingresado!..");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nDesea ingresar otro entero S / N :");
            next = scan.next().toUpperCase().charAt(0);
        } while (next == 'S');
    }

    private static void beginningInsert() {
        System.out.println("\nIngresar numeros enteros al inicio de la lista");

        char next;
        int value;

        do {
            System.out.println("\nIngrese un numero: ");
            value = scan.nextInt();

            try {
                if (objList.beginningInsert(value)) {
                    System.out.println("Numero ingresado!..");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nDesea ingresar otro entero S / N :");
            next = scan.next().toUpperCase().charAt(0);
        } while (next == 'S');
    }

    private static void beginningDelete() {
        System.out.println("\nEliminar numeros enteros al inicio de la lista");

        char next;

        do {
            try {
                if (objList.beginningDelete()) {
                    System.out.println("Numero eliminado!..");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\n¿Desea eliminar otro número al inicio de la lista? S / N :");
            next = scan.next().toUpperCase().charAt(0);
        } while (next == 'S');
    }

    private static void endInsert() {
        objList.initializeCurrent();

        System.out.println("\nIngresar numeros enteros al final de la lista");

        char next;
        int value;

        do {
            System.out.println("\nIngrese un numero: ");
            value = scan.nextInt();

            try {
                if (objList.endInsert(value)) {
                    System.out.println("Numero ingresado!..");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nDesea ingresar otro entero S / N :");
            next = scan.next().toUpperCase().charAt(0);
        } while (next == 'S');
    }

    private static void through() {
        System.out.println("\nMostrando los datos de la lista");

        try {
            objList.initializeCurrent();
            int result = objList.through();
            int countNodes = 0;
            boolean flag = true;

            while (result != 0) {
                countNodes++;
                System.out.println("El dato del nodo " + countNodes + " es: " + result);
                result = objList.through();
                flag = false;
            }

            if (result == 0 && flag) {
                System.out.println("\nLa lista esta vacia!...");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void throughRecursive() {
        System.out.println("\nMostrando los datos de la lista de forma recursiva");

        try {
            objList.initializeCurrent();
            int result = objList.through();

            if (result == 0) {
                System.out.println("\nLa lista esta vacia!...");
            } else {
                int countNodes = 1;
                realRecursive(result, countNodes);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void realRecursive(int result, int countNodes) {
        if (result != 0) {
            System.out.println("El dato del nodo " + countNodes + " es: " + result);
            countNodes++;

            try {
                realRecursive(objList.through(), countNodes);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void destroy() {
        System.out.println("\nDestruyendo los nodos de la lista");

        objList.initializeCurrent();

        try {
            String result = objList.destroy()
                    ? "La lista fue destruida!..."
                    : "La lista esta vacia!...";

            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
