import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Pedido;
import utils.Colores;
import utils.Interaccion;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class mainGentesimal {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        gestionGESTESIMAL controlador = new gestionGESTESIMAL();
        var s = new Scanner(System.in);

        controlador.addMockCliente();
        controlador.addMockArticulos();
        controlador.addMockFacturas();
        //System.out.println(controlador.getClientes());
        /*controlador.addMock(controlador.getArticulos());
        controlador.listarArticulosEnAlmacen();
        System.out.println();
        controlador.aniadirArticulosEnAlmacen();
        controlador.listarArticulosEnAlmacen();*/
        System.out.println("             ____________________________________________________\n" +
                "            /                                                    \\\n" +
                "           |    _____________________________________________     |\n" +
                "           |   |                                             |    |\n" +
                "           |   |  C:\\> run Gestesimal --consola              |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |   PULSA UNA TECLA PARA CONFIRMAR:           |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |                                             |    |\n" +
                "           |   |_____________________________________________|    |\n" +
                "           |                                                      |\n" +
                "            \\_____________________________________________________/\n" +
                "                   \\_______________________________________/\n" +
                "                _______________________________________________\n" +
                "             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
                "          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
                "       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
                "    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
                " _-'.-.-.-.-.-. .---.-. .-----------------------------. .-.---. .---.-.-.-.`-_\n" +
                ":-----------------------------------------------------------------------------:\n" +
                "`---._.-----------------------------------------------------------------._.---'");
        s.nextLine();
        System.out.println(Colores.ANSI_CYAN +
                " _______  _______  _______  _______  ___   _______  ___   __   __  _______  ___     \n" +
                "|       ||       ||       ||       ||   | |       ||   | |  |_|  ||   _   ||   |    \n" +
                "|    ___||    ___||  _____||_     _||   | |  _____||   | |       ||  |_|  ||   |    \n" +
                "|   | __ |   |___ | |_____   |   |  |   | | |_____ |   | |       ||       ||   |    \n" +
                "|   ||  ||    ___||_____  |  |   |  |   | |_____  ||   | |       ||       ||   |___ \n" +
                "|   |_| ||   |___  _____| |  |   |  |   |  _____| ||   | | ||_|| ||   _   ||       |\n" +
                "|_______||_______||_______|  |___|  |___| |_______||___| |_|   |_||__| |__||_______|"
                + Colores.ANSI_RESET);
        int opcion = 0;
        do {
            System.out.println();
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("    _--------------------_");
            System.out.println("1: | Gestión de productos |");
            System.out.println("    -____________________-");
            System.out.println("    _--------------------_");
            System.out.println("2. |  Gestión de clientes |");
            System.out.println("    -____________________-");
            System.out.println("    _--------------------_");
            System.out.println("3. |  Gestión de pedidos  |");
            System.out.println("    -____________________-");
            System.out.println("    _--------------------_");
            System.out.println("4. |  Gestión de facturas |");
            System.out.println("    -____________________-");
            System.out.println("    _--------------------_");
            System.out.println("5. |         Salir        |");
            System.out.println("    -____________________-");
            System.out.println("--------------------------------");
            System.out.print("Introduce una opcion: ");
            opcion = Integer.parseInt(s.nextLine());
            Interaccion.cargandoBarra(10, 100);
            switch (opcion) {
                case 1 -> {
                    Interaccion.limpiaPantallash();
                    int menuProductos = 0;
                    do {
                        System.out.println("\n\nActualmente tenemos: " + controlador.getArticulos().size() + " artículos dados de alta");
                        System.out.println("El stock total de todos los artículos es: " + controlador.stockTotal(controlador.getArticulos()));
                        System.out.println("---------Menú de productos------");
                        System.out.println("--------------------------------");
                        System.out.println("    _--------------------_");
                        System.out.println("1. |       Listado        |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("2. |        Alta          |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("3. |        Baja          |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("4. |      Modificación    |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("5. | Entrada de mercancía |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("6. |        Salir         |");
                        System.out.println("    -____________________-");
                        System.out.println("--------------------------------");
                        System.out.print("Introduce una opción: ");
                        menuProductos = Integer.parseInt(s.nextLine());
                        Interaccion.cargandoBarra(10, 100);
                        switch (menuProductos) {
                            case 1 -> { // Listado
                                Interaccion.limpiaPantallash();
                                controlador.listarArticulosEnAlmacen();
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 2 -> { // Alta
                                Interaccion.limpiaPantallash();
                                System.out.print("Introduce la descripción del artículo: ");
                                String descripcion = s.nextLine();
                                System.out.print("Introduce el precio de compra: ");
                                float precioCompra = Float.parseFloat(s.nextLine());
                                System.out.print("Introduce el precio de venta: ");
                                float precioVenta = Float.parseFloat(s.nextLine());
                                if (controlador.aniadirArticulosEnAlmacen(descripcion, precioCompra, precioVenta))
                                    System.out.println(Colores.ANSI_GREEN + "Artículo añadido correctamente." + Colores.ANSI_RESET);
                                else System.out.println("No se ha podido añadir el artículo");

                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 3 -> { // Baja
                                Interaccion.limpiaPantallash();
                                System.out.print("Introduce el código del artículo: ");
                                String codigo = s.nextLine();
                                if (controlador.borrarArticuloEnAlmacen(codigo))
                                    System.out.println(Colores.ANSI_GREEN + "Artículo borrado correctamente" + Colores.ANSI_RESET);
                                else
                                    System.out.println(Colores.ANSI_RED + "No se ha podido borrar el artículo" + Colores.ANSI_RESET);
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 4 -> { // Modificación
                                Interaccion.limpiaPantallash();
                                System.out.print("Introduce el código del artículo: ");
                                String codigo = s.nextLine();

                                if (controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo) == null) {
                                    System.out.print(Colores.ANSI_RED + "El artículo no se ha encontrado" + Colores.ANSI_RESET);
                                } else {
                                    String opcionMod = "";
                                    do {
                                        System.out.println("Descripción: " + controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo).getDescripcion());
                                        System.out.println("Precio Compra: " + controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo).getPrecioCompra());
                                        System.out.println("Precio Venta: " + controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo).getPrecioVenta());
                                        System.out.println("--Menú de modificación de un artículo--");
                                        System.out.println("---------------------------------------");
                                        System.out.println("    _------------------------_");
                                        System.out.println("1. | Modificar la descripción |");
                                        System.out.println("    -________________________-");
                                        System.out.println("    _------------------------------_");
                                        System.out.println("2. | Modificar el precio de compra  |");
                                        System.out.println("    -______________________________-");
                                        System.out.println("    _-----------------------------_");
                                        System.out.println("3. | Modificar el precio de venta  |");
                                        System.out.println("    -_____________________________-");
                                        System.out.println("    _--------------------_");
                                        System.out.println("4. |         Salir        |");
                                        System.out.println("    -____________________-");
                                        System.out.println("---------------------------------------");
                                        System.out.print("Introduce una opción: ");
                                        opcionMod = s.nextLine();
                                        switch (opcionMod) {
                                            case "1" -> { // Modificar la descripción
                                                System.out.print("Introduce una nueva descripción: ");
                                                controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo).setDescripcion(s.nextLine());
                                            }
                                            case "2" -> { // Modificar el precio de compra
                                                System.out.print("Introduce un nuevo precio de compra: ");
                                                controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo).setPrecioCompra(Float.parseFloat(s.nextLine()));
                                            }
                                            case "3" -> { // Modificar el precio de venta
                                                System.out.print("Introduce un nuevo precio de venta: ");
                                                controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo).setPrecioVenta(Float.parseFloat(s.nextLine()));
                                            }
                                            case "4" -> { // Salir
                                                System.out.println("Hasta pronto.");
                                                Interaccion.limpiaPantallash();
                                            }
                                            default -> System.out.println("Opción no válida");
                                        }
                                    } while (!opcionMod.equals("4"));
                                }
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 5 -> { // Entrada de mercancía
                                Interaccion.limpiaPantallash();
                                System.out.print("Introduce el código del artículo: ");
                                String codigo = s.nextLine();
                                if (controlador.buscaCodigoArticulo(controlador.getArticulos(), codigo) == null)
                                    System.out.println(Colores.ANSI_RED + "El artículo no se ha podido encontrar" + Colores.ANSI_RESET);
                                else {
                                    System.out.print("Introduce una cantidad: ");
                                    int cantidad = Integer.parseInt(s.nextLine());
                                    if (controlador.aniadirStockEnAlmacen(codigo, cantidad))
                                        System.out.println(Colores.ANSI_GREEN + "Stock añadido correctamente " + Colores.ANSI_RESET);
                                    else
                                        System.out.println(Colores.ANSI_RED + "No se ha podido añadir el stock" + Colores.ANSI_RESET);
                                }
                                Interaccion.pulsarTeclaContinuar();
                            }
                            /*case 6 -> { // Salida de mercancía
                                System.out.print("Introduce el código del artículo: ");
                                String codigo = s.nextLine();
                                if (controlador.buscaCodigo(controlador.getArticulos(), codigo) == null)
                                    System.out.println("El artículo no se ha podido encontrar");
                                else {
                                    System.out.println("Introduce la cantidad de stock que desea retirar: ");
                                    int unidades = Integer.parseInt(s.nextLine());
                                    if (controlador.quitarStockEnAlmacen(codigo, unidades)) {
                                        System.out.println("El importe de la factura es: " + controlador.buscaCodigo(controlador.getArticulos(), codigo).calculaPrecioVentaTotal(unidades));
                                        System.out.println("Stock modificado con éxito");
                                        System.out.println("La ganancia ha sido de: " + controlador.buscaCodigo(controlador.getArticulos(), codigo).calculaGananciaVenta(unidades) + " €");
                                    } else System.out.println("No se ha podido retirar el stock del almacen");
                                }
                            }*/
                            case 6 -> {
                                System.out.println("Hasta pronto. ");
                                Interaccion.limpiaPantallash();
                            }
                            default -> System.out.println("Opción incorrecta");
                        }
                    } while (menuProductos != 6);
                }
                case 2 -> {//Gestion clientes
                    Interaccion.limpiaPantallash();
                    int menuClientes = 0;
                    do {
                        System.out.println("\n\nActualmente tenemos: " + controlador.contarClientes() + " clientes dados de alta");
                        System.out.println("--------Menú de clientes:------");
                        System.out.println("-------------------------------");
                        System.out.println("    _--------------------_");
                        System.out.println("1. |     Añadir Cliente   |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("2. |   Modificar Cliente  |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("3. |  Dar de baja Cliente |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("4. |    Listar Clientes   |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("5. |         Salir        |");
                        System.out.println("    -____________________-");
                        System.out.println("--------------------------------");
                        System.out.print("Introduce una opción: ");
                        menuClientes = Integer.parseInt(s.nextLine());
                        Interaccion.cargandoBarra(10, 100);
                        switch (menuClientes) {
                            case 1 -> { // añadir cliente
                                System.out.print("Introduce el nombre de este cliente: ");
                                String nombre = s.nextLine();
                                System.out.print("Introduce el móvil: ");
                                String movil = s.nextLine();
                                System.out.print("¿Es particular? s/n: ");
                                String tipo = s.nextLine();
                                String id = "";
                                boolean tipoCliente = false; //es true si es particular y false si es una empresa
                                switch (tipo) {
                                    case "s", "S" -> {
                                        tipoCliente = true;
                                        System.out.print("Introduce el DNI: ");
                                        id = s.nextLine();
                                    }
                                    case "n", "N" -> {
                                        System.out.print("Introduce el CIF: ");
                                        id = s.nextLine();
                                    }
                                    default -> {
                                        System.out.println("Opcion incorrecta. ");
                                    }
                                }
                                if (!controlador.aniadirCliente(movil, id, nombre, tipoCliente))
                                    System.out.println(Colores.ANSI_RED + "El cliente no se ha podido añadir" + Colores.ANSI_RESET);
                                else
                                    System.out.println(Colores.ANSI_GREEN + "El cliente se ha añadido con éxito" + Colores.ANSI_RESET);
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 2 -> { // Modificar cliente
                                System.out.print("Introduce el identificador de un cliente: ");
                                String id = s.nextLine();
                                if (controlador.buscaCliente(id) == null) {
                                    System.out.println("El cliente no se ha encontrado");
                                } else {
                                    String opcionMod = "";
                                    do {
                                        System.out.println("Nombre: " + controlador.buscaCliente(id).getNombre());
                                        System.out.println("Móvil: " + controlador.buscaCliente(id).getMovil());
                                        System.out.println("Menú de modificación de cliente");
                                        System.out.println("\n-------------------------------");
                                        System.out.println("    _--------------------_");
                                        System.out.println("1. |  Modificar el nombre |");
                                        System.out.println("    -____________________-");
                                        System.out.println("    _--------------------_");
                                        System.out.println("2. |  Modificar el móvil  |");
                                        System.out.println("    -____________________-");
                                        System.out.println("    _--------------------_");
                                        System.out.println("3. |         Salir        |");
                                        System.out.println("    -____________________-");
                                        System.out.println("\n-------------------------------");
                                        System.out.print("Introduce una opción: ");
                                        opcionMod = s.nextLine();
                                        switch (opcionMod) {
                                            case "1" -> { // Modificar nombre
                                                System.out.print("Introduce un nuevo nombre: ");
                                                controlador.buscaCliente(id).setNombre(s.nextLine());
                                            }
                                            case "2" -> { // Modificar movil
                                                System.out.print("Introduce un nuevo móvil: ");
                                                controlador.buscaCliente(id).setMovil(s.nextLine());
                                            }
                                            case "3" -> { // Salir
                                                System.out.println("Hasta la próxima. ");
                                            }
                                            default -> System.out.println("Opción no válida. ");
                                        }
                                    } while (!opcionMod.equals("3"));
                                }
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 3 -> { // Dar de baja cliente
                                System.out.print("Introduce la id del cliente que quieres borrar: ");
                                String id = s.nextLine();
                                if (!controlador.borrarCliente(id))
                                    System.out.println("No se ha podido borrar el cliente.");
                                else System.out.println("Se ha borrado el cliente con éxito.");
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 4 -> { // Listar clientes
                                String opcionLCli = "";
                                do {
                                    System.out.println("Menú de listado de clientes");
                                    System.out.println("\n-------------------------------");
                                    System.out.println("    _--------------------------_");
                                    System.out.println("1. |  Listar todos los clientes |");
                                    System.out.println("    -__________________________-");
                                    System.out.println("    _-----------------------------_");
                                    System.out.println("2. |  Buscar un cliente por nombre |");
                                    System.out.println("    -_____________________________-");
                                    System.out.println("    _--------------------------_");
                                    System.out.println("3. |  Buscar un cliente por ID  |");
                                    System.out.println("    -__________________________-");
                                    System.out.println("    _--------------------_");
                                    System.out.println("4. |         Salir        |");
                                    System.out.println("    -____________________-");
                                    System.out.println("\n-------------------------------");
                                    System.out.print("Introduce una opción: ");
                                    opcionLCli = s.nextLine();
                                    switch (opcionLCli) {
                                        case "1" -> { // Listar todos los clientes
                                            Interaccion.limpiaPantallash();
                                            controlador.listarClientes();
                                        }
                                        case "2" -> { // Buscar un cliente por nombre
                                            Interaccion.limpiaPantallash();
                                            System.out.print("Introduce un nombre: ");
                                            String nombre = s.nextLine();
                                            if (controlador.buscaClientePorNombre(nombre).isEmpty())
                                                System.out.println(Colores.ANSI_YELLOW + "No se ha encontrado ningún resultado" + Colores.ANSI_RESET);
                                            else {
                                                for (Cliente c : controlador.buscaClientePorNombre(nombre)) {
                                                    System.out.println(c);
                                                }
                                            }
                                        }
                                        case "3" -> { // Buscar un cliente por ID
                                            Interaccion.limpiaPantallash();
                                            System.out.print("Introduce una id: ");
                                            String id = s.nextLine();
                                            if (controlador.buscaCliente(id) == null)
                                                System.out.println("No se ha encontrado ningún cliente. ");
                                            else System.out.println(controlador.buscaCliente(id));
                                        }
                                        case "4" -> {
                                            System.out.println("Hasta pronto. ");
                                            Interaccion.limpiaPantallash();
                                        }
                                        default -> {
                                            System.out.println("Opción incorrecta. ");
                                        }
                                    }
                                } while (!opcionLCli.equals("4"));
                                Interaccion.pulsarTeclaContinuar();

                            }
                            case 5 -> {
                                System.out.println("Hasta la proxima. ");
                                Interaccion.limpiaPantallash();
                            }
                            default -> {
                                System.out.println("Opcion incorrecta. ");
                            }
                        }
                    } while (menuClientes != 5);

                }
                case 3 -> { // Gestion de pedidos
                    Interaccion.limpiaPantallash();
                    String opcGPed = "";
                    do {
                        System.out.println("--- Menú de gestión de pedidos ---");
                        System.out.println("\n-------------------------------");
                        System.out.println("    _--------------------------_");
                        System.out.println("1. | Listar pedidos pendientes  |");
                        System.out.println("    -__________________________-");
                        System.out.println("    _-------------------------_");
                        System.out.println("2. | Listar pedidos realizados |");
                        System.out.println("    -_________________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("3. |    Registrar pedido  |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("4. |   Finalizar pedido   |");
                        System.out.println("    -____________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("5. |         Salir        |");
                        System.out.println("    -____________________-");
                        System.out.println("\n-------------------------------");
                        System.out.print("Introduce una opción: ");
                        opcGPed = s.nextLine();
                        Interaccion.cargandoBarra(10, 100);
                        switch (opcGPed) {
                            case "1" -> { // Listar pedidos pendientes
                                Interaccion.limpiaPantallash();
                                System.out.println(controlador.listarPedidosPendientes().toString().replace("[", "").replace("]", "").replace(",", ""));
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case "2" -> { // Listar pedidos realizados
                                Interaccion.limpiaPantallash();
                                System.out.println(controlador.listarPedidosRealizados().toString().replace("[", "").replace("]", "").replace(",", ""));
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case "3" -> { // Registrar pedido
                                Interaccion.limpiaPantallash();
                                if (controlador.listarArticulosConStockDisponible().isEmpty())
                                    System.out.print("No hay artículos disponibles. ");
                                else {
                                    System.out.print("Introduce la ID del cliente que ha hecho el pedido: ");
                                    String codigo = s.nextLine();
                                    if (controlador.buscaCliente(codigo) == null)
                                        System.out.println(Colores.ANSI_YELLOW + "El cliente no está registrado" + Colores.ANSI_RESET);
                                    else {
                                        if (controlador.buscaCliente(codigo).getTipo().equalsIgnoreCase("particular")) {
                                            registrarUnPedidoDeUnParticular(controlador, codigo);
                                        } else {
                                            registrarUnPedidoDeUnaEmpresa(controlador, codigo);
                                        }
                                    }
                                }
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case "4" -> { // Finalizar pedido
                                Interaccion.limpiaPantallash();
                                System.out.print("Introduce el codigo del pedido que quieres finalizar: ");
                                String codigoPedido = s.nextLine();
                                Pedido p = controlador.buscaCodigoPedido(codigoPedido);
                                if (p == null && p.getTipoEnvio().equalsIgnoreCase("fisico")) {
                                    System.out.print("No se ha podido encontrar el pedido o el pedido que has introducido ya está finalizado. ");
                                } else {
                                    System.out.print("\n\nProcesando la información del pedido");
                                    for (int i = 0; i < 3; i++) {
                                        System.out.print(".");
                                        try {
                                            TimeUnit.MILLISECONDS.sleep(355);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    System.out.println("\n\n");

                                    for (Articulo a : p.getArticulos()) {  // Quito del stock la cantidad del articulo enviado
                                        String codigo = a.getCodigo();
                                        for (Articulo ar : controlador.getArticulos()) {
                                            if (codigo.equals(ar.getCodigo())) {
                                                ar.deleteStock(a.getCantidad());
                                            }
                                        }
                                    }
                                    p.setEstado(false);
                                    System.out.println(Colores.ANSI_GREEN + "Pedido procesado" + Colores.ANSI_RESET);
                                }
                                Interaccion.pulsarTeclaContinuar();

                            }
                            case "5" -> { // Salir
                                System.out.println("Hasta pronto. ");
                                Interaccion.limpiaPantallash();
                            }
                            default -> System.out.println("Opcion incorrecta. ");
                        }
                    } while (!opcGPed.equalsIgnoreCase("5"));
                }
                case 4 -> {
                    Interaccion.limpiaPantallash();
                    int opcionfacturas = 0;
                    do {
                        System.out.println("--- Menú de gestión de facturas ---");
                        System.out.println("-------------------------------");
                        System.out.println("    _-------------------------_");
                        System.out.println("1. | Listar todas las facturas |");
                        System.out.println("    -_________________________-");
                        System.out.println("    _-----------------------------_");
                        System.out.println("2. | Listar facturas por fecha |");
                        System.out.println("    -_____________________________-");
                        System.out.println("    _-----------------------------_");
                        System.out.println("3. | Listar facturas de un cliente |");
                        System.out.println("    -_____________________________-");
                        System.out.println("    _--------------------_");
                        System.out.println("4. |         Salir        |");
                        System.out.println("    -____________________-");
                        System.out.println("-------------------------------");
                        System.out.print("Introduce una opción: ");
                        opcionfacturas = Integer.parseInt(s.nextLine());
                        Interaccion.cargandoBarra(10, 100);
                        switch (opcionfacturas) {
                            case 1 -> { // Listar todas las facturas
                                Interaccion.limpiaPantallash();

                                Collections.sort(controlador.getFacturas()); //Ordena el arraylist de facturas

                                if (controlador.getFacturas().isEmpty()) System.out.println("No hay facturas");
                                else for (Factura f : controlador.getFacturas()) System.out.println(f);
                                Interaccion.pulsarTeclaContinuar();
                            }

                            case 2 -> {
                                Interaccion.limpiaPantallash();
                                System.out.println("Ver facturas desde un mes hasta otro");
                                System.out.println("1º Fecha: ");
                                System.out.print("Introduce el año: ");
                                int anio = Integer.parseInt(s.nextLine());
                                System.out.print("Introduce el mes: ");
                                int mes = Integer.parseInt(s.nextLine());

                                System.out.println("2º Fecha: ");
                                System.out.print("Introduce el año: ");
                                int anio2 = Integer.parseInt(s.nextLine());
                                System.out.print("Introduce el mes: ");
                                int mes2 = Integer.parseInt(s.nextLine());

                                Date fecha1 = new GregorianCalendar(anio, mes, 0).getTime();
                                Date fecha2 = new GregorianCalendar(anio2, mes2, 0).getTime();
                                Interaccion.cargandoBarra(10, 100);

                                for (Factura factura : controlador.getFacturas()) {

                                    if (factura.getFecha().compareTo(fecha1) >= 0 && factura.getFecha().compareTo(fecha2) <= 0) {
                                        System.out.println(factura);
                                    }
                                }
                                Interaccion.pulsarTeclaContinuar();
                            }

                            case 3 -> { // Listar facturas de un cliente
                                Interaccion.limpiaPantallash();
                                System.out.print("Introduce la ID del cliente: ");
                                String id = s.nextLine();
                                if (controlador.buscaCliente(id) == null)
                                    System.out.println(Colores.ANSI_YELLOW + "El cliente no se ha encontrado" + Colores.ANSI_RESET);
                                else {
                                    System.out.println(controlador.buscaCliente(id).getFacturas());
                                }
                                Interaccion.pulsarTeclaContinuar();
                            }
                            case 4 -> {
                                System.out.println("Hasta pronto");
                                Interaccion.limpiaPantallash();
                            }
                        }
                    } while (opcionfacturas != 3);
                }
            }
        } while (opcion != 5);
    }

    // Función para registrar un pedido
    public static void registrarUnPedidoDeUnParticular(gestionGESTESIMAL controlador, String codigo) {
        boolean flag = false;
        String opcFisDom = "";

        System.out.println("|Artículos disponibles|");
        System.out.println(" ---------------------");

        for (Articulo a : controlador.listarArticulosConStockDisponible()) {
            //System.out.println("--------------------------" + "\nID: " + a.getCodigo() + "\nDescripción: " + a.getDescripcion() + "\nStock: " + a.getStock());
            System.out.println(a);
        }

        // Hacemos el array de articulos
        ArrayList<Articulo> temp = new ArrayList<>();
        boolean flag2 = false;


        int cantidad = 0;

        String opcCesta;
        do {
            System.out.println();
            System.out.println("\t\t\t._____.--_");
            System.out.println("\t\t\t|Cesta|--´");
            System.out.println("\t\t\t -----");
            System.out.println("\t\t\t o    o");
            System.out.println();
            System.out.println("    _-------------------------_");
            System.out.println("1. |      Añadir articulo      |");
            System.out.println("    -_________________________-");
            System.out.println("    _-------------------------_");
            System.out.println("2.  |     Borrar articulo      |");
            System.out.println("    -_________________________-");
            System.out.println("    _-------------------------_");
            System.out.println("3. |    Mostrar cesta actual   |");
            System.out.println("    -_________________________-");
            System.out.println("    _-------------------------_");
            System.out.println("4. |      Salir de la cesta    |");
            System.out.println("    -_________________________-");
            System.out.print("Elige una opción: ");
            opcCesta = s.nextLine();
            switch (opcCesta) {
                case "1" -> {
                    boolean flagEncuentraArituculoTemp = false;
                    flag2 = false;
                    while (!flag2) {
                        String tempID = "";
                        do {
                            System.out.print("Introduce la ID del artículo que ha comprado el cliente: ");
                            tempID = s.nextLine();
                        } while (controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID) == null);

                        for (Articulo a:
                                temp) {
                            if (tempID.equalsIgnoreCase(a.getCodigo())){
                                flagEncuentraArituculoTemp = true;
                                break;
                            }else flagEncuentraArituculoTemp = false;
                        }
                        if (flagEncuentraArituculoTemp) System.out.println(Colores.ANSI_RED+"Ya has metido ese artículo, si deseas mayor cantidad, borra el artículo y vuelve a meterlo"+Colores.ANSI_RESET);
                        else {
                            do {
                                System.out.print("Introduce la cantidad: ");
                                cantidad = Integer.parseInt(s.nextLine());
                                if (cantidad > controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getStock())
                                    System.out.println(Colores.ANSI_RED + "Has intentando retirar una cantidad superior al stock disponible, vuelve e intentar: " + Colores.ANSI_RESET);
                            } while (cantidad > controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getStock());

                            Articulo tempArticulo = new Articulo(tempID, controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getDescripcion(),
                                    controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getPrecioCompra(),
                                    controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getPrecioVenta() * cantidad);
                            tempArticulo.setCantidad(cantidad);
                            temp.add(tempArticulo);
                        }

                        System.out.print("¿Deseas salir? S/Cualquier otra tecla: ");
                        if (s.nextLine().equalsIgnoreCase("S")) flag2 = true;
                    }
                }
                case "2" -> {
                    String tempID = "";
                    do {
                        System.out.print("Introduce la ID del artículo que el clilente desea eliminar: ");
                        tempID = s.nextLine();
                    } while (controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID) == null);

                    Articulo tempArticulo = null;
                    for (Articulo a :
                            temp) {
                        if (a.getCodigo().equalsIgnoreCase(tempID)) {
                            tempArticulo = a;
                            break;
                        }
                    }
                    if (temp.remove(tempArticulo))
                        System.out.println(Colores.ANSI_GREEN + "Artículo eliminado de la cesta correctamente" + Colores.ANSI_RESET);
                    else
                        System.out.println(Colores.ANSI_YELLOW + "No se ha podido encontrar el artículo que se desea borrar" + Colores.ANSI_RESET);
                    System.out.print("¿Deseas salir? S/Cualquier otra tecla: ");
                    if (s.nextLine().equalsIgnoreCase("S")) flag2 = true;
                }
                case "3" -> {
                    System.out.println();
                    System.out.println("\t\tCesta actual");
                    System.out.println("\t\t------------");
                    for (Articulo a :
                            temp) {
                        System.out.println("[ ------------------------ Artículo ------------------------ ]");
                        System.out.println("| Codigo: " + a.getCodigo());
                        System.out.println("| Descripcion: " + a.getDescripcion());
                        System.out.println("| PrecioVenta: " + a.getPrecioVenta() + "€");
                        System.out.println("| Cantidad: " + a.getCantidad());
                        System.out.println("[ ---------------------------------------------------------- ]");

                    }
                }
                case "4" -> System.out.println("Has salido de la cesta");
                default -> System.out.println("Opción no válida");
            }
        } while (!opcCesta.equalsIgnoreCase("4"));

        if (temp.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "No puedes realizar un pedido sin articulos" + Colores.ANSI_RESET);
        } else {
            String opcionCancelarPedido = "";

            if (controlador.calculaImporteTotalFactura(temp) < 100) {
                System.out.print("Debido a que la compra no supera los 100€ el pedido se deberá recoger en tienda. ");
                System.out.print("¿Desea cancelar el pedido? S / N: ");
                opcionCancelarPedido = s.nextLine();
            } else {
                do {
                    System.out.print("¿El particular ha realizado una compra en físico o a domicilio? fisico / domicilio: ");
                    opcFisDom = s.nextLine();

                    switch (opcFisDom.toLowerCase()) {
                        case "fisico", "domicilio" -> {
                            System.out.print("¿Desea cancelar el pedido? S / N: ");
                            opcionCancelarPedido = s.nextLine().toLowerCase();
                            flag = true;
                        }
                        default -> System.out.println("Opción incorrecta. ");
                    }
                } while (!flag);
            }

            if (!opcionCancelarPedido.equalsIgnoreCase("s")) {
                // Si el pedido es físico, recorro el array principal de articulos comparando el codigo con el codigo del array de artículos que lleva el pedido,
                // de tal forma que si coinciden
                // Al artículo del array principal de artículos le resto del stock la cantidad del artículo de nuestro array del pedido
                if (opcFisDom.equalsIgnoreCase("fisico")) {
                    for (Articulo a : controlador.getArticulos()) {
                        for (Articulo ar : temp) {
                            if (a.getCodigo().equalsIgnoreCase(ar.getCodigo())) {
                                a.deleteStock(ar.getCantidad());
                            }
                        }
                    }
                }

                Pedido tempPedido = new Pedido(controlador.generaCodigoPedido(), controlador.buscaCliente(codigo), opcFisDom, temp);
                if (tempPedido.getTipoEnvio().equalsIgnoreCase("fisico")) {
                    tempPedido.setEstado(false);
                }
                controlador.addPedido(tempPedido);
                Factura tempFactura = new Factura(controlador.generaCodigoFactura(), controlador.calculaImporteTotalFactura(temp), tempPedido);
                controlador.addFacturaACliente(tempFactura, controlador.buscaCliente(codigo)); // Añado la factura al cliente para llevar un historial por cliente
                controlador.getFacturas().add(tempFactura); // Añado la factura a la lista general

                System.out.println(tempFactura); // Enseño la factura
                System.out.print(Colores.ANSI_GREEN + "El pedido se ha realizado con éxito." + Colores.ANSI_RESET);
            } else
                System.out.print(Colores.ANSI_GREEN + "El pedido se ha cancelado correctamente. " + Colores.ANSI_RESET);

        }

    }

    // Registrar un pedido de una empresa
    public static void registrarUnPedidoDeUnaEmpresa(gestionGESTESIMAL controlador, String codigo) {
        boolean flag = false;
        String opcFisDom = "";

        for (Articulo a : controlador.listarArticulosConStockDisponible()) {
            //System.out.println("--------------------------" + "\nID: " + a.getCodigo() + "\nDescripción: " + a.getDescripcion() + "\nStock: " + a.getStock());
            System.out.println(a);
        }

        // Hacemos el array de articulos
        ArrayList<Articulo> temp = new ArrayList<>();
        boolean flag2 = false;
        //

        int cantidad = 0;

        String opcCesta;
        do {
            System.out.println();
            System.out.println("\t\t\t._____.--_");
            System.out.println("\t\t\t|Cesta|--´");
            System.out.println("\t\t\t -----");
            System.out.println("\t\t\t o    o");
            System.out.println();
            System.out.println("    _-------------------------_");
            System.out.println("1. |      Añadir articulo      |");
            System.out.println("    -_________________________-");
            System.out.println("    _-------------------------_");
            System.out.println("2.  |     Borrar articulo      |");
            System.out.println("    -_________________________-");
            System.out.println("    _-------------------------_");
            System.out.println("3. |    Mostrar cesta actual   |");
            System.out.println("    -_________________________-");
            System.out.println("    _-------------------------_");
            System.out.println("4. |      Salir de la cesta    |");
            System.out.println("    -_________________________-");
            System.out.print("Elige una opción: ");
            opcCesta = s.nextLine();
            switch (opcCesta) {
                case "1" -> {
                    boolean flagEncuentraArituculoTemp = false;
                    flag2 = false;
                    while (!flag2) {
                        String tempID = "";

                        do {
                            System.out.print("Introduce la ID del artículo que ha comprado el cliente: ");
                            tempID = s.nextLine();
                        } while (controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID) == null);
                        for (Articulo a:
                             temp) {
                            if (tempID.equalsIgnoreCase(a.getCodigo())){
                                flagEncuentraArituculoTemp = true;
                                break;
                            }else flagEncuentraArituculoTemp = false;
                        }
                        if (flagEncuentraArituculoTemp) System.out.println(Colores.ANSI_RED+"Ya has metido ese artículo, si deseas mayor cantidad, borra el artículo y vuelve a meterlo"+Colores.ANSI_RESET);
                        else{
                            do {
                                System.out.print("Introduce la cantidad: ");
                                cantidad = Integer.parseInt(s.nextLine());
                                if (cantidad > controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getStock())
                                    System.out.println(Colores.ANSI_RED + "Has intentando retirar una cantidad superior al stock disponible, vuelve e intentar: " + Colores.ANSI_RESET);
                            } while (cantidad > controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getStock());

                            Articulo tempArticulo = new Articulo(tempID, controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getDescripcion(),
                                    controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getPrecioCompra(),
                                    controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getPrecioVenta() * cantidad);
                            tempArticulo.setCantidad(cantidad);
                            temp.add(tempArticulo);
                        }

                        System.out.print("¿Deseas salir? S/Cualquier otra tecla: ");
                        if (s.nextLine().equalsIgnoreCase("S")) flag2 = true;
                    }
                }
                case "2" -> {
                    String tempID = "";
                    do {
                        System.out.print("Introduce la ID del artículo que el clilente desea eliminar: ");
                        tempID = s.nextLine();
                    } while (controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID) == null);

                    Articulo tempArticulo = null;
                    for (Articulo a :
                            temp) {
                        if (a.getCodigo().equalsIgnoreCase(tempID)) {
                            tempArticulo = a;

                            break;
                        }
                    }
                    if (temp.remove(tempArticulo))
                        System.out.println(Colores.ANSI_GREEN + "Artículo eliminado de la cesta correctamente" + Colores.ANSI_RESET);
                    else
                        System.out.println(Colores.ANSI_YELLOW + "No se ha podido encontrar el artículo que se desea borrar" + Colores.ANSI_RESET);
                    System.out.print("¿Deseas salir? S/Cualquier otra tecla: ");
                    if (s.nextLine().equalsIgnoreCase("S")) flag2 = true;
                }
                case "3" -> {
                    System.out.println();
                    System.out.println("\t\tCesta actual");
                    System.out.println("\t\t------------");
                    for (Articulo a :
                            temp) {
                        System.out.println("[ ------------------------ Artículo ------------------------ ]");
                        System.out.println("| Codigo: " + a.getCodigo());
                        System.out.println("| Descripcion: " + a.getDescripcion());
                        System.out.println("| PrecioVenta: " + a.getPrecioVenta() + "€");
                        System.out.println("| Cantidad: " + a.getCantidad());
                        System.out.println("[ ---------------------------------------------------------- ]");

                    }
                }
                case "4" -> System.out.println("Has salido de la cesta");
                default -> System.out.println("Opción no válida");
            }
        } while (!opcCesta.equalsIgnoreCase("4"));

        /*
        String tempID = "";
        while (!flag2) {
            do {
                System.out.print("Introduce la ID del artículo que ha comprado el cliente: ");
                tempID = s.nextLine();
            } while (controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID) == null);
            int cantidad = 0;
            do {
                System.out.print("Introduce la cantidad: ");
                cantidad = Integer.parseInt(s.nextLine());

            } while (cantidad > controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getStock());

            Articulo tempArticulo = new Articulo(tempID, controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getDescripcion(),
                    controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getPrecioCompra(),
                    controlador.buscaCodigoArticulo(controlador.getArticulos(), tempID).getPrecioVenta() * cantidad);
            tempArticulo.setCantidad(cantidad);
            temp.add(tempArticulo);

            System.out.print("¿Ha terminado de comprar? S / N: ");
            if (s.nextLine().equalsIgnoreCase("S")) flag2 = true;
        }

         */

        if (temp.isEmpty()) {
            System.out.println(Colores.ANSI_RED + "No puedes realizar un pedido sin articulos" + Colores.ANSI_RESET);
        } else {
            String opcionCancelarPedido = "";

            if (controlador.calculaImporteTotalFactura(temp) < 100) {
                System.out.print("Debido a que la compra no supera los 100€ el pedido se deberá recoger en tienda. ");
                System.out.print("¿Desea cancelar el pedido? S / N: ");
                opcionCancelarPedido = s.nextLine();
            } else {
                do {
                    System.out.print("¿La empresa ha realizado una compra en físico o a domicilio? fisico / domicilio: ");
                    opcFisDom = s.nextLine();

                    switch (opcFisDom.toLowerCase()) {
                        case "fisico", "domicilio" -> {
                            System.out.print("¿Desea cancelar el pedido? S / N: ");
                            opcionCancelarPedido = s.nextLine().toLowerCase();
                            flag = true;
                        }
                        default -> System.out.println("Opción incorrecta. ");
                    }
                } while (!flag);
            }

            if (!opcionCancelarPedido.equalsIgnoreCase("s")) {
                // Si el pedido es físico, recorro el array principal de articulos comparando el codigo con el codigo del array de artículos que lleva el pedido,
                // de tal forma que si coinciden
                // Al artículo del array principal de artículos le resto del stock la cantidad del artículo de nuestro array del pedido
                if (opcFisDom.equalsIgnoreCase("fisico")) {
                    for (Articulo a : controlador.getArticulos()) {
                        for (Articulo ar : temp) {
                            if (a.getCodigo().equals(ar.getCodigo())) {
                                a.deleteStock(ar.getCantidad());
                            }
                        }
                    }
                }

                Pedido tempPedido = new Pedido(controlador.generaCodigoPedido(), controlador.buscaCliente(codigo), opcFisDom, temp);
                if (tempPedido.getTipoEnvio().equalsIgnoreCase("fisico")) {
                    tempPedido.setEstado(false);
                }
                controlador.addPedido(tempPedido);
                Factura tempFactura = new Factura(controlador.generaCodigoFactura(), controlador.calculaImporteTotalFactura(temp), tempPedido);
                controlador.addFacturaACliente(tempFactura, controlador.buscaCliente(codigo)); // Añado la factura al cliente para llevar un historial
                controlador.getFacturas().add(tempFactura);

                System.out.println(tempFactura); // Enseño la factura
                System.out.print(Colores.ANSI_GREEN + "El pedido se ha realizado con éxito." + Colores.ANSI_RESET);
            } else
                System.out.println(Colores.ANSI_GREEN + "El pedido se ha cancelado correctamente. " + Colores.ANSI_RESET);
        }
    }
}
