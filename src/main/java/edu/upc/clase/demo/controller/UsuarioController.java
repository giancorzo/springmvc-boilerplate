package edu.upc.clase.demo.controller;

import edu.upc.clase.demo.entity.Credential;
import edu.upc.clase.demo.entity.CriterioBusqueda;
import edu.upc.clase.demo.entity.JsonResponse;
import edu.upc.clase.demo.entity.Usuario;
import edu.upc.clase.demo.service.UsuarioService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gian
 */
@Controller("usuarioController")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private static Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @RequestMapping("/usuarios/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("usuarios/index");
        List<Usuario> usuarios = usuarioService.buscarTodos();
        CriterioBusqueda criterioBusqueda = new CriterioBusqueda();
        mav.addObject("usuarios", usuarios);
        mav.addObject("criterioBusqueda",criterioBusqueda);
        return mav;
    }
    
    @RequestMapping(value = "/usuarios/new", method = RequestMethod.GET)
    public ModelAndView newUsuario() {
        ModelAndView mav = new ModelAndView("usuarios/new");
        Usuario usuario = new Usuario();
        mav.getModelMap().put("usuario", usuario);
        return mav;
    }

    @RequestMapping(value = "/usuarios/new", method = RequestMethod.POST)
    public String createUsuario(@ModelAttribute("usuario")Usuario usuario, 
                                SessionStatus status,
                                HttpServletRequest request) {
        
        usuarioService.insertar(usuario);
        
        //Como guardar un archivo
        try {
            MultipartFile avatar = usuario.getAvatar();

            if (avatar.getSize() > 0) {
                File dir = new File(request.getSession().getServletContext().getRealPath("") 
                                       + "/upload/");
                
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File destinationFile = new File(request.getSession().getServletContext().getRealPath("") 
                                       + "/upload/"+ avatar.getOriginalFilename());
                avatar.transferTo(destinationFile);
                             
            }
        } catch (IOException iOException) {
            log.error("No se pudo guardar la imagen");
        }
        
        status.setComplete();

        return "redirect:/pages/usuarios/index";
        
    }
    
    @RequestMapping(value = "/usuarios/edit", method = RequestMethod.GET)
    public ModelAndView editUsuario(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("usuarios/edit");
        Usuario usuario = usuarioService.buscar(id);
        mav.getModelMap().put("usuario", usuario);
        return mav;        
    }
    
    @RequestMapping(value="/usuarios/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("usuario") Usuario usuario, SessionStatus status) {
        usuarioService.actualizar(usuario);
        status.setComplete();
        return "redirect:/pages/usuarios/index";
    }
    
    @RequestMapping("/usuarios/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/usuarios/index");
        Usuario usuario = usuarioService.buscar(id);
        usuarioService.eliminar(usuario);
        return mav;
    }
    
    @RequestMapping("/usuarios/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("usuarios/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
    @RequestMapping(value = "/usuarios/autenticar", method=RequestMethod.POST)
    public String autenticar(@ModelAttribute("credential") Credential credential,HttpServletRequest request) {
        if (usuarioService.autenticar(credential.getCorreo(), credential.getPassword())) {
            request.getSession().setAttribute("credential",credential);
            return "redirect:/pages/usuarios/index";
        }
        return "redirect:/pages/usuarios/login";
    }
    
    @RequestMapping("/usuarios/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/usuarios/login";
    }        
    
    
    @RequestMapping(value = "/usuarios/buscar", method=RequestMethod.POST)
    public ModelAndView buscar(@ModelAttribute("criterioBusqueda") CriterioBusqueda criterio, SessionStatus status) {
        ModelAndView mav = new ModelAndView("usuarios/resultadoBusqueda");
        log.info("resultado = " + usuarioService.buscarPorNombre(criterio.getNombre()).size());
        mav.getModel().put("resultado",usuarioService.buscarPorNombre(criterio.getNombre()));
        return mav;
    }
    
    @RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse listMyFiles() {
        List<Usuario> usuarios = usuarioService.buscarTodos();
        return new JsonResponse(true, usuarios);
    }
    
}
