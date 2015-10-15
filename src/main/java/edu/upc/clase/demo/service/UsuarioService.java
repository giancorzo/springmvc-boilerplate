package edu.upc.clase.demo.service;

import edu.upc.clase.demo.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    public Integer insertar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> buscarTodos();
    public Usuario buscar(Integer id);
    public List<Usuario> buscarPorNombre(String nombre);
    public Boolean autenticar(String correo,String password);    
}