import java.io.*;
import java.util.Scanner;

public class Ejercicio8Main2 {
    public static void main(String[] args) throws IOException {

        File directorio = new File("out\\production\\Ejercicio8");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio8Proceso1");
        pb.directory(directorio);

        //La cadena esta en un fichero
        File fichero = new File("src\\docs\\FicheroConLaCadena.txt");
        pb.redirectInput(ProcessBuilder.Redirect.from(fichero));

        // Salida a consola
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        // salida de error a fichero
        File fErr = new File("src\\docs\\Fichero para los errores.txt");
        pb.redirectError(fErr);

        // se ejecuta el proceso
        Process p = pb.start();

        // COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}