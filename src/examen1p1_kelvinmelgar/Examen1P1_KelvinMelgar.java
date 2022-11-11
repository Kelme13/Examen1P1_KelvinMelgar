/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_kelvinmelgar;
import java.util.Scanner;
import java.security.SecureRandom;

/**
 *
 * @author kelvi
 */
public class Examen1P1_KelvinMelgar {

    static SecureRandom random = new SecureRandom();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        do{
            
            System.out.println("\n<-------- Menu -------->");
            System.out.println("1. Divisores Primos.");
            System.out.println("2. Contorno de Piramide");
            System.out.println("3. Vecinos.");
            System.out.println("4. Salir.");
            
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                
                case 1:{
                    System.out.println("\n-> Divisores Primos...");
                    System.out.print("Ingrese un numero: ");
                    int n_usuario = sc.nextInt();
                    
                    if(n_usuario >= 1){
                        
                        String div_prim = primos(n_usuario);
                        
                        if(div_prim.isEmpty()){
                            System.out.printf("%n%d no tiene divisores primos.%n", n_usuario);
                        }else{
                            System.out.printf("%nLos numeros primos que dividen a %d son: %s%n", n_usuario, div_prim);
                        }
                        
                    }else
                        System.out.println("Numero invalido....\n");
                    
                    break;
                }//fin del primer ejercicio
                
                case 2:{
                    System.out.println("\n-> Contorno de Piramide...");
                    System.out.print("Ingrese el tamanio: ");
                    int tamanio = sc.nextInt();
                    
                    if(tamanio % 2 != 0){
                        System.out.println();
                        contorno(tamanio);
                    
                        System.out.println();
                        
                    }else{
                        System.out.println("\nDebe ingresar un numero entero impar...");
                    }
                    
                    
                    break;
                }
                
                case 3:{
                    System.out.println("\n-> Vecinos...");
                    System.out.print("Ingrese la cadena: ");
                    sc.nextLine();
                    String cadena_usuario = sc.nextLine();
                    
                    //Revisa si solo tiene letras o espacios
                    boolean paso = true;
                    
                    for (int i = 0; i < cadena_usuario.length(); i++) {
                        int c = (int)cadena_usuario.charAt(i);
                        
                        if((c < 65 || c > 90) && (c < 97 || c > 122)){
                            if(c != 32){
                                paso = false;
                                break;
                            }
                            
                        }
                    }
                    
                    if(paso){
                        System.out.println("\nResultado: " + vecinos(cadena_usuario));
                    }else{
                        System.out.println("\nLa cadena es invalida...");
                    }
                    
                    break;
                }
                
                case 4:{
                    
                    System.out.println("Saliendo....");
                    break;
                }
                
                default:{
                    System.out.println("Opcion invalida....");
                }
            }//fin del switch
            
        }while(opcion != 4);
        
        
    }
    
    public static String primos(int numero){
        String divisores_primos = "";
        if(numero > 1)
            divisores_primos = "1";
        
        //Mira cada numero
        for (int i = 1; i < numero; i++) {
            
            //Verificacion si i es primo
            int acum_divi = 0;
            for (int j = 1; j <= i; j++) {
                
                if(i%j == 0){
                    acum_divi++;
                }
            }
            if(acum_divi == 2){
                
                //Verifica si i es divisor de n
                if(numero % i == 0){
                    divisores_primos += ", " + i;
                }
            }
            
        }//fin del for
     
        return divisores_primos;
    }//fin del metodo primos
    
    public static String vecinos(String cadena){
        
        //Genera el numero random
        int numero_aleat = random.nextInt(2);
        System.out.println("Numero generado: " + numero_aleat);
        
        
        String nueva_cadena = "";
        for (int i = 0; i < cadena.length(); i++) {
            char caract = cadena.charAt(i);
            
            //Aumenta o disminuye el valor del char 
            if (numero_aleat == 0) {
                int nuevo_caract = (int) caract - 1;
                
                //Lo agrega
                nueva_cadena += (char) nuevo_caract;

            } else {
                int nuevo_caract = (int) caract + 1;
                
                //Lo agrega
                nueva_cadena += (char) nuevo_caract;
            }

        }//fin del for

        return nueva_cadena;
    }//fin del metodo vecinos
    
    public static void contorno(int numero){
        int asteriscos = numero / 2;
        int espacios = 1;
        
        
        for (int i = 1; i <= numero - (numero / 2); i++) {
            
            //Dificil de explicar....
            for (int j = 1; j <= asteriscos; j++) {
                System.out.print("*");
            }
            
            if(i < (numero - (numero / 2)) - 1){
                System.out.print("+");
            }else if (i == (numero - (numero / 2)) - 1){
                for (int j = 1; j < numero-1; j++) {
                    System.out.print("+");
                }
            }
            
            if(i > 1 && (i < (numero - (numero / 2)) - 1)){
                for (int j = 1; j <= espacios; j++) {
                    System.out.print(" ");
                }
                espacios += 2;
            }
            
            if( i >= 2 && (i < (numero - (numero / 2)) - 1)){
                System.out.print("+");
            }
            
            
            for (int j = 1; j <= asteriscos; j++) {
                System.out.print("*");
            }
            
            if (i == (numero - (numero / 2))){
                for (int j = 1; j <= numero; j++) {
                    System.out.print("*");
                }
            }
            
            
            
            asteriscos--;
            System.out.println();
        }
    }
}//fin del main
