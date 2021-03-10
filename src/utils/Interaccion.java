package utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class Interaccion {

    static Scanner l = new Scanner(System.in);

    //Consola
    public static void cargandoBarra(int longitudBarra,int tiempoMilisegundos){

        for (int i = 0; i < longitudBarra; i++) {
            if (i == 0) System.out.print("|");
            else if (i == longitudBarra - 1) System.out.print("| "+Colores.ANSI_GREEN+"DONE!"+Colores.ANSI_RESET);
            else System.out.print("=");
            try{
                TimeUnit.MILLISECONDS.sleep(tiempoMilisegundos);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println();

    }

    public static void limpiaPantallash(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void pulsarTeclaContinuar(){
        System.out.print("Pulse una tecla para continuar: ");
        l.nextLine();
    }
}
