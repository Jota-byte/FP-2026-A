
import java.util.Scanner;

public class taller3_1 {

    public static void main(String[] args) {

        // Lista de ingredientes
        String[] ingredientes = {
            "Pollo",
            "Carne de res",
            "Carne de cerdo",
            "Arroz cocido",
            "Huevo",
            "Papa cocida",
            "Pan",
            "Harina de trigo",
            "Azucar",
            "Leche entera",
            "Queso",
            "Aceite vegetal",
            "Manzana",
            "Banano",
            "Fresas",
            "Tomate",
            "Cebolla",
            "Pimiento",
            "Lechuga",
            "Pepino",
            "Lentejas cocidas",
            "Frijoles cocidos",
            "Avena"
        };

        // Aporte de los ingredientes a los grupos respectivos
        double[][] nutrientes = {
            // Calorias, Proteinas, Grasas, Carbohidratos
            {165, 31.0, 3.6, 0.0}, // Pollo
            {250, 26.0, 15.0, 0.0}, // Carne de res
            {242, 27.0, 14.0, 0.0}, // Carne de cerdo
            {130, 2.7, 0.3, 28.0}, // Arroz cocido
            {155, 13.0, 11.0, 1.1}, // Huevo
            {87, 1.9, 0.1, 20.0}, // Papa cocida
            {265, 9.0, 3.2, 49.0}, // Pan
            {364, 10.0, 1.0, 76.0}, // Harina de trigo
            {387, 0.0, 0.0, 100.0}, // Azucar
            {61, 3.2, 3.3, 4.8}, // Leche entera
            {402, 25.0, 33.0, 1.3}, // Queso
            {884, 0.0, 100.0, 0.0}, // Aceite vegetal
            {52, 0.3, 0.2, 14.0}, // Manzana
            {89, 1.1, 0.3, 23.0}, // Banano
            {32, 0.7, 0.3, 7.7}, // Fresas
            {18, 0.9, 0.2, 3.9}, // Tomate
            {40, 1.1, 0.1, 9.3}, // Cebolla
            {31, 1.0, 0.3, 6.0}, // Pimiento
            {15, 1.4, 0.2, 2.9}, // Lechuga
            {15, 0.7, 0.1, 3.6}, // Pepino
            {116, 9.0, 0.4, 20.0}, // Lentejas cocidas
            {127, 8.7, 0.5, 23.0}, // Frijoles cocidos
            {389, 16.9, 6.9, 66.3} // Avena
        };

        Scanner sc = new Scanner(System.in);
        boolean continuar = false;
        int ingrediente;
        int gramos = 0;

        double calorias = 0, proteinas = 0, grasas = 0, carbohidratos = 0;

        System.out.println("Bienvenido, a continuación podrá escoger los ingredientes de la comida. Escoja el ingrediente y después la cantidad en gramos.");

        do {
            String respuesta;

            // Ciclo para validar que se escoja S o N
            do {
                System.out.println("¿Deseas ingresar un ingrediente? Ingrese S para Sí y N para No.");
                System.out.print("Esperando entrada...");
                respuesta = sc.next().toUpperCase();
            } while (!respuesta.equals("S") && !respuesta.equals("N"));

            // Condicional para determinar si hay que salir del do-while de este nivel, 
            // es decir, finalizar el ingreso de ingredientes.
            if (respuesta.equals("N")) {
                continuar = true;
            } else {
                System.out.println("Escoja uno de los ingredientes:");
                mostrarIngredientes(ingredientes);
                // Ciclo para validar el ingreso de un ingrediente válido
                do {
                    ingrediente = sc.nextInt() - 1;
                    if (!estaEnRango(ingrediente, ingredientes)) {
                        System.out.print("Ingresa un ingrediente correcto: ");
                    }
                } while (!estaEnRango(ingrediente, ingredientes));
                // Ciclo para validar el ingreso de una cantidad de gramos válida
                do {
                    System.out.println("Ingresa los gramos: ");
                    gramos = sc.nextInt();
                    if (gramos < 0) {
                        System.out.println("Ingresa una cantidad válida.");
                    }
                } while (gramos < 0);

                // Bloque para calcular el aporte calórico y de nutrientes del ingrediente del 
                // ciclo actual y sumarlo al total.
                // 0, calorías
                // 1, proteínas
                // 2, grasas
                // 3, carbohidratos
                calorias += nutrientes[ingrediente][0] * gramos / 100;
                proteinas += nutrientes[ingrediente][1] * gramos / 100;
                grasas += nutrientes[ingrediente][2] * gramos / 100;
                carbohidratos += nutrientes[ingrediente][3] * gramos / 100;
            }

        } while (!continuar);

        sc.close();

        System.out.println("Resumen de la comida:");
        System.out.println("Calorías: " + calorias);
        System.out.println("Proteínas: " + proteinas + " g");
        System.out.println("Grasas: " + grasas + " g");
        System.out.println("Carbohidratos: " + carbohidratos + " g");

        boolean esAceptable = true;

        // Bloque para verificar el cumplimiento de criterios para determinar si es una comida aceptable.
        if (calorias >= 400 && calorias <= 800) {
            System.out.println("La comida aporta suficientes calorías (entre 400 y 800).");
        } else {
            System.out.println("La comida se sale del rango de calorías aceptables para una comida principal.");
            esAceptable = false;
        }

        if (proteinas > 15) {
            System.out.println("La comida aporta suficientes proteínas (15 g o más).");
        } else {
            System.out.println("La comida no aporta suficientes proteínas (menos de 15 g).");
            esAceptable = false;
        }

        if (grasas >= 5 && grasas <= 30) {
            System.out.println("La comida aporta suficientes grasas (entre 5 y 30 g).");

        } else {
            System.out.println("La comida no aporta suficientes grasas (entre 5 y 30 g).");
            esAceptable = false;
        }

        if (carbohidratos >= 30) {
            System.out.println("La comida aporta suficientes carbohidratos (30 g o más).");

        } else {
            System.out.println("La comida no aporta suficientes carbohidratos (30 g o más).");
            esAceptable = false;
        }

        if (esAceptable) {
            System.out.println("La comida es aceptable, cumple con todos los criterios anteriores.");
        } else {
            System.out.println("La comida no es aceptable, uno o más criterios no se cumplieron.");
        }
    }

    static boolean estaEnRango(int numero, String[] objeto) {
        return numero >= 0 && numero < objeto.length;
    }

    static void mostrarIngredientes(String[] ingredientes) {
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.printf("%d. %s%n", i + 1, ingredientes[i]);

        }
    }
}
