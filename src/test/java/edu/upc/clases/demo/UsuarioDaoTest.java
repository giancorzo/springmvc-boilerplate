package edu.upc.clases.demo;

import edu.upc.clase.demo.dao.UsuarioDao;
import edu.upc.clase.demo.entity.Usuario;
import edu.upc.clase.demo.service.UsuarioService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class UsuarioDaoTest {
    
    private static Logger log = LoggerFactory.getLogger(UsuarioDaoTest.class);
    
    @Autowired
    UsuarioDao usuarioDao;
        
    @Test
    public void testInsertarUsuario() {
        Usuario usuario = new Usuario("Giancarlo Corzo","gian.corzo@antartec.com","admin");
        Integer id = usuarioDao.insertar(usuario);
        Assert.assertNotNull(id);
    }

    /**
     * Quiero probar que despues de haber registrado un valor, lo pueda actualizar
     * Primero registro, luego grabo, luego busco, actualizo.
     */
    @Test
    public void testActualizarUsuario() {
        Usuario usuario = new Usuario("Giancarlo Corzo","gian.corzo@antartec.com","admin");
        Integer id = usuarioDao.insertar(usuario);
        usuario = usuarioDao.buscar(id);
        usuario.setNombre("Javier Corzo");
        usuarioDao.actualizar(usuario);
        usuario = usuarioDao.buscar(id);
        Assert.assertEquals("Javier Corzo", usuario.getNombre());
    }

    @Test
    public void testEliminarUsuario() {
        Usuario usuario = new Usuario("Giancarlo Corzo","gian.corzo@antartec.com","admin");
        Integer id = usuarioDao.insertar(usuario);
        usuario = usuarioDao.buscar(id);
        usuarioDao.eliminar(usuario);
        usuario = usuarioDao.buscar(id);
        Assert.assertNull(usuario);
    }

    @Test
    public void testBuscarPorLetras() {
        Usuario usuario = new Usuario("Giancarlo Corzo","gian.corzo@antartec.com","admin");
        Integer id = usuarioDao.insertar(usuario);
        usuario = usuarioDao.buscar(-8);
        Assert.assertNull(usuario);
    }
}
