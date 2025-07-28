import java.util.Scanner;

public class Principal{
    public static void main(String[] args){
        Scanner teclado=new Scanner (System.in);
        Persona comprador=null;
        Validacion validar= new Validacion ();
        Compra compra= new Compra();


        //
        String menu= "Por favor seleccione la opción del menú que se acople a lo que usted desea realizar \n1. Nuevo comprador \n2.Nueva solicitud de boletos\n3. Consultar disponibilidad total\n4. Consultar disponibilidad individual\n5. Reporte caja\n6. Salir";
        System.out.println(menu);
        int opcionMenu=teclado.nextInt();
        teclado.nextLine();

        while (opcionMenu<6 && opcionMenu>0){
            switch(opcionMenu){
                case 1:
                    System.out.print("Ingrese su nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese su email: ");
                    String email = teclado.nextLine();
                    System.out.print("Ingrese la cantidad de boletos que comprará: ");
                    int cantidadBoletos = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Ingrese su presupuesto: ");
                    float presupuesto = teclado.nextFloat();
                    teclado.nextLine();
                    comprador= new Persona(nombre,email,cantidadBoletos,presupuesto);
                    System.out.println("¡Comprador creado con éxito!");
                    break;
                case 2:
                    if (comprador == null){
                        System.out.println("No hay ningún comprador registrado, por favor primero ingrese los datos del comprador en la opción 1 del menú");
                    }
                    else{
                        boolean firstcondicion=validar.verificarTickets(comprador.getTicket());
                        if (firstcondicion==true){
                            int localidad= compra.getLocalidad();
                            boolean secondcondicion=validar.comprobarEspacio(localidad, comprador.getCantidadBoletos(), compra);
                            if (secondcondicion==true){
                                float total = compra.realizarCompra(localidad, comprador);
                                if (total>0){
                                    System.out.println("Compra realizada con éxito, donde fue un total de: " + total);
                                }
                                else{
                                    System.out.println("El presupuesto no alcanza para la compra");
                                }
                            }
                            else{
                                System.out.println("Lo sentimos mucho, pero la localidad que se le asigno ya no tiene espacio alguno para realizar la compra");
                            }
                        }
                        else{
                            System.out.println("Lo sentimos mucho, pero su ticket no cumple con ciertos requisitos");
                        }
                        
                        
                    }
                    break;
                case 3:
                    compra.getDisponibilidadTotal();
                    break;
                case 4:
                    System.out.println("Ingrese la localidad de la que quiere conocer la disponibilidad (1, 5 o 10): ");
                    int loc=teclado.nextInt();
                    teclado.nextLine();
                    compra.getDisponibilidadIndividual(loc);
                    break;
                case 5:
                    System.out.println("Reporte de caja: Q" + compra.getCaja());
                    break;
            }

            System.out.println(menu);
            opcionMenu=teclado.nextInt();
            teclado.nextLine();
        }
        System.out.println("¡Gracias por haber usado el programa!");
        
    }
}