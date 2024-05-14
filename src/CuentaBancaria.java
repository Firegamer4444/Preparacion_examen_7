public class CuentaBancaria {
    private String ccc;
    private String dni;
    private String nombreTitular;
    private String saldoActual; 

    public CuentaBancaria(){
    }

    public String getNumeroCuenta(){
        String numeroCuenta = this.ccc.substring(9 , 19);
        return numeroCuenta;
    }

    public String getEntidad(){
        String entidad = this.ccc.substring(0 , 4);
        return entidad;
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
