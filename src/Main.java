import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class Main {


    /**
     * Metodo para iniciar sesion
     * @param scanner scanner que se usa en todo el programa
     * @param cuentas array list de las cuentas instanciadas
     * @return la cuenta en la que se inicia sesion
     */
    public static CuentaBancaria iniciarsesion(Scanner scanner ,ArrayList<CuentaBancaria> cuentas ){
        System.out.println("Introduzca el nombre de titular (limite de 15 caracteres): ");
        String nombreTitular = scanner.nextLine();
        System.out.println("Introduzca el DNI de titular: ");
        String dni = scanner.nextLine();
        System.out.println("Introduzca el ccc: ");
        String ccc = scanner.nextLine();
        CuentaBancaria cuentaActual = busqueda(ccc, cuentas);
        if (validarCCC(ccc) == false){
            System.out.println("Has introducido un ccc no valido\nVuelva a introducir los datos.");
            iniciarsesion(scanner, cuentas);
        }
        if (cuentaActual == null){
            System.out.println("Has introducido un ccc que no existe\nVuelva a introducir los datos.");
            iniciarsesion(scanner, cuentas);
        }
        if (!cuentaActual.getNombreTitular().equals(nombreTitular) | nombreTitular.length() > 15){
            System.out.println("Has introducido mal el nombre\nVuelva a introducir los datos.");
            iniciarsesion(scanner, cuentas);
        }
        if (!cuentaActual.getDni().equals(dni)){
            System.out.println("Has introducido mal el dni\nVuelva a introducir los datos.");
            iniciarsesion(scanner, cuentas);
        }
        return cuentaActual;
    }

    /**
     * El menu del programa
     * @param scanner scanner que se usa en todo el programa
     * @param cuentas array list de las cuentas instanciadas
     */
    public static void menu(Scanner scanner , ArrayList<CuentaBancaria> cuentas){
        while (true) {
            System.out.println("\n--- Opciones: ---");
            System.out.println("1. iniciar sesion");
            System.out.println("2. cerrar programa");
            System.out.println("Elija una opcion");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")){
                CuentaBancaria cuentaActual = iniciarsesion(scanner, cuentas);
                while (true) {
                    System.out.println("\n--- Opciones: ---");
                    System.out.println("1. Mostrar el ccc de la cuenta");
                    System.out.println("2. Mostrar el nombre del titular");
                    System.out.println("3. Mostrar el código de la entidad bancaria");
                    System.out.println("4. Mostrar el código de la sucursal");
                    System.out.println("5. Mostrar el numero de la cuenta");
                    System.out.println("6. Mostrar los dígitos de control de la cuenta");
                    System.out.println("7. Depositar dinero");
                    System.out.println("Elija una opcion");
                    opcion = scanner.nextLine();
                    if (opcion.equals("1")){
                        System.out.println("ccc de la cuenta: " + cuentaActual.getCcc());
                    }
                    if (opcion.equals("2")){
                        System.out.println("nombre del titular: " + cuentaActual.getNombreTitular());
                    }
                    if (opcion.equals("3")){
                        System.out.println("codigo de la entidad bancaria: " + cuentaActual.getEntidad());
                    }
                    if (opcion.equals("4")){
                        System.out.println("codigo de la sucursal: " + cuentaActual.getSucursal());
                    }
                    if (opcion.equals("5")){
                        System.out.println("numero de la cuenta: " + cuentaActual.getNumeroCuenta());
                    }
                    if (opcion.equals("6")){
                        System.out.println("digitos de control: " + cuentaActual.getDigitosControl());
                    }
                    if (opcion.equals("7")){
                        System.out.println("Introduzca la cantidad de dinero que desea depositar: ");
                        int dineroDepositar = scanner.nextInt();
                    }
                }
            }
            if (opcion.equals("2")){
                return;
            }
        }
    }

    /**
     * Metodo que busca en el array de cuentas la cuenta que tenga el ccc introducido por parametro
     * @param ccc ccc de la cuenta que se quiere buscar
     * @param cuentas array list de las cuentas instanciadas
     * @return
     */
    public static CuentaBancaria busqueda(String ccc , ArrayList<CuentaBancaria> cuentas){
        for (int i = 0 ; i < cuentas.size() ; i++){
            if (cuentas.get(i).getCcc().equals(ccc)){
                return cuentas.get(i);
            }
        }
        return null;
    }

    /**
     * Metodo que valida el formato del ccc pasado por parametro
     * @param ccc
     * @return
     */
    public static boolean validarCCC(String ccc){
        String rex = "^\\d{4}\\s\\d{4}\\s\\d{2}\\s\\d{10}$";
        return ccc.matches(rex);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        scanner.close();
    }
}
