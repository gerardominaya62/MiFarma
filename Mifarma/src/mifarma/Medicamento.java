/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mifarma;

public abstract class Medicamento {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String estado;

    private Medicamento medicamentoRelacionado;

    public Medicamento(String codigo,
                       String nombre,
                       double precio,
                       int stock) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = "DISPONIBLE";
    }

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }
        this.precio = precio;
    }

    public int getStock() {return stock;}

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException(
                    "El stock no puede ser negativo."
            );
        }
        this.stock = stock;
    }

    public String getEstado() {return estado;}

    public void setEstado(String estado) {
        if (estado.equals("DISPONIBLE") ||
            estado.equals("AGOTADO") ||
            estado.equals("RETIRADO")) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException(
                    "Estado inválido."
            );
        }
    }

    public Medicamento getMedicamentoRelacionado() {return medicamentoRelacionado;}

    public void setMedicamentoRelacionado(Medicamento medicamentoRelacionado) {
        this.medicamentoRelacionado = medicamentoRelacionado;
    }

    public abstract double calcularPrecioFinal();

    public abstract String getTipo();

    public abstract String getIndicacionEspecial();

    public abstract void mostrarInformacion();
}
