import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void iniciarSecion(){

    }

    public static void menu(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- Opciones: ---");
			
        }
    }

    public static CuentaBancaria busqueda(String ccc , ArrayList<CuentaBancaria> cuentas){
        for (int i = 0 ; i < cuentas.size() ; i++){
            if (cuentas.get(i).getCcc().equals(ccc)){
                return cuentas.get(i);
            }
        }
        return null;
    }

    public static void validarCCC(String ccc){

    }

    public static void main(String[] args) throws Exception {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
    }
}
