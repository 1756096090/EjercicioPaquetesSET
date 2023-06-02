public class Paquete {
    private int numeroTrack;
    private float peso;
    private String ciudad;
    private String direccion;
    private String nombreReceptor;
    private String estado;

    public Paquete() {
    }

    public Paquete(int numeroTrack, float peso, String ciudad, String direccion, String nombreReceptor, String estado) {
        this.numeroTrack = numeroTrack;
        this.peso = peso;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombreReceptor = nombreReceptor;
        this.estado = estado;
    }

    public int getNumeroTrack() {
        return numeroTrack;
    }

    public void setNumeroTrack(int numeroTrack) {
        this.numeroTrack = numeroTrack;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "numeroTrack=" + numeroTrack +
                ", peso=" + peso +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombreReceptor='" + nombreReceptor + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.numeroTrack;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.hashCode()==obj.hashCode())
        return true;

        if(this!=((Paquete)obj))
            return false;
        if(this.numeroTrack!=((Paquete)obj).getNumeroTrack())
            return false;
        return true;
    }
}
