public class CuentaBancaria {
    private String ccc;
    private String dni;
    private String nombreTitular;
    private int saldoActual; 

    

    public CuentaBancaria(String ccc, String dni, String nombreTitular, int saldoActual) {
        this.ccc = ccc;
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldoActual = saldoActual;
    }

    public void depositarDinero(int dinero){
        this.saldoActual += dinero;
    }

    public void retirarDinero(int dinero){
        this.saldoActual -= dinero;
    }

    public String getEntidad(){
        String[] cccSplit = this.ccc.split(" ");
        return cccSplit[0];
    }

    public String getSucursal(){
        String[] cccSplit = this.ccc.split(" ");
        return cccSplit[1];
    }

    public String getDigitosControl(){
        String[] cccSplit = this.ccc.split(" ");
        return cccSplit[2];
    }

    public String getNumeroCuenta(){
        String[] cccSplit = this.ccc.split(" ");
        return cccSplit[3];
    }

    public String getDni() {
        return dni;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public String getCcc() {
        return ccc;
    }

}
