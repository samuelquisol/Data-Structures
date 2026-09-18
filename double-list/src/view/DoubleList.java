package view;

import java.util.Scanner;
import controller.DoubleListController;

public class DoubleList {

    static Scanner scan = new Scanner(System.in);
    static DoubleListController objDoubleList = new DoubleListController();

    public static void main(String[] args) {
        byte opc;

        do {
            opc = menu();

            switch (opc) {
                case 1 -> {
                    Insert();
                }
                case 2 -> {
                    through();
                }
                case 3 -> {
                    recursiveThrough();
                }
                case 4 -> {
                    destroy();
                }
                case 5 -> {
                    removeNodes();
                }

            }
        } while (opc < 6);
    }

    private static byte menu() {
        System.out.println("\nGestion de Listas Doblemente Ligadas");
        System.out.println("1. Insertar valores a la lista");
        System.out.println("2. Mostrar los datos de la lista en forma Iterativa");
        System.out.println("3. Mostrar los datos de la lista en forma recursiva");
        System.out.println("4. Destruir la lista");
        System.out.println("5. Eliminar un dato de la lista");
        System.out.println("6. para salir");

        byte opcMenu;
        do {
            System.out.println("Ingrese la opción: ");
            opcMenu = scan.nextByte();
        } while (opcMenu > 6);

        return opcMenu;
    }

    private static void Insert() {
        System.out.println("\nIngresar numeros enteros a la lista");

        char next, sw;
        int value;

        do {
            System.out.println("\nIngrese un numero: ");
            value = scan.nextInt();

            try {
                System.out.println("\nZ para ingresar a izquierda o D para ingresar a derecha: ");
                sw = scan.next().toUpperCase().charAt(0);

                if (sw == 'Z') {
                    if (objDoubleList.leftInsert(value)) {
                        System.out.println("Numero ingresado!..");
                    }
                } else {
                    if (objDoubleList.rightInsert(value)) {
                        System.out.println("Numero ingresado!..");
                    }
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
            objDoubleList.resetCurrentPointer();
            int result = objDoubleList.through();
            int countNodes = 0;
            boolean flag = true;

            while (result != 0) {
                countNodes++;
                System.out.println("El dato del nodo " + countNodes + " es: " + result);
                result = objDoubleList.through();
                flag = false;
            }

            if (result == 0 && flag) {
                System.out.println("\nLa lista esta vacia!...");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void recursiveThrough() {
        System.out.println("\nMostrando los datos de la lista de forma recursiva");

        try {
            objDoubleList.resetCurrentPointer();
            int result = objDoubleList.through();

            if (result == 0) {
                System.out.println("\nLa lista esta vacia!...");
            } else {
                int countNodes = 1;
                realThrough(result, countNodes);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void realThrough(int result, int countNodes) {
        if (result != 0) {
            System.out.println("El dato del nodo " + countNodes + " es: " + result);
            countNodes++;

            try {
                realThrough(objDoubleList.through(), countNodes);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void destroy() {
        System.out.println("\nDestruyendo los nodos de la lista");

        objDoubleList.resetCurrentPointer();

        try {
            String result = objDoubleList.destroy()
                    ? "La lista fue destruida!..."
                    : "La lista esta vacia!...";

            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeNodes() {
        System.out.println("\nEliminando Nodos de la lista");
        System.out.println("\nIngrese un valor por referencia: ");
        int reference = scan.nextInt();

        try {
            objDoubleList.resetCurrentPointer();
            if (objDoubleList.removeNodes(reference) == reference) {
                System.out.println("\nLos nodos que coinciden con el valor se eliminaron!");
            } else {
                System.out.println("\nNo se encontro el valor por referencia "
                        + "o la lista esta vacia!...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
