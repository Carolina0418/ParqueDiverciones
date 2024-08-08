import java.time.LocalDate;
import java.util.Scanner;

public class FacturacionParqueD {

    
      /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int vectPrecios[] = {10000, 8000, 6000, 12000,
            10000, 4000, 5000};
        String vectTipos[] = {"PE Nacional Adulto",
            "PE Nacional Niño", "PE Estudiante Nacional",
            "PE Extrajero Adulto", "PE Extrajero Niño",
            "Entrada General Nacional",
            "Entrada General Extranjero"};
        
        int contTipos [] = {0,0,0,0,0,0,0};
        int sumaEntradas [] = {0,0,0,0,0,0,0};

        String nombre;
        
        Scanner lector = new Scanner(System.in);
        int opcion, opcTipo,opcTem, precioNew, operacion, porc;
        String tipoNew;
        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case 1 -> {
                    limpiarPantalla();
                    System.out.println("-------------------------------------");
                    System.out.println("Facturación");
                    System.out.println("-------------------------------------");
                    opcTipo = menuTipos(vectTipos);
                    
                    System.out.print("Ingrese su nombre: ");
                    nombre = lector.nextLine();
                    opcTem =  menuTemporada();
                    
                    limpiarPantalla();
                    System.out.println("-------------------------------------");
                    System.out.println("Recibo de venta");
                    System.out.println("-------------------------------------");
                    System.out.println("Tipo entrada: " + vectTipos[opcTipo-1]);
                    System.out.println("Cliente: " + nombre);
                    System.out.println("Precio: " + vectPrecios[opcTipo-1]);
                    System.out.println("Temporada: " + opcTem);
                    System.out.println("-------------------------------------");
                    
                    contTipos[opcTipo-1]++;
                    sumaEntradas[opcTipo-1] = sumaEntradas[opcTipo-1] + vectPrecios[opcTipo-1];
                    System.out.println("-------------------------------------");
                    System.out.println(vectTipos[opcTipo-1]+ ": " + contTipos[opcTipo-1]);
                    System.out.println(vectTipos[opcTipo-1]+ ": " + sumaEntradas[opcTipo-1]);
                }
                case 2 -> {
                      limpiarPantalla();
                      System.out.println("-------------------------------------");
                      System.out.println("Consultar costo de entrada");
                      System.out.println("-------------------------------------");

                      opcTipo = menuTipos(vectTipos);
                      opcTem = menuTemporada(); 
                      if (opcTem == 2) { // si la temporada es Platinum
                     int precioConDescuento = (int) (vectPrecios[opcTipo - 1] * 0.75); //se aplica el descuento del 25%
                     System.out.println("Precio con descuento (Platinum): " + precioConDescuento);
                     } else {
                     // se muestra el precio sin descuento
                     System.out.println("Precio: " + vectPrecios[opcTipo - 1]);
                    }
                    break;
                }
                case 3 -> {
                    limpiarPantalla();
                    System.out.println("-------------------------------------");
                    System.out.println("Cambiar precio de entrada");
                    System.out.println("-------------------------------------");
                    opcTipo = menuTipos(vectTipos);
                    System.out.println("Precio Anterior: " + vectPrecios[opcTipo - 1]);
                    System.out.println("Ingrese el nuevo precio");
                    precioNew = lector.nextInt();

                    vectPrecios[opcTipo - 1] = precioNew;
                    System.out.println("-------------------------------------");
                    System.out.println("Precio Actualizado!!!");
                    lector.nextLine();
                }
                case 4 -> {
                    limpiarPantalla();
                    System.out.println("-------------------------------------");
                    System.out.println("Cambiar Tipo de Cliente");
                    System.out.println("-------------------------------------");
                    opcTipo = menuTipos(vectTipos);
                    System.out.println("Tipo Cliente Anterior: " + vectTipos[opcTipo - 1]);
                    System.out.print("Nuevo Tipo de cliente: ");
                    tipoNew = lector.nextLine();

                    vectTipos[opcTipo - 1] = tipoNew;
                    System.out.println("-------------------------------------");
                    System.out.println("Precio Actualizado!!!");
                    lector.nextLine();
                }
                case 5 -> {
                    limpiarPantalla();
                    System.out.println("Parque Nacional de Diversiones");
                    System.out.println("     Listado de Precios");
                    System.out.println("-------------------------------------");
                    System.out.println("Tipo de Cliente\t\tPrecio");
                    System.out.println("-------------------------------------");
                    for (int x = 0; x < vectPrecios.length; x++) {
                        System.out.print(vectTipos[x]);
                        System.out.println("\t\t" + vectPrecios[x]);
                    }
                    System.out.println("-------------------------------------");
                }
                case 6 -> {
                    limpiarPantalla();
                    System.out.println("-------------------------------------");
                    System.out.println("Aumento o rebajas de precios");
                    System.out.println("-------------------------------------");
                    System.out.println("Elija la operación");
                    System.out.println("-----------------------");
                    System.out.println("1. Aumento General");
                    System.out.println("2. Rebaja General");
                    System.out.println("-----------------------");
                    System.out.print("Opción: ");
                    operacion = lector.nextInt();

                    switch (operacion) {
                        case 1 -> {
                            System.out.print("Porcentaje de Aumento: ");
                        }
                        case 2 -> {
                            System.out.print("Porcentaje de Rebaja: ");
                        }
                    }
                    porc = lector.nextInt();
                    for (int x = 0; x < vectPrecios.length; x++) {
                        switch (operacion) {
                            case 1->{
                                //Aumento
                                vectPrecios[x] = (int) (vectPrecios[x] + (vectPrecios[x] * (porc / 100.00)));
                            }
                            case 2 -> {
                               //Rebaja
                                vectPrecios[x] = (int) (vectPrecios[x] - (vectPrecios[x] * (porc / 100.00)));
                            }                      
                        }
                    }

                    System.out.println("Se ha actulizado los precios");
                    lector.nextLine();

                }
                case 7 -> {
                      limpiarPantalla();
                     System.out.println("-------------------------------------");
                     System.out.println("Resumen de ventas del día");
                     System.out.println("-------------------------------------");
                     // Título del reporte
                     System.out.println("Título del reporte: Resumen de ventas del día");
                     // Fecha (puedes obtenerla utilizando la clase LocalDate de Java)
                     LocalDate fecha = LocalDate.now();
                     System.out.println("Fecha: " + fecha);
                     // Cantidad total de personas que han ingresado al parque
                     int totalPersonas = 0;
                     for (int cantidad : contTipos) {
                         totalPersonas += cantidad;
                     }
                     System.out.println("Cantidad total de personas que han ingresado al parque: " + totalPersonas);
                     // Monto recaudado desglosado por tipo de cliente
                     System.out.println("Monto recaudado desglosado por tipo de cliente:");
                     for (int i = 0; i < vectTipos.length; i++) {
                         System.out.println(vectTipos[i] + ": " + sumaEntradas[i]);
                     }
                     // Monto total recaudado
                     int montoTotal = 0;
                     for (int monto : sumaEntradas) {
                         montoTotal += monto;
                     }
                     System.out.println("Monto total recaudado: " + montoTotal);
                     break;
                }
                case 8 -> {
                    System.out.println("Programado por:");
                    System.out.println("Fulano de Tal");
                    lector.nextLine();
                }
                case 9 -> {
                    System.out.println("Ha salido correctamente del sistema");
                }
                default -> {
                    System.out.println("Opción inválida");
                }

            } //Fin del switch
            lector.nextLine();  //Esperar tecla
            limpiarPantalla();
        } while (opcion != 9);
    }

    public static int menuTipos(String vect[]) {
        int opc;
        Scanner lector = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("  Seleccione el tipo de cliente");
        System.out.println("--------------------------------");
        for (int x = 0; x < vect.length; x++) {
            System.out.println((x + 1) + ". " + vect[x]);
        }
        System.out.println("--------------------------------");
        System.out.print("Opción: ");
        opc = lector.nextInt();
        System.out.println("--------------------------------");
        return opc;
    }

    public static int mostrarMenu() {
        int opc;
        Scanner lector = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("         Menú Principal");
        System.out.println("--------------------------------");
        System.out.println("1. Facturar entrada");
        System.out.println("2. Consultar costo entrada");
        System.out.println("3. Cambiar costo entrada");
        System.out.println("4. Cambiar tipo cliente");
        System.out.println("5. Mostrar tarifas ");
        System.out.println("6. Aumento o rebajas de entradas");
        System.out.println("7. Resumen de ventas");
        System.out.println("8. Acerca de ...");
        System.out.println("9. Salir");
        System.out.println("--------------------------------");
        System.out.print("Opción: ");
        opc = lector.nextInt();
        System.out.println("--------------------------------");
        return opc;
    }

    public static void limpiarPantalla() {
        for (int x = 0; x < 50; x++) {
            System.out.println("");
        }
    }
    
 private static int  menuTemporada() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nSubmenú Temporada");
    System.out.println("1. Temporada Gold");
    System.out.println("2. Temporada Platinum");
    System.out.println("3. Regresar al menú principal");
    System.out.print("Seleccione una opción: ");
    int opcTem = scanner.nextInt();

    switch (opcTem) {
        case 1 -> System.out.println("Has seleccionado la Temporada Gold.");
           
        case 2 -> System.out.println("Has seleccionado la Temporada Platinum.");
            
        case 3 -> System.out.println("Regresando al menú principal...");
        
        default -> System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 3.");
    }
        return opcTem;
}
 
 
 

 
}

  

   
   

