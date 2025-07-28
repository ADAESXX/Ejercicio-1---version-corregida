import java.util.*;
public class Persona{
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private float presupuesto;
    private int ticket;

    public Persona(String nombre, String email, int cantidadBoletos, float presupuesto){
        this.nombre=nombre;
        this.email=email;
        this.cantidadBoletos=cantidadBoletos;
        this.presupuesto=presupuesto;
        Random r= new Random();
        this.ticket=r.nextInt(15000)+1;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getCantidadBoletos(){
        return cantidadBoletos;
    }
    public void setCantidadBoletos(int cantidadBoletos){
        this.cantidadBoletos=cantidadBoletos;
    }
    public float getPresupuesto(){
        return presupuesto;
    }
    public void setPresupuesto(float presupuesto){
        this.presupuesto=presupuesto;
    }
    public int getTicket(){
        return this.ticket;
    }
    public String toString(){
        String cadena= "";
        cadena="Comprador: " + nombre + "\n"+ "Email: "+email + "\n" + "Cantidad de boletos comprados: " + cantidadBoletos + "\n"+"Presupuesto: " + presupuesto;
        return cadena;
    }

}