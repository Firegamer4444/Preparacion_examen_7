import java.util.ArrayList;
import java.util.Scanner;


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
                    System.out.println("8. Retirar dinero");
                    System.out.println("9. Consultar el saldo actual.");
                    System.out.println("10. Cerrar programa");
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
                        int dinero = scanner.nextInt();
                        if (dinero >= 0){
                            cuentaActual.depositarDinero(dinero);
                        }
                        else{
                            System.out.println("No se puede depositar dinero negativo");
                            break;
                        }
                    }
                    if (opcion.equals("8")){
                        System.out.println("Introduzca la cantidad de dinero que desea retirar: ");
                        int dinero = scanner.nextInt();
                        if (dinero >= 0){
                            if (dinero <= cuentaActual.getSaldoActual()){
                                cuentaActual.retirarDinero(dinero);
                            }
                            else{
                                System.out.println("Has introducido mas dinero del que tienes en la cuenta");
                                break;
                            }
                        }
                        else{
                            System.out.println("No se puede retirar dinero negativo");
                            break;
                        }
                    }
                    if (opcion.equals("9")){
                        System.out.println("Saldo actual: " + cuentaActual.getSaldoActual());
                    }
                    if (opcion.equals("10")){
                        return;
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
        CuentaBancaria cuenta_1 = new CuentaBancaria("1234 1234 12 1234567891" , "12345678A" , "Juan" , 0);
        cuentas.add(cuenta_1);
        CuentaBancaria cuenta_2 = new CuentaBancaria("2345 2345 23 2345678901", "23456789B", "Maria", 1000);
        cuentas.add(cuenta_2);
        CuentaBancaria cuenta_3 = new CuentaBancaria("3456 3456 34 3456789012", "34567890C", "Pedro", 500);
        cuentas.add(cuenta_3);
        CuentaBancaria cuenta_4 = new CuentaBancaria("4567 4567 45 4567890123", "45678901D", "Ana", 1500);
        cuentas.add(cuenta_4);
        CuentaBancaria cuenta_5 = new CuentaBancaria("5678 5678 56 5678901234", "56789012E", "Luis", 2000);
        cuentas.add(cuenta_5);
        menu(scanner, cuentas);
        scanner.close();
    }
}
