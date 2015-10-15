
package edu.upc.clases.demo;

import edu.upc.clase.demo.entity.Usuario;
import edu.upc.clase.demo.service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author operador
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-base-test.xml")
@Transactional
public class UsuarioServiceTest {

    private static Logger log = LoggerFactory.getLogger(UsuarioServiceTest.class);

    @Autowired
    private UsuarioService usuarioService;
    
    @Test
    public void testAutenticarPasswordVacio() {
        Assert.assertEquals(false,usuarioService.autenticar("gian.corzo@antartec.com",""));
    }

    @Test
    public void testAutenticarMinimo() {
        Usuario usuario = new Usuario("Giancarlo Corzo","gian.corzo@antartec.com","ad");
        Integer id = usuarioService.insertar(usuario);
        Assert.assertNull(id);
    }

    @Test
    public void testAutenticarElCorreoTieneFormatoAdecuado() {
        Usuario usuario = new Usuario("Giancarlo Corzo","gian.antartec.com","admin");
        usuarioService.insertar(usuario);
        Assert.assertEquals(false,usuarioService.autenticar("gian.antartec.com","admin"));
    }    
}
