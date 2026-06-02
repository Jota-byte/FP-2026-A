
import java.util.Scanner;

public class taller2 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String cedula, nombre;
        boolean esValido = false;
        int destino, asientos, asientosDisponibles = 100, tipoBoleto, maletasPermitidas = 0, pesoPermitido = 0, maletasDeseadas;
        int horasDeAnticipoVuelo = 2;
        String nombreBoleto;

        System.out.print("Bienvenido, ingrese su nombre: ");
        nombre = lector.nextLine();
        System.out.print("Ingrese su cédula: ");
        cedula = lector.nextLine();

        System.out.println("Escoja el destino (#):");
        System.out.println("1. Guayaquil");
        System.out.println("2. Quito");
        System.out.println("3. Cuenca");
        System.out.print("# de destino: ");
        destino = lector.nextInt();

        do {
            System.out.print("Ingrese la cantidad de asientos: ");
            asientos = lector.nextInt();
            if (asientos <= asientosDisponibles) {
                asientosDisponibles = asientosDisponibles - asientos;
                esValido = true;
            } else {
                System.out.println("Ingrese una cantidad de asientos válida.");
            }
        } while (!esValido);

        System.out.println("Escoja tipo de boleto:");
        System.out.println("1. Económico");
        System.out.println("2. Ejecutivo");
        System.out.println("3. Premium");
        tipoBoleto = lector.nextInt();

        maletasPermitidas = obtenerMaletasPermitidas(tipoBoleto);
        pesoPermitido = obtenerPesoPermitido(tipoBoleto);
        nombreBoleto = obtenerNombreBoleto(tipoBoleto);

        System.out.println("Tiene permitido llevar el siguiente número de maletas: " + maletasPermitidas);
        System.out.println("Con un máximo de " + pesoPermitido + " kg por maleta.");

        do {
            esValido = true;
            System.out.print("Ingrese cuántas maletas desea llevar: ");
            maletasDeseadas = lector.nextInt();
            if (maletasDeseadas > maletasPermitidas) {
                esValido = false;
                System.out.println("Ingrese un número de maletas dentro de lo permitido.");
            }
        } while (!esValido);

        int[] maletasPasajero = new int[maletasDeseadas];

        if (maletasDeseadas > 0) {
            for (int i = 1; i <= maletasDeseadas; i++) {
                do {
                    esValido = true;
                    System.out.print("Peso de maleta #" + i + ": ");
                    maletasPasajero[i - 1] = lector.nextInt();
                    if (maletasPasajero[i - 1] > pesoPermitido) {
                        esValido = false;
                        System.out.println("Ingrese un peso dentro de lo permitido.");
                    }
                } while (!esValido);
            }
        }

        System.out.println("Reserva completada con los siguientes datos:");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Destino: " + obtenerDestino(destino));
        System.out.println("Asientos: " + asientos);
        System.out.println("Tipo de boleto: " + nombreBoleto);
        System.out.println("Maletas: " + maletasDeseadas);
        for (int i = 1; i <= maletasDeseadas; i++) {
            System.out.println("Peso de maleta #" + i + ": " + maletasPasajero[i - 1] + " kg");
        }
        System.out.println("Recuerde embarcar " + horasDeAnticipoVuelo + " horas antes.");
    }

    private static String obtenerDestino(int destino) {
        switch (destino) {
            case 1:
                return "Guayaquil";
            case 2:
                return "Quito";
            case 3:
                return "Cuenca";
            default:
                return "Desconocido";
        }
    }

    private static int obtenerMaletasPermitidas(int tipoBoleto) {
        switch (tipoBoleto) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }

    private static int obtenerPesoPermitido(int tipoBoleto) {
        switch (tipoBoleto) {
            case 1:
                return 10;
            case 2:
                return 20;
            case 3:
                return 30;
            default:
                return 0;
        }
    }

    private static String obtenerNombreBoleto(int tipoBoleto) {
        switch (tipoBoleto) {
            case 1:
                return "Económico";
            case 2:
                return "Ejecutivo";
            case 3:
                return "Premium";
            default:
                return "Desconocido";
        }
    }
}
