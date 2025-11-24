package udla.jaimeh.rp2.p;

import udla.jaimeh.rp2.pc.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final double DESCUENTO_UMBRAL = 10000.0;
    private static final double DESCUENTO_PORCENTAJE = 0.10;

    private static Scanner sc = new Scanner(System.in);
    private static List<Auto> listaAuto = new ArrayList<>();
    private static List<Motocicleta> listaMotocicletas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    eliminarAuto();
                    break;
                case 3:
                    agregarmotocicleta();
                    break;
                case 4:
                    eliminarMotocicleta();
                    break;
                case 5:
                    buscarporrangodeprecio();
                    break;
                case 6:
                    mostrarVehiculosyMotocicletas();
                    break;
                case 7:
                    venderVehiculo();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("=== Sistema de Gestión de Vehículos ===");
        System.out.println("1. Agregar Auto");
        System.out.println("2. Eliminar Auto");
        System.out.println("3. Agregar Motocicleta");
        System.out.println("4. Eliminar Motocicleta");
        System.out.println("5. Buscar por rango de precio");
        System.out.println("6. Mostrar Vehículos y Motocicletas");
        System.out.println("7. Vender Vehículo (descuento si > 10000)");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarVehiculo() {
        System.out.println("Agregar Auto");
        System.out.println("Marca: ");
        String marca = sc.nextLine();
        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Año: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.println("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Numero de puertas: ");
        int numPuertas = Integer.parseInt(sc.nextLine());
        System.out.println("Tipo de transmision (MANUAL, AUTOMATICA, SEMIAUTOMATICA): ");
        TipoTransmision tipoTransmisionStr;
        int opcion = 0;
        do {
            System.out.println("1. MANUAL");
            System.out.println("2. AUTOMATICA");
            System.out.println("3. SEMIAUTOMATICA");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: tipoTransmisionStr = TipoTransmision.MANUAL; break;
                case 2: tipoTransmisionStr = TipoTransmision.AUTOMATICA; break;
                case 3: tipoTransmisionStr = TipoTransmision.SEMIAUTOMATICA; break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    tipoTransmisionStr = null;
            }
        } while (opcion < 1 || opcion > 3);

        System.out.println("Kilometraje: ");
        double kilometraje = Double.parseDouble(sc.nextLine());

        Auto auto = new Auto(marca, modelo, anio, precio, numPuertas, tipoTransmisionStr, kilometraje, 0);
        listaAuto.add(auto);
        System.out.println("Auto agregado exitosamente.");
    }

    private static void agregarmotocicleta() {
        System.out.println("Agregar Motocicleta");
        System.out.println("Marca: ");
        String marca = sc.nextLine();
        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Año: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.println("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Cilindraje: ");
        double cilindraje = Double.parseDouble(sc.nextLine());
        System.out.println("Tipo de motocicleta (DEPORTIVA, CRUCERO, SCOOTER, MOTOCROSS, NAKED): ");
        TipoMotocicleta tipoMotocicletaStr;
        int opcion = 0;
        do {
            System.out.println("1. DEPORTIVA");
            System.out.println("2. CRUCERO");
            System.out.println("3. SCOOTER");
            System.out.println("4. MOTOCROSS");
            System.out.println("5. NAKED");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: tipoMotocicletaStr = TipoMotocicleta.DEPORTIVA; break;
                case 2: tipoMotocicletaStr = TipoMotocicleta.CRUCERO; break;
                case 3: tipoMotocicletaStr = TipoMotocicleta.SCOOTER; break;
                case 4: tipoMotocicletaStr = TipoMotocicleta.MOTOCROSS; break;
                case 5: tipoMotocicletaStr = TipoMotocicleta.NAKED; break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    tipoMotocicletaStr = null;
            }
        } while (opcion < 1 || opcion > 5);

        Motocicleta motocicleta = new Motocicleta(marca, modelo, anio, precio, cilindraje, tipoMotocicletaStr, 0);
        listaMotocicletas.add(motocicleta);
        System.out.println("Motocicleta agregada exitosamente.");
    }

    private static void eliminarAuto() {
        System.out.println("Eliminar Auto");
        System.out.print("Ingrese el ID del auto a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        Auto encontrado = null;
        for (Auto a : listaAuto) {
            if (a.getId() == id) { encontrado = a; break; }
        }
        if (encontrado != null) {
            listaAuto.remove(encontrado);
            System.out.println("Auto eliminado.");
        } else {
            System.out.println("ID no encontrado.");
        }
    }

    private static void eliminarMotocicleta() {
        System.out.println("Eliminar Motocicleta");
        System.out.print("Ingrese el ID de la motocicleta a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        Motocicleta encontrada = null;
        for (Motocicleta m : listaMotocicletas) {
            if (m.getId() == id) { encontrada = m; break; }
        }
        if (encontrada != null) {
            listaMotocicletas.remove(encontrada);
            System.out.println("Motocicleta eliminada.");
        } else {
            System.out.println("ID no encontrado.");
        }
    }

    private static void venderVehiculo() {
        System.out.println("Vender Vehículo");
        System.out.println("Tipo: 1.Auto  2.Motocicleta");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (tipo == 1) {
            Auto encontrado = null;
            for (Auto a : listaAuto) {
                if (a.getId() == id) { encontrado = a; break; }
            }
            if (encontrado != null) {
                double precioOriginal = encontrado.getPrecio();
                double precioFinal = aplicarDescuento(precioOriginal);
                listaAuto.remove(encontrado);
                System.out.println("Auto vendido. Precio original: " + precioOriginal + " | Precio final: " + precioFinal);
            } else {
                System.out.println("Auto no encontrado.");
            }
        } else if (tipo == 2) {
            Motocicleta encontrada = null;
            for (Motocicleta m : listaMotocicletas) {
                if (m.getId() == id) { encontrada = m; break; }
            }
            if (encontrada != null) {
                double precioOriginal = encontrada.getPrecio();
                double precioFinal = aplicarDescuento(precioOriginal);
                listaMotocicletas.remove(encontrada);
                System.out.println("Motocicleta vendida. Precio original: " + precioOriginal + " | Precio final: " + precioFinal);
            } else {
                System.out.println("Motocicleta no encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static double aplicarDescuento(double precio) {
        if (precio > DESCUENTO_UMBRAL) {
            return precio * (1 - DESCUENTO_PORCENTAJE);
        }
        return precio;
    }

    private static void buscarporrangodeprecio() {
        System.out.println("Buscar por rango de precio");
        System.out.print("Ingrese el precio mínimo: ");
        double precioMin = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el precio máximo: ");
        double precioMax = Double.parseDouble(sc.nextLine());

        System.out.println("Autos en el rango:");
        for (Auto auto : listaAuto) {
            if (auto.getPrecio() >= precioMin && auto.getPrecio() <= precioMax) {
                auto.mostrarInfo();
                System.out.println("---------------------");
            }
        }

        System.out.println("Motocicletas en el rango:");
        for (Motocicleta moto : listaMotocicletas) {
            if (moto.getPrecio() >= precioMin && moto.getPrecio() <= precioMax) {
                moto.mostrarInfoMotocicleta();
                System.out.println("---------------------");
            }
        }
    }

    private static void calcularinventario() {
        double total = 0.0;
        for (Auto auto : listaAuto) total += auto.getPrecio();
        for (Motocicleta moto : listaMotocicletas) total += moto.getPrecio();
        System.out.println("Valor total del inventario: $" + total);
    }

    private static void mostrarVehiculosyMotocicletas() {
        System.out.println("=== Lista de Autos ===");
        for (Auto auto : listaAuto) {
            auto.mostrarInfo();
            System.out.println("---------------------");
        }
        System.out.println("=== Lista de Motocicletas ===");
        for (Motocicleta moto : listaMotocicletas) {
            moto.mostrarInfoMotocicleta();
            System.out.println("---------------------");
        }
        calcularinventario();
    }
}