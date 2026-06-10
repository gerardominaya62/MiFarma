/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mifarma;

public class MedicamentoControlado extends Medicamento {

    private boolean requiereHuella;
    private double impuestoEspecial;

    public MedicamentoControlado(String codigo,
                                 String nombre,
                                 double precio,
                                 int stock,
                                 boolean requiereHuella,
                                 double impuestoEspecial) {

        super(codigo, nombre, precio, stock);

        this.requiereHuella = requiereHuella;
        this.impuestoEspecial = impuestoEspecial;
    }

    public boolean isRequiereHuella() {return requiereHuella;}

    public void setRequiereHuella(boolean requiereHuella) {this.requiereHuella = requiereHuella;}

    public double getImpuestoEspecial() {return impuestoEspecial;}

    public void setImpuestoEspecial(double impuestoEspecial) {
        if (impuestoEspecial < 0) {

            throw new IllegalArgumentException(
                    "Impuesto inválido."
            );
        }
        this.impuestoEspecial = impuestoEspecial;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() + impuestoEspecial;
    }

    @Override
    public String getTipo() {
        return "CONTROLADO";
    }

    @Override
    public String getIndicacionEspecial() {
        if (requiereHuella) {
            return "Requiere huella digital";
        }
        return "Control moderado";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==============");
        System.out.println("MEDICAMENTO CONTROLADO");
        System.out.println("==============");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio Base: " + getPrecio());
        System.out.println("Precio Final: " + calcularPrecioFinal());
        System.out.println("Stock: " + getStock());
        System.out.println("Estado: " + getEstado());
        System.out.println("Indicacion: " + getIndicacionEspecial());
    }
}
