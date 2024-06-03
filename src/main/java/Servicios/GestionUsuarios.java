package Servicio;

import paciente.Usuario;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    private Map<String, Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(String rut, String contrasena) {
        if (!usuarios.containsKey(rut)) {
            Usuario usuario = new Usuario(rut, contrasena);
            usuarios.put(rut, usuario);
        } else {
            System.out.println("El usuario ya está registrado.");
        }
    }

    public Usuario iniciarSesion(String rut, String contrasena) {
        Usuario usuario = usuarios.get(rut);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
            return null;
        }
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
