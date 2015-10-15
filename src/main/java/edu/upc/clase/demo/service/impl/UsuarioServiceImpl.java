package edu.upc.clase.demo.service.impl;

import edu.upc.clase.demo.dao.UsuarioDao;
import edu.upc.clase.demo.dao.impl.UsuarioDaoImpl;
import edu.upc.clase.demo.entity.Usuario;
import edu.upc.clase.demo.service.UsuarioService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gian
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static Logger log = LoggerFactory.getLogger(UsuarioDaoImpl.class);    
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Integer insertar(Usuario usuario) {
        if (usuario.getPassword().length() > 4) {
            log.info("Creando usuario");
            return usuarioDao.insertar(usuario);
        }       
        return null;
    }

    @Override
    public void actualizar(Usuario usuario) {
        log.info("Actualizando usuario");
        usuarioDao.actualizar(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        log.info("Eliminando usuario");
        usuarioDao.eliminar(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        log.info("Buscando todos los usuarios");
        return usuarioDao.buscarTodos();
    }

    @Override
    public Usuario buscar(Integer id) {
        log.info("Buscar usuario por id");
        return usuarioDao.buscar(id);
    }

    @Override
    public Boolean autenticar(String correo,String password) {
        if (correo.contains("@")) {
            Usuario user = usuarioDao.buscar(correo);
            if (user != null) {
                return user.getPassword().equals(password);
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioDao.buscarPorNombre(nombre);
    }    
}
