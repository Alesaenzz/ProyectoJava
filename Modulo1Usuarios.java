package ProduccionesPalace;

import javax.swing.JOptionPane;

import java.util.LinkedList;

class Usuario {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String contrasena;
    private boolean estado;
    private String correo;
    
    public Usuario(String nombre, String apellidos, String usuario, String contrasena, boolean estado, String correo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.correo = correo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String toString(){
        return "Nombre: " + nombre + " " + apellidos + "\n" +
                "Usuario: " + usuario + "\n" +
                "Estado: " + (estado ? "Activo" : "Inactivo") + "\n" +
                "Correo: " + correo;
    }
}

public class Modulo1Usuarios {
    private static LinkedList<Usuario> usuarios = new LinkedList<>();
    
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Bienvenid@ al modulo de usuarios de Producciones Palace");
        while (true){
            int menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Iniciar sesion\n" +
                    "2. Crear usuario\n" +
                    "3. Consultar usuarios\n" +
                    "4. Salir"
            ));
            
            switch (menu){
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    crearUsuario();
                    break;
                case 3:
                    consultarUsuarios();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
    
    private static void iniciarSesion(){
        String usuario = JOptionPane.showInputDialog("Usuario:");
        String contrasena = JOptionPane.showInputDialog("Contraseña:");

        for (Usuario u : usuarios){
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)){
                JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso\n" + u.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
    }
    
    private static void crearUsuario(){
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellidos = JOptionPane.showInputDialog("Apellidos:");
        String usuario = JOptionPane.showInputDialog("Usuario:");
        String contrasena = JOptionPane.showInputDialog("Contraseña:");
        String correo = JOptionPane.showInputDialog("Correo:");
        
        Usuario nuevoUsuario = new Usuario(nombre, apellidos, usuario, contrasena, true, correo);
        usuarios.add(nuevoUsuario);
        
        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
    }
    
    private static void consultarUsuarios(){
        StringBuilder listaUsuarios = new StringBuilder("Usuario    -   Nombre y Apellidos\n");
        
        for (Usuario u : usuarios){
            listaUsuarios.append(u.getUsuario()).append("   -   ").append(u.getNombre()).append(" ").append(u.getApellidos()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaUsuarios.toString());
    }
}