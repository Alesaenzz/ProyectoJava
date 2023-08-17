package ProduccionesPalace;

import javax.swing.JOptionPane;

import java.util.ArrayList;

import java.util.List;

class Usuario {
    private String nombreUsuario;
    
    public Usuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
}

class Evento {
    private String nombre;
    private String fecha;
    
    public Evento(String nombre, String fecha){
        this.nombre = nombre;
        this.fecha = fecha;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getFecha() {
        return fecha;
    }
}

class Reservacion {
    private Evento evento;
    private Usuario cliente;
    private String fechaHoraFacturacion;
    
    public Reservacion(Evento evento, Usuario cliente, String fechaHoraFacturacion){
        this.evento = evento;
        this.cliente = cliente;
        this.fechaHoraFacturacion = fechaHoraFacturacion;
    }
    
    public Evento getEvento() {
        return evento;
    }
    
    public Usuario getCliente() {
        return cliente;
    }
    
    public String getFechaHoraFacturacion() {
        return fechaHoraFacturacion;
    }
}

class Almacenamiento {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private List<Reservacion> reservaciones = new ArrayList<>();
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void agregarEvento(Evento evento){
        eventos.add(evento);
    }
    
public void facturar(Evento evento, Usuario cliente, String fechaHoraFacturacion){
    Reservacion reservacion = new Reservacion(evento, cliente, fechaHoraFacturacion);
    reservaciones.add(reservacion);
    
    String mensaje = "Factura generada" +
                    "\n\nCliente: " + cliente.getNombreUsuario() +
                    "\nFecha y hora de facturacion: " + fechaHoraFacturacion +
                    "\n\nEvento facturado y reservado: " + evento.getNombre() +
                    "\nDia del evento: " + evento.getFecha();
    
    JOptionPane.showMessageDialog(null, mensaje);
}
    
    public void anularFactura(Evento evento){
        Reservacion reservacionEncontrada = null;
        for (Reservacion reservacion : reservaciones){
            if (reservacion.getEvento().getNombre().equals(evento.getNombre())){
                reservacionEncontrada = reservacion;
                break;
            }
        }
        
        if (reservacionEncontrada != null){
            reservaciones.remove(reservacionEncontrada);
            JOptionPane.showMessageDialog(null, "Factura anulada para el cliente: " + reservacionEncontrada.getCliente().getNombreUsuario());
        }else{
            JOptionPane.showMessageDialog(null, "Reservacion no encontrada");
        }
    }
    
    public void mostrarEventos(){
        StringBuilder eventosTexto = new StringBuilder("Eventos almacenados:\n");
        for (Evento evento : eventos){
            eventosTexto.append("Evento: ").append(evento.getNombre()).append(" - Fecha: ").append(evento.getFecha()).append("\n");
        }
        JOptionPane.showMessageDialog(null, eventosTexto.toString());
    }
    
    public Evento obtenerEventoPorNombre(String nombreEvento){
        for (Evento evento : eventos){
            if (evento.getNombre().equals(nombreEvento)){
                return evento;
            }
        }
        return null;
    }
}

public class Modulo3Reservaciones {
    public static void main(String[] args) {
        Almacenamiento almacenamiento = new Almacenamiento();
        almacenamiento.agregarUsuario(new Usuario("ale"));
        almacenamiento.agregarEvento(new Evento("concierto", "20/10/2023"));
        
        JOptionPane.showMessageDialog(null, "Bienvenid@ al modulo de reservaciones de Producciones Palace");
        while (true){
            int menu = Integer.parseInt(JOptionPane.showInputDialog(
                "1. Facturar/reservar\n" +
                "2. Anular factura/reserva\n" +
                "3. Mostrar eventos\n" +
                "4. Salir"
            ));
            
            switch (menu){
                case 1:
                    String nombreEventoFactura = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
                    Evento eventoFactura = almacenamiento.obtenerEventoPorNombre(nombreEventoFactura);
                    if (eventoFactura != null){
                        String nombreClienteFactura = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                        String fechaHoraFactura = JOptionPane.showInputDialog("Ingrese la fecha y hora de facturacion:");
                        almacenamiento.facturar(eventoFactura, new Usuario(nombreClienteFactura), fechaHoraFactura);
                    }else{
                        JOptionPane.showMessageDialog(null, "Evento no encontrado");
                    }
                    break;
                case 2:
                    String nombreEventoAnular = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
                    Evento eventoAnular = almacenamiento.obtenerEventoPorNombre(nombreEventoAnular);
                    if (eventoAnular != null){
                        almacenamiento.anularFactura(eventoAnular);
                    }else{
                        JOptionPane.showMessageDialog(null, "Evento no encontrado");
                    }
                    break;
                case 3:
                    almacenamiento.mostrarEventos();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }
    }
}