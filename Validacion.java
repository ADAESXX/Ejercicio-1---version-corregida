import java.util.Random;

public class Validacion {

    public Validacion(){

    }

    public boolean verificarTickets(int ticket) {
        Random r = new Random();
        int a = r.nextInt(15000) + 1;
        int b = r.nextInt(15000) + 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return (ticket >= min && ticket <= max);
    }

    public boolean comprobarEspacio(int localidad, int cantidad, Compra compra){
        return compra.getDisponibilidad(localidad) >= cantidad;
    }
}