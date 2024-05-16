public class CuentaBancaria {
    private String ccc;
    private String dni;
    private String nombreTitular;
    private String saldoActual; 

    public CuentaBancaria(){
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

    public String getSaldoActual() {
        return saldoActual;
    }

    public String getCcc() {
        return ccc;
    }

}
