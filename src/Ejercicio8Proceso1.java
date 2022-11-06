import java.util.Scanner;

public class Ejercicio8Proceso1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        System.out.println("Introduce una cadena: ");
        cadena = sc.nextLine();
        System.out.println("La cadena introducida es " + cadena);

        if(cadena.length() == 0) {
            System.out.println("La cadena esta vacia");
            System.exit(1);
        }

        //Se guardan los datos sin espacios
        String cadena2 = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ')
                cadena2 += cadena.charAt(i);
        }

        cadena = cadena2;
        int inc = 0;
        int des = cadena.length() - 1;
        boolean bError = false;


        while ((inc<des) && (!bError)){
            if (cadena.charAt(inc)==cadena.charAt(des)){
                inc++;
                des--;
            } else
                bError = true;
        }

        if (!bError)
            System.out.println(cadena + " =>  es un PALINDROMO");
        else
            System.out.println(cadena + " => NO es un palindromo");
        System.exit(0);
        sc.close();
    }
}

