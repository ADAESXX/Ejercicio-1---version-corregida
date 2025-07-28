import java.util.*;
public class Compra{

    private int disponiblesL1 = 20;
    private int disponiblesL2 = 20;
    private int disponiblesL3 = 20;
    private float caja = 0;

    public Compra(){

    }

    public int getLocalidad(){
        Random r= new Random();
        int [] localidades = {1,5,10};
        return localidades[r.nextInt(3)];
    }

    public float realizarCompra (int localidad, Persona comprador){
        int precio=0;
        switch (localidad) {
            case 1:
                precio=100;
                break;
            case 5:
                precio=500;
                break;
            case 10:
                precio=1000;
                break;
        }

        int disponibles = getDisponibilidad(localidad);
        int solicitados = comprador.getCantidadBoletos();
        int boletosPermitidos=Math.min(disponibles, solicitados);
        float total= boletosPermitidos*precio;
        if (comprador.getPresupuesto()>=total && boletosPermitidos>0){
            venderBoletos(localidad, boletosPermitidos);
            caja+=total;
            System.out.println("Se vendieron " + boletosPermitidos + "boletos");
            return total;
        }
        System.out.println("No se pudo realizar la compra");
        return 0;
        
    }

    public void venderBoletos(int localidad, int cantidad){
        switch(localidad){
            case 1:
                disponiblesL1-=cantidad;
                break;
            case 5:
                disponiblesL2-=cantidad;
                break;
            case 10:
                disponiblesL3-=cantidad;
                break;
        }
    }

    public int getDisponibilidad(int localidad) {
        switch (localidad) {
            case 1:
                 return disponiblesL1;
            case 5:
                return disponiblesL2;
            case 10:
                return disponiblesL3;
            default:
                return 0;
            
        }
    }

    public void getDisponibilidadTotal(){
        System.out.println("Localidad 1 disponibles: " + disponiblesL1);
        System.out.println("Localidad 5 disponibles: " + disponiblesL2);
        System.out.println("Localidad 10 disponibles: " + disponiblesL3);
    }
    public void getDisponibilidadIndividual(int localidad){
        System.out.println("Disponibilidad: " + getDisponibilidad(localidad));
    }

    public float getCaja() {
        return caja;
    }
}