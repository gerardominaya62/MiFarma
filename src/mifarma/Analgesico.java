/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mifarma;

public class Analgesico extends Medicamento {

    private boolean tieneDescuento;

    public Analgesico(String codigo,
                      String nombre,
                      double precio,
                      int stock,
                      boolean tieneDescuento) {

        super(codigo, nombre, precio, stock);
        this.tieneDescuento = tieneDescuento;
    }

    public boolean isTieneDescuento() {return tieneDescuento;}

    public void setTieneDescuento(boolean tieneDescuento) {this.tieneDescuento = tieneDescuento;}

    @Override
    public double calcularPrecioFinal() {
        if (tieneDescuento) {
            return getPrecio() * 0.90;
        }
        return getPrecio();
    }

    @Override
    public String getTipo() {
        return "ANALGÉSICO";
    }

    @Override
    public String getIndicacionEspecial() {
        if (tieneDescuento) {
            return "Descuento activo";
        }
        return "Sin descuento";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==============");
        System.out.println("ANALGÉSICO");
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