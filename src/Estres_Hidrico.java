
import java.util.Scanner;
public class Estres_Hidrico {
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        Scanner repetición =new Scanner(System.in);
        int elección, indice, contador;
        String nomestados[]={"Tlaxcala","Ciudad de México", "Estado de México", "Aguascalientes", "Queretaro",
            "Guanajuato", "Durango", "Zacatecas", "Jalisco", "Morelos", "Hidalgo", "Puebla",
            "San Luis Potosi", "Michoacan", "Veracruz", "Yucatan", "Campeche", "Quintana Roo", "Sonora", "Coahuila","Tamaulipas", 
            "Nuevo León", "Guerrero", "Oaxaca", "Chihuahua", "Chiapas", "Nayarit", "Baja California Sur",
            "Tabasco", "Colima", "Sinaloa", "Baja California"}, repetir="si";
        
        double estres_hidrico[]={2.85, 5.00, 4.57, 4.77, 4.40,
        4.63, 4.74, 4.47, 4.47, 4.08, 3.63, 2.26,
        3.08, 4.25, 0.49, 1.06, 0.96, 0.86, 4.93, 4.84, 3.83,
        3.39, 1.05, 0.57, 4.79, 0.40, 3.63, 5.00, 
        0.31, 4.78, 4.80, 4.67}, aux;
        
        System.out.println("Este programa te dara el estres hidrico basal "
                + "de los estados de la republica mexicana, la clasificación es la siguiente:");
        System.out.println("1. Riesgo bajo");
        System.out.println("2. Riesgo Medio bajo");
        System.out.println("3. Riesgo Medio alto");
        System.out.println("4. Riesgo Alto");
        System.out.println("5. Riesgo extremadamente alto");
        
        while(repetir.equalsIgnoreCase("si")){
        System.out.print("Selecciona la opción que quieres analizar:");
        elección=entrada.nextInt();
            switch(elección){
            case 1 -> {contador=0;
                for (int i = 0; i < estres_hidrico.length; i++) {
                    if(estres_hidrico[i]< 1){
                        indice=i;
                        contador++;
                        for (int k = 0; k <(estres_hidrico.length-1); k++) {
                            for (int j = 0; j < (estres_hidrico.length-1); j++) {
                                if(estres_hidrico[j]>estres_hidrico[j+1]){
                                    aux=estres_hidrico[j];
                                    estres_hidrico[j]=estres_hidrico[j+1];
                                    estres_hidrico[j+1]=aux;
                                }
                            }
                        }
                        System.out.println(""+nomestados[indice]+"="+estres_hidrico[i]);
                    }     
                }
                        System.out.println("En México hay "+contador+" estados de la republica en Riesgo bajo de estrés hidrico basal");
                }
            case 2 -> {contador=0;
                for (int i = 0; i < estres_hidrico.length; i++) {
                    if(estres_hidrico[i]>1 && estres_hidrico[i]<2){
                        indice=i;
                        contador++;
                        for (int k = 0; k <(estres_hidrico.length-1); k++) {
                            for (int j = 0; j < (estres_hidrico.length-1); j++) {
                                if(estres_hidrico[j]>estres_hidrico[j+1]){
                                    aux=estres_hidrico[j];
                                    estres_hidrico[j]=estres_hidrico[j+1];
                                    estres_hidrico[j+1]=aux;
                                }
                            }
                        }
                        System.out.println(""+nomestados[indice]+"="+estres_hidrico[i]);
                    }
                    
                }
                        System.out.println("En México hay "+contador+" estados de la republica en Riesgo Medio bajo de estrés hidrico basal");
                }
            case 3 -> {contador=0;
                for (int i = 0; i < estres_hidrico.length; i++) {
                    if(estres_hidrico[i]>=2 && estres_hidrico[i]<=3){
                        indice=i;
                        contador++;
                        for (int k = 0; k <(estres_hidrico.length-1); k++) {
                            for (int j = 0; j < (estres_hidrico.length-1); j++) {
                                if(estres_hidrico[j]>estres_hidrico[j+1]){
                                    aux=estres_hidrico[j];
                                    estres_hidrico[j]=estres_hidrico[j+1];
                                    estres_hidrico[j+1]=aux;
                                }
                            }
                        }
                        System.out.println(""+nomestados[indice]+"="+estres_hidrico[i]);
                    }  
                }
                        System.out.println("En México hay "+contador+" estados de la republica en Riesgo Medio alto de estrés hidrico basal");
                }
            case 4 -> {contador=0;
                for (int i = 0; i < estres_hidrico.length; i++) {
                    if(estres_hidrico[i]>=3 && estres_hidrico[i]<=4){
                        indice=i;
                        contador++;
                        for (int k = 0; k <(estres_hidrico.length-1); k++) {
                            for (int j = 0; j < (estres_hidrico.length-1); j++) {
                                if(estres_hidrico[j]>estres_hidrico[j+1]){
                                    aux=estres_hidrico[j];
                                    estres_hidrico[j]=estres_hidrico[j+1];
                                    estres_hidrico[j+1]=aux;
                                }
                            }
                        }
                        System.out.println(""+nomestados[indice]+"="+estres_hidrico[i]);
                    }    
                }
                        System.out.println("En México hay "+contador+" estados de la republica en Riesgo alto de estrés hidrico basal");
                }
            case 5 -> {contador=0;
                for (int i = 0; i < estres_hidrico.length; i++) {
                    if(estres_hidrico[i]>=4 && estres_hidrico[i]<=5){
                        indice=i;
                        contador++;
                        for (int k = 0; k <(estres_hidrico.length-1); k++) {
                            for (int j = 0; j < (estres_hidrico.length-1); j++) {
                                if(estres_hidrico[j]>estres_hidrico[j+1]){
                                    aux=estres_hidrico[j];
                                    estres_hidrico[j]=estres_hidrico[j+1];
                                    estres_hidrico[j+1]=aux;
                                }
                            }
                        }
                        System.out.println(""+nomestados[indice]+"="+estres_hidrico[i]);
                    }
                    
                }
                        System.out.println("En México hay "+contador+" estados de la republica en Extremadamente alto de estrés hidrico basal");
                }
            default -> System.out.println("Este dato no existe, vuelva a intentar");
        }
            System.out.println("Quieres realizar otra consulta si/no");
            repetir=repetición.nextLine();
        } 
    }
}

