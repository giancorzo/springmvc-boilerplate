package edu.upc.clase.demo.dao;

import edu.upc.clase.demo.entity.Usuario;
import java.util.List;

/**
 *
 * @author gian
 */
public interface UsuarioDao {
    public Integer insertar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> buscarTodos();
    public Usuario buscar(Integer id);
    public Usuario buscar(String correo);
    public List<Usuario> buscarPorNombre(String nombre);
}
