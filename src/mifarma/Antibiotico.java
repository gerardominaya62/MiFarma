/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mifarma;

public class Antibiotico extends Medicamento {

    private boolean requiereReceta;
    private int diasTratamiento;

    public Antibiotico(String codigo,
                       String nombre,
                       double precio,
                       int stock,
                       boolean requiereReceta,
                       int diasTratamiento) {

        super(codigo, nombre, precio, stock);

        this.requiereReceta = requiereReceta;
        this.diasTratamiento = diasTratamiento;
    }

    public boolean isRequiereReceta() {return requiereReceta;}

    public void setRequiereReceta(boolean requiereReceta) {this.requiereReceta = requiereReceta;}

    public int getDiasTratamiento() {return diasTratamiento;}

    public void setDiasTratamiento(int diasTratamiento) {
        if (diasTratamiento <= 0) {

            throw new IllegalArgumentException(
                    "Los días deben ser mayores a cero."
            );
        }
        this.diasTratamiento = diasTratamiento;
    }

    @Override
    public double calcularPrecioFinal() {
        
        double precioFinal = getPrecio();
        
        if (requiereReceta) {
            precioFinal += 15;
        }

        if (diasTratamiento > 7) {
            precioFinal += 10;
        }

        return precioFinal;
    }

    @Override
    public String getTipo() {
        return "ANTIBIOTICO";
    }

    @Override
    public String getIndicacionEspecial() {

        if (requiereReceta) {
            return "Requiere receta";
        }
        return "Venta libre";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==============");
        System.out.println("ANTIBIÓTICO");
        System.out.println("==============");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio Base: " + getPrecio());
        System.out.println("Precio Final: " + calcularPrecioFinal());
        System.out.println("Stock: " + getStock());
        System.out.println("Estado: " + getEstado());
        System.out.println("Dias Tratamiento: " + diasTratamiento);
        System.out.println("Indicacion: " + getIndicacionEspecial());
    }
}