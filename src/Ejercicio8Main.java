import java.io.*;
import java.util.Scanner;

public class Ejercicio8Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        System.out.println("Introduce una cadena a procesar: ");
        cadena = sc.nextLine();

        //Se crea un proceso
        File directorio = new File("out\\production\\Ejercicio8");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio8Proceso1");
        pb.directory(directorio);

        //La entrada y salida del proceso será la misma que la del proceso actual
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        //Se ejecuta el proceso
        Process p = pb.start();

        cadena += "\n";

        //Se escribe y se mandan los datos al proceso hijo
        OutputStream os = p.getOutputStream();
        os.write(cadena.getBytes());
        os.flush();

        // COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("ERROR >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
