/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import mifarma.*;

import servicio.FarmaciaService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaFarmacia {

    private static Scanner sc = new Scanner(System.in);

    private static FarmaciaService farmacia =
            new FarmaciaService();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    registrarAnalgesico();
                    break;

                case 2:
                    registrarAntibiotico();
                    break;

                case 3:
                    registrarSuplemento();
                    break;

                case 4:
                    registrarMedicamentoControlado();
                    break;

                case 5:
                    listarMedicamentos();
                    break;

                case 6:
                    venderMedicamento();
                    break;

                case 7:
                    relacionarMedicamentos();
                    break;

                case 8:
                    buscarMedicamento();
                    break;

                case 9:
                    eliminarMedicamento();
                    break;

                case 10:
                    aumentarStock();
                    break;

                case 11:
                    registrarCliente();
                    break;

                case 12:
                    listarClientes();
                    break;

                case 13:
                    mostrarMedicamentosAgotados();
                    break;

                case 14:
                    mostrarMedicamentosConDescuento();
                    break;

                case 15:
                    mostrarMedicamentoMasCaro();
                    break;

                case 16:
                    System.out.println(
                            "Saliendo del sistema..."
                    );
                    break;

                default:
                    System.out.println(
                            "Opción inválida."
                    );
            }

        } while (opcion != 16);
    }

    // ====================================
    // MENÚ
    // ====================================

    private static void mostrarMenu() {

        System.out.println("\n==================================");
        System.out.println("  SISTEMA DE FARMACIA MEJORADO");
        System.out.println("==================================");
        System.out.println("1. Registrar Analgésico");
        System.out.println("2. Registrar Antibiótico");
        System.out.println("3. Registrar Suplemento");
        System.out.println("4. Registrar Medicamento Controlado");
        System.out.println("5. Listar Medicamentos");
        System.out.println("6. Vender Medicamento");
        System.out.println("7. Relacionar Medicamentos");
        System.out.println("8. Buscar Medicamento");
        System.out.println("9. Eliminar Medicamento");
        System.out.println("10. Aumentar Stock");
        System.out.println("11. Registrar Cliente");
        System.out.println("12. Listar Clientes");
        System.out.println("13. Mostrar Agotados");
        System.out.println("14. Mostrar Descuentos");
        System.out.println("15. Medicamento Más Caro");
        System.out.println("16. Salir");
        System.out.println("==================================");
    }

    // ====================================
    // REGISTROS
    // ====================================

    private static void registrarAnalgesico() {

        System.out.println(
                "\n--- REGISTRAR ANALGÉSICO ---"
        );

        String codigo = leerCodigoNoRepetido();
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");

        boolean descuento =
                leerBoolean("¿Tiene descuento? (S/N): ");

        Analgesico a = new Analgesico(
                codigo,
                nombre,
                precio,
                stock,
                descuento
        );

        farmacia.agregarMedicamento(a);
    }

    private static void registrarAntibiotico() {

        System.out.println(
                "\n--- REGISTRAR ANTIBIÓTICO ---"
        );

        String codigo = leerCodigoNoRepetido();
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");

        boolean receta =
                leerBoolean("¿Requiere receta? (S/N): ");

        int dias =
                leerEntero("Días de tratamiento: ");

        Antibiotico a = new Antibiotico(
                codigo,
                nombre,
                precio,
                stock,
                receta,
                dias
        );

        farmacia.agregarMedicamento(a);
    }

    private static void registrarSuplemento() {

        System.out.println(
                "\n--- REGISTRAR SUPLEMENTO ---"
        );

        String codigo = leerCodigoNoRepetido();
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");

        boolean vitaminico =
                leerBoolean("¿Es vitamínico? (S/N): ");

        double descuento =
                leerDouble("Descuento (0.10): ");

        Suplemento s = new Suplemento(
                codigo,
                nombre,
                precio,
                stock,
                vitaminico,
                descuento
        );

        farmacia.agregarMedicamento(s);
    }

    private static void registrarMedicamentoControlado() {

        System.out.println(
                "\n--- REGISTRAR MEDICAMENTO CONTROLADO ---"
        );

        String codigo = leerCodigoNoRepetido();
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");

        boolean huella =
                leerBoolean(
                        "¿Requiere huella digital? (S/N): "
                );

        double impuesto =
                leerDouble("Impuesto especial: ");

        MedicamentoControlado m =
                new MedicamentoControlado(
                        codigo,
                        nombre,
                        precio,
                        stock,
                        huella,
                        impuesto
                );

        farmacia.agregarMedicamento(m);
    }

    // ====================================
    // LISTAR
    // ====================================

    private static void listarMedicamentos() {

        System.out.println(
                "\n--- LISTA DE MEDICAMENTOS ---"
        );

        farmacia.listarMedicamentos();
    }

    // ====================================
    // VENTAS
    // ====================================

    private static void venderMedicamento() {

        System.out.println(
                "\n--- VENDER MEDICAMENTO ---"
        );

        String codigo =
                leerTexto("Ingrese código: ");

        farmacia.venderMedicamento(codigo);
    }

    // ====================================
    // RELACIONES
    // ====================================

    private static void relacionarMedicamentos() {

        System.out.println(
                "\n--- RELACIONAR MEDICAMENTOS ---"
        );

        String principal =
                leerTexto(
                        "Código medicamento principal: "
                );

        String relacionado =
                leerTexto(
                        "Código medicamento relacionado: "
                );

        farmacia.relacionarMedicamentos(
                principal,
                relacionado
        );
    }

    // ====================================
    // BÚSQUEDA
    // ====================================

    private static void buscarMedicamento() {

        System.out.println(
                "\n--- BUSCAR MEDICAMENTO ---"
        );

        String codigo =
                leerTexto("Ingrese código: ");

        Medicamento medicamento =
                farmacia.buscarMedicamento(codigo);

        if (medicamento == null) {

            System.out.println(
                    "Medicamento no encontrado."
            );

            return;
        }

        medicamento.mostrarInformacion();
    }

    // ====================================
    // ELIMINAR
    // ====================================

    private static void eliminarMedicamento() {

        System.out.println(
                "\n--- ELIMINAR MEDICAMENTO ---"
        );

        String codigo =
                leerTexto("Ingrese código: ");

        farmacia.eliminarMedicamento(codigo);
    }

    // ====================================
    // STOCK
    // ====================================

    private static void aumentarStock() {

        System.out.println(
                "\n--- AUMENTAR STOCK ---"
        );

        String codigo =
                leerTexto("Ingrese código: ");

        int cantidad =
                leerEntero("Cantidad a aumentar: ");

        farmacia.aumentarStock(
                codigo,
                cantidad
        );
    }

    // ====================================
    // CLIENTES
    // ====================================

    private static void registrarCliente() {

        System.out.println(
                "\n--- REGISTRAR CLIENTE ---"
        );

        String dni =
                leerTexto("Ingrese DNI: ");

        String nombre =
                leerTexto("Ingrese nombre: ");

        int edad =
                leerEntero("Ingrese edad: ");

        Cliente cliente = new Cliente(
                dni,
                nombre,
                edad
        );

        farmacia.registrarCliente(cliente);
    }

    private static void listarClientes() {

        System.out.println(
                "\n--- LISTA DE CLIENTES ---"
        );

        farmacia.listarClientes();
    }

    // ====================================
    // REPORTES
    // ====================================

    private static void mostrarMedicamentosAgotados() {

        farmacia.mostrarMedicamentosAgotados();
    }

    private static void mostrarMedicamentosConDescuento() {

        farmacia.mostrarMedicamentosConDescuento();
    }

    private static void mostrarMedicamentoMasCaro() {

        farmacia.mostrarMedicamentoMasCaro();
    }

    // ====================================
    // VALIDACIONES
    // ====================================

    private static String leerCodigoNoRepetido() {

        String codigo;

        do {

            codigo = leerTexto("Código: ");

            if (farmacia.existeMedicamento(codigo)) {

                System.out.println(
                        "Ya existe un medicamento con ese código."
                );
            }

        } while (farmacia.existeMedicamento(codigo));

        return codigo;
    }

    private static int leerEntero(String mensaje) {

        int valor;

        while (true) {

            try {

                System.out.print(mensaje);

                valor = sc.nextInt();

                sc.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Ingrese un número entero válido."
                );

                sc.nextLine();
            }
        }
    }

    private static double leerDouble(String mensaje) {

        double valor;

        while (true) {

            try {

                System.out.print(mensaje);

                valor = sc.nextDouble();

                sc.nextLine();

                if (valor <= 0) {

                    System.out.println(
                            "El valor debe ser mayor que cero."
                    );

                } else {

                    return valor;
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Ingrese un número decimal válido."
                );

                sc.nextLine();
            }
        }
    }

    private static boolean leerBoolean(String mensaje) {

        String respuesta;

        while (true) {

            System.out.print(mensaje);

            respuesta = sc.nextLine()
                    .trim()
                    .toUpperCase();

            if (respuesta.equals("S")) {

                return true;
            }

            if (respuesta.equals("N")) {

                return false;
            }

            System.out.println(
                    "Ingrese S para Sí o N para No."
            );
        }
    }

    private static String leerTexto(String mensaje) {

        String texto;

        do {

            System.out.print(mensaje);

            texto = sc.nextLine().trim();

            if (texto.isEmpty()) {

                System.out.println(
                        "El texto no puede estar vacío."
                );
            }

        } while (texto.isEmpty());

        return texto;
    }
}