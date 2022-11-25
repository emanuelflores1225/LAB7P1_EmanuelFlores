package lab7p1_emanuelflores;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class LAB7P1_EmanuelFlores {
    public static Scanner leer = new Scanner(System.in);
    public static Random random = new Random();
    public static void main(String[] args) {
        int opcion;
        do{           
            opcion = tabla();                                   
            switch (opcion){
                case 1->{
                    String filas = JOptionPane.showInputDialog("Bienvenid@ a Portrait. \n Ingrese el numero de filas");
                    int tam = Integer.parseInt(filas);
                    String columnas = JOptionPane.showInputDialog("Ingrese el numero de columnas: ");
                    int tam2 = Integer.parseInt(columnas);
                    int [] numeros = lectura(tam); 
                    int [] numero2 = lectura2(tam2);
                    int [][] matriz = new int [tam][tam2];
                    matriz = grad(matriz);
                    JOptionPane.showMessageDialog(null,impresa(matriz));
                    if (tam != tam2){
                        rotate(matriz);
                        System.out.println();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Ambos son iguales; da error");
                    }
                    break;                  
                }
                
                case 2->{
                    String filas = JOptionPane.showInputDialog("Bienvenid@ a Numero Magico. \n Ingrese el numero de filas");
                    int tam = Integer.parseInt(filas);
                    String columnas = JOptionPane.showInputDialog("Ingrese el numero de columnas: ");
                    int tam2 = Integer.parseInt(columnas);
                    int [] numeros = lectura(tam); 
                    int [] numero2 = lectura2(tam2);
                    int af[][] = new int [tam][tam2];
                    af = grad(af);
                    System.out.println();
                    JOptionPane.showMessageDialog(null,imprimir(af) + "La suma de los bordes es: " 
                            + suma(af) 
                            + "\nLa multiplicacion de los de adentro es: " + mult(af));                    
                }
                
                case 3->{
                    JOptionPane.showMessageDialog(null,"Ich hatte keine Zeit fur das Option 3. Es ist mein Schulde");
                }
                
                case 4->{
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                }
            }
        }while(opcion !=4);
    }
    
    
    
    //basicos:   
        //para menu
    public static int tabla(){
        int opcion;
        
        String read = JOptionPane.showInputDialog("\n Titulo "
            + "\n 1. Portrait "
            + "\n 2. Numero Magico "
            + "\n 3. Subsecuencia "
            + "\n 4. Salir ");                    
        opcion = Integer.parseInt(read);
        return opcion;
    }    
        //imprime las matricez de las opciones 1 y 2
    public static String imprimir(int [][] numeros){
        String res="";
        for(int i = 0; i < numeros.length;i++){
            for(int j = 0; j < numeros[i].length;j++){
                res += "[" + numeros[i][j] + "]";
            }   
            res += "\n";
        }
        return res;
    }  
    public static String impresa(int [][] numeros){
        String res="";
        for(int i = 0; i < numeros.length;i++){
            for(int j = 0; j < numeros[i].length;j++){
                res += ("[" + numeros[i][j] + "]");
            }   
            //System.out.println();
            res += "\n";
        }
        return res;
    }
           
    //para ejercicio 1
        //lee el primer numero dado en la opcion 1
    public static int[] lectura (int tam){
        int [] temporal = new int[tam];
        Random random = new Random();
        for (int i = 0; i <temporal.length; i++){
            temporal[i] = 1 + random.nextInt(9);
        }
        
        return temporal; 
    }
        //lee el segundo numero dado en la opcion 1
    public static int[] lectura2 (int tam2){
        int [] temporal = new int[tam2];
        Random random = new Random();
        for (int i = 0; i <temporal.length; i++){
            temporal[i] = 1 + random.nextInt(9);
        }
        
        return temporal; 
    }
        //imprime la matrize rotada
    public static void print (int [][] array){
        Random random = new Random();
        for(int i = 0; i < array.length;i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print("[" + array[i][j] + "]");
            }
            System.out.println(); 
        }
    }  
        //rota la matriz
    public static void rotate (int [][]matrix){
        int [][] array = new int[matrix[0].length][matrix.length];
        int fil = matrix.length;
        for (int i = 0; i < fil; i++){
            for (int j = 0; j < matrix[0].length; j++){
                array[j][matrix.length-i-1] = matrix[i][j];
            }
        }
        
        System.out.println();
        JOptionPane.showMessageDialog(null,"La rotacion de 90 grados es: \n" + impresa(array));
        
    }
        //le da los valores random a la matriz
    public static int[][] grad (int[][] matrix){
        Random random = new Random();
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = random.nextInt(9);
            } 
        }
        return matrix;
    }
        
    //para ejercicio 2
        //agarra los numeros del borde y los suma
    public static int suma (int[][] arreglo){
        Random random = new Random();
        int temp = 0;
        for (int i = 0; i < arreglo.length;i++){
            for (int j = 0; j < arreglo[i].length;j++){
                if (i == 0 || i == arreglo.length-1 ||j==0|| j == arreglo[i].length-1){
                    temp += arreglo[i][j];
                }
                else{
                    
                    //temp[i][j] *= arreglo[i][j];
                }
            }
        }
        return temp;
    }   
        //agarra todos los valores de adentro y los multiplica
    public static int mult(int[][] arreglo){
        Random random = new Random();
        int temp = 1;
        for (int i = 0; i < arreglo.length;i++){
            for (int j = 0; j < arreglo[i].length;j++){
                if (i == 0 || i == arreglo.length-1 ||j==0|| j == arreglo[i].length-1){
                    //temp += arreglo[i][j];
                }
                else{
                    
                    temp *= arreglo[i][j];
                }
            }
        }
        return temp;
    }
    //para ejercicio 3
}
