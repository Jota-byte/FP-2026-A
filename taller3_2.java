
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class taller3_2 {

    public static void main(String[] args) {

        // Lista de películas.
        // Cada item de la lista es un array de objetos que contendrá los datos de la respectiva película.
        // Estructura del array de una película: 
        // 0, titulo
        // 1, lanzamiento
        // 2, género
        ArrayList<Object[]> peliculas = new ArrayList<Object[]>();

        String titulo;
        int lanzamiento;
        String genero;

        boolean salir = false, continuar;
        Scanner sc = new Scanner(System.in);
        String respuesta;
        int posicion;

        System.out.println("Bienvenido, ingresa las películas que desees.");
        do {
            System.out.println("¿Deseas ingresar una película? Ingrese S para Sí y N para No.");
            do {
                System.out.print("Esperando entrada...");
                respuesta = sc.nextLine().toUpperCase();
                continuar = !respuesta.equals("S") && !respuesta.equals("N");
            } while (continuar);

            // Si escoge que sí, se procede a solictar datos, caso contrario, 
            // se termina el do-while de este nivel.
            if (respuesta.equals("N")) {
                salir = true;
            } else {
                // Bloque para solicitar los datos
                System.out.print("Ingresa el nombre de la película: ");
                titulo = sc.nextLine();
                System.out.print("Ingresa el año de lanzamiento: ");
                do {
                    lanzamiento = Integer.parseInt(sc.nextLine());
                    if (!esPeliculaValida(lanzamiento)) {
                        System.out.print("Ingresa un año válido: ");
                    }
                } while (!esPeliculaValida(lanzamiento));
                System.out.print("Ingresa el género: ");
                genero = sc.nextLine();

                // Ingreso de la película a la lista y se aprovecha para ordenar.
                // Si la lista está vacía, simplemente se inserta; se salta el while.
                // Si la lista no está vacía, se avanza mientras las películas de la lista 
                // sean del mismo año o anteriores. Cuando se encuentra una película
                // más reciente, se inserta antes de ella.
                Object[] pelicula = {titulo, lanzamiento, genero};
                posicion = 0;
                while (posicion < peliculas.size() && (int) peliculas.get(posicion)[1] <= lanzamiento) {
                    posicion++;
                }
                peliculas.add(posicion, pelicula);
            }
        } while (!salir);
        sc.close();
        System.out.println("Lista de películas:");
        mostrarLista(peliculas);
    }

    static boolean esPeliculaValida(int anio) {
        // Según registros, la primera película como tal se lanzó en 1888, por eso es el límite inferior del rango.
        // El límite superior es el año actual.
        return anio >= 1888 && anio <= LocalDate.now().getYear();
    }

    static void mostrarLista(ArrayList<Object[]> lista) {
        for (int i = 0; i < lista.size(); i++) {
            Object[] elem = lista.get(i);
            System.out.println(i + 1 + ". " + elem[0] + ", " + elem[1] + ", " + elem[2] + ".");
        }
    }
}
