/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mifarma;

public class Suplemento extends Medicamento {

    private boolean vitaminico;
    private double porcentajeDescuento;

    public Suplemento(String codigo,
                      String nombre,
                      double precio,
                      int stock,
                      boolean vitaminico,
                      double porcentajeDescuento) {

        super(codigo, nombre, precio, stock);

        this.vitaminico = vitaminico;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isVitaminico() {return vitaminico;}

    public void setVitaminico(boolean vitaminico) {this.vitaminico = vitaminico;}

    public double getPorcentajeDescuento() {return porcentajeDescuento;}

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0) {

            throw new IllegalArgumentException(
                    "El descuento no puede ser negativo."
            );
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() -
                (getPrecio() * porcentajeDescuento);
    }

    @Override
    public String getTipo() {
        return "SUPLEMENTO";
    }

    @Override
    public String getIndicacionEspecial() {
        if (vitaminico) {
            return "Vitaminico";
        }
        return "Nutricional";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==============");
        System.out.println("SUPLEMENTO");
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