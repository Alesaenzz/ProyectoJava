package ProduccionesPalace;

import javax.swing.JOptionPane;

import java.util.ArrayList;

import java.util.List;

class Evento {
    private String nombre;
    private String funciones;
    private String ciudad;
    private String direccion;
    private String categoria;
    private String fecha;
    private int capacidadTotal;
    private int capacidadDisponible;
    
    public Evento(String nombre, String funciones, String ciudad, String direccion, String categoria, String fecha, int capacidadTotal, int capacidadDisponible){
        this.nombre = nombre;
        this.funciones = funciones;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadDisponible;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getFunciones(){
        return funciones;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public int getCapacidadTotal(){
        return capacidadTotal;
    }
    
    public int getCapacidadDisponible(){
        return capacidadDisponible;
    }
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
        
    public void setFunciones(String funciones){
        this.funciones = funciones;
    }
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public void setCapacidadTotal(int capacidadTotal){
        this.capacidadTotal = capacidadTotal;
    }
    
    public void setCapacidadDisponible(int capacidadDisponible){
        this.capacidadDisponible = capacidadDisponible;
    }
    
    public void modificarEvento(String funciones, String ciudad, String direccion, String categoria, String fecha, int capacidadTotal, int capacidadDisponible){
        this.funciones = funciones;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadDisponible;
    }
    
    public String toString(){
        return "Nombre: " + nombre + "\n" +
               "Funciones: " + funciones + "\n" +
               "Ciudad: " + ciudad + "\n" +
               "Direccion: " + direccion + "\n" +
               "Categoria: " + categoria + "\n" +
               "Fecha: " + fecha + "\n" +
               "Capacidad total: " + capacidadTotal + "\n" +
               "Capacidad disponible: " + capacidadDisponible;
    }
}

public class Modulo2Eventos {
    private static List<Evento> eventos = new ArrayList<>();
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenid@ al modulo de eventos de Producciones Palace");
        while (true){
            int menu = Integer.parseInt(JOptionPane.showInputDialog(
                "1. Agregar evento\n" +
                "2. Ver evento\n" +
                "3. Editar evento\n" +
                "4. Inactivar evento\n" +
                "5. Salir"
            ));
            
            switch (menu){
                case 1:
                    agregarEvento();
                    break;
                case 2:
                    verEvento();
                    break;
                case 3:
                    editarEvento();
                    break;
                case 4:
                    inactivarEvento();
                    break;
                case 5:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }
    }
    
    private static void agregarEvento(){
        String nombre = JOptionPane.showInputDialog("Nombre del evento:");
        String funciones = JOptionPane.showInputDialog("Numero de funciones:");
        String ciudad = JOptionPane.showInputDialog("Ciudad:");
        String direccion = JOptionPane.showInputDialog("Direccion:");
        String categoria = JOptionPane.showInputDialog("Categoria:");
        String fecha = JOptionPane.showInputDialog("Fecha:");
        int capacidadTotal = Integer.parseInt(JOptionPane.showInputDialog("Capacidad total:"));
        int capacidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Capacidad disponible:"));
        
        Evento nuevoEvento = new Evento(nombre, funciones, ciudad, direccion, categoria, fecha, capacidadTotal, capacidadDisponible);
        eventos.add(nuevoEvento);
        
        JOptionPane.showMessageDialog(null, "Evento agregado con exito");
    }
    
    private static void verEvento(){
        String nombre = JOptionPane.showInputDialog("Nombre del evento:"); 
        
        for (Evento evento : eventos){
            if (evento.getNombre().equals(nombre)){
                JOptionPane.showMessageDialog(null, evento.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Evento no encontrado");
    }
    
    private static void editarEvento(){
        String nombre = JOptionPane.showInputDialog("Nombre del evento:");
        
        for (Evento evento : eventos){
            if (evento.getNombre().equals(nombre)){
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "Seleccione el aspecto desea editar:\n" +
                        "1. Funciones\n" +
                        "2. Ciudad\n" +
                        "3. Direccion\n" +
                        "4. Categoria\n" +
                        "5. Fecha\n" +
                        "6. Capacidad Total\n" +
                        "7. Capacidad Disponible"));
                
                switch (opcion){
                    case 1:
                        evento.setFunciones(JOptionPane.showInputDialog("Nuevo numero de funciones:"));
                        break;
                    case 2:
                        evento.setCiudad(JOptionPane.showInputDialog("Nueva ciudad:"));
                        break;
                    case 3:
                        evento.setDireccion(JOptionPane.showInputDialog("Nueva direccion:"));
                        break;
                    case 4:
                        evento.setCategoria(JOptionPane.showInputDialog("Nueva categoria:"));
                        break;
                    case 5:
                        evento.setFecha(JOptionPane.showInputDialog("Nueva fecha:"));
                        break;
                    case 6:
                        int nuevaCapacidadTotal = Integer.parseInt(JOptionPane.showInputDialog("Nueva capacidad total:"));
                        evento.setCapacidadTotal(nuevaCapacidadTotal);
                        break;
                    case 7:
                        int nuevaCapacidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Nueva capacidad disponible:"));
                        evento.setCapacidadDisponible(nuevaCapacidadDisponible);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        return;
                }
                JOptionPane.showMessageDialog(null, "Evento editado exitosamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Evento no encontrado");
    }
    
    private static void inactivarEvento(){
        String nombre = JOptionPane.showInputDialog("Nombre del evento:");
        boolean eventoEncontrado = false;
        Evento eventoAEliminar = null;
        
        for (Evento evento : eventos){
            if (evento.getNombre().equals(nombre)){
                eventoAEliminar = evento;
                eventoEncontrado = true;
                break;
            }
        }
        
        if (eventoEncontrado){
            eventos.remove(eventoAEliminar);
            JOptionPane.showMessageDialog(null, "Evento inactivado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "Evento no encontrado");
        }
    }
}