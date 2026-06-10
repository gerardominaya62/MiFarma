/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import mifarma.*;

import java.util.ArrayList;

public class FarmaciaService {

    private ArrayList<Medicamento> medicamentos;
    private ArrayList<Cliente> clientes;

    public FarmaciaService() {

        medicamentos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {

        medicamentos.add(medicamento);

        System.out.println(
                "Medicamento agregado correctamente."
        );
    }

    public void listarMedicamentos() {

        if (medicamentos.isEmpty()) {

            System.out.println(
                    "No existen medicamentos registrados."
            );

            return;
        }

        for (Medicamento m : medicamentos) {

            m.mostrarInformacion();

            if (m.getMedicamentoRelacionado() != null) {

                System.out.println(
                        "Relacionado con: " +
                        m.getMedicamentoRelacionado().getNombre()
                );
            }

            System.out.println("--------------------------------");
        }
    }

    public Medicamento buscarMedicamento(String codigo) {

        for (Medicamento m : medicamentos) {

            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }

        return null;
    }

    public boolean existeMedicamento(String codigo) {

        return buscarMedicamento(codigo) != null;
    }

    public void eliminarMedicamento(String codigo) {

        Medicamento medicamento = buscarMedicamento(codigo);

        if (medicamento == null) {

            System.out.println(
                    "Medicamento no encontrado."
            );

            return;
        }

        medicamentos.remove(medicamento);

        System.out.println(
                "Medicamento eliminado correctamente."
        );
    }

    public void venderMedicamento(String codigo) {

        Medicamento medicamento =
                buscarMedicamento(codigo);

        if (medicamento == null) {

            System.out.println(
                    "Medicamento no encontrado."
            );

            return;
        }

        if (medicamento.getEstado().equals("RETIRADO")) {

            System.out.println(
                    "No se puede vender un medicamento retirado."
            );

            return;
        }

        if (medicamento.getStock() <= 0) {

            medicamento.setEstado("AGOTADO");

            System.out.println(
                    "Medicamento sin stock."
            );

            return;
        }

        medicamento.setStock(
                medicamento.getStock() - 1
        );

        System.out.println(
                "Venta realizada correctamente."
        );

        System.out.println(
                "Precio final: S/. "
                        + medicamento.calcularPrecioFinal()
        );

        if (medicamento.getMedicamentoRelacionado() != null) {

            System.out.println(
                    "Sugerencia automática:"
            );

            System.out.println(
                    medicamento.getMedicamentoRelacionado()
                            .getNombre()
            );
        }

        if (medicamento.getStock() == 0) {

            medicamento.setEstado("AGOTADO");

            System.out.println(
                    "El medicamento quedó AGOTADO."
            );
        }
    }

    public void relacionarMedicamentos(
            String codigoPrincipal,
            String codigoRelacionado
    ) {

        if (codigoPrincipal.equalsIgnoreCase(
                codigoRelacionado)) {

            System.out.println(
                    "Un medicamento no puede relacionarse consigo mismo."
            );

            return;
        }

        Medicamento principal =
                buscarMedicamento(codigoPrincipal);

        Medicamento relacionado =
                buscarMedicamento(codigoRelacionado);

        if (principal == null || relacionado == null) {

            System.out.println(
                    "Uno o ambos medicamentos no existen."
            );

            return;
        }

        principal.setMedicamentoRelacionado(
                relacionado
        );

        System.out.println(
                "Medicamentos relacionados correctamente."
        );
    }

    public void registrarCliente(Cliente cliente) {

        clientes.add(cliente);

        System.out.println(
                "Cliente registrado correctamente."
        );
    }

    public void listarClientes() {

        if (clientes.isEmpty()) {

            System.out.println(
                    "No hay clientes registrados."
            );

            return;
        }

        for (Cliente c : clientes) {

            c.mostrarCliente();

            System.out.println("---------------------");
        }
    }

    public Cliente buscarCliente(String dni) {

        for (Cliente c : clientes) {

            if (c.getDni().equals(dni)) {
                return c;
            }
        }

        return null;
    }

    /*public void mostrarMedicamentosAgotados() {

        boolean existe = false;

        System.out.println(
                "\n--- MEDICAMENTOS AGOTADOS ---"
        );

        for (Medicamento m : medicamentos) {

            if (m.getEstado().equals("AGOTADO")) {

                System.out.println(
                        m.getCodigo()
                                + " - "
                                + m.getNombre()
                );

                existe = true;
            }
        }

        if (!existe) {

            System.out.println(
                    "No existen medicamentos agotados."
            );
        }
    }*/

    public void mostrarMedicamentosRetirados() {

        boolean existe = false;

        System.out.println(
                "\n--- MEDICAMENTOS RETIRADOS ---"
        );

        for (Medicamento m : medicamentos) {

            if (m.getEstado().equals("RETIRADO")) {

                System.out.println(
                        m.getCodigo()
                                + " - "
                                + m.getNombre()
                );

                existe = true;
            }
        }

        if (!existe) {

            System.out.println(
                    "No existen medicamentos retirados."
            );
        }
    }

    public void mostrarMedicamentosConDescuento() {

        boolean existe = false;

        System.out.println(
                "\n--- MEDICAMENTOS CON DESCUENTO ---"
        );

        for (Medicamento m : medicamentos) {

            if (m instanceof Analgesico) {

                Analgesico a = (Analgesico) m;

                if (a.isTieneDescuento()) {

                    System.out.println(
                            a.getNombre()
                    );

                    existe = true;
                }
            }
        }

        if (!existe) {

            System.out.println(
                    "No existen descuentos activos."
            );
        }
    }

    public void aumentarStock(
            String codigo,
            int cantidad
    ) {

        Medicamento medicamento =
                buscarMedicamento(codigo);

        if (medicamento == null) {

            System.out.println(
                    "Medicamento no encontrado."
            );

            return;
        }

        medicamento.setStock(
                medicamento.getStock() + cantidad
        );

        if (medicamento.getStock() > 0 &&
            medicamento.getEstado().equals("AGOTADO")) {

            medicamento.setEstado("DISPONIBLE");
        }

        System.out.println(
                "Stock actualizado correctamente."
        );
    }

    public void mostrarTotalMedicamentos() {

        System.out.println(
                "Total medicamentos: "
                        + medicamentos.size()
        );
    }

    public void mostrarTotalClientes() {

        System.out.println(
                "Total clientes: "
                        + clientes.size()
        );
    }

    public void mostrarMedicamentoMasCaro() {

        if (medicamentos.isEmpty()) {

            System.out.println(
                    "No existen medicamentos."
            );

            return;
        }

        Medicamento caro = medicamentos.get(0);

        for (Medicamento m : medicamentos) {

            if (m.calcularPrecioFinal() >
                caro.calcularPrecioFinal()) {

                caro = m;
            }
        }

        System.out.println(
                "\nMedicamento más caro:"
        );

        caro.mostrarInformacion();
    }
}