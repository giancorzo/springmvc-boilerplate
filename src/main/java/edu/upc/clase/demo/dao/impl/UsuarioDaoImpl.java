package edu.upc.clase.demo.dao.impl;

import edu.upc.clase.demo.dao.UsuarioDao;
import edu.upc.clase.demo.entity.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gian
 */
@Repository
public class UsuarioDaoImpl extends SimpleJdbcDaoSupport implements UsuarioDao {

    private static Logger log = LoggerFactory.getLogger(UsuarioDaoImpl.class);

    @Autowired
    public UsuarioDaoImpl(DataSource dataSource) {
        log.info("Asignando el dataSource");
        setDataSource(dataSource);
    }

    @Override
    public Integer insertar(Usuario usuario) {

        getJdbcTemplate().update(
                "insert into usuarios (nombre,correo,password) values (?, ?, ?)",
                usuario.getNombre(), usuario.getCorreo(), usuario.getPassword());
        return getSimpleJdbcTemplate().queryForInt("select last_insert_id()");
    }

    @Override
    public void actualizar(Usuario usuario) {
        getJdbcTemplate().update(
                "update usuarios set nombre = ?, correo = ? where id = ?",
                usuario.getNombre(), usuario.getCorreo(), usuario.getId());
    }

    @Override
    public void eliminar(Usuario usuario) {
        getJdbcTemplate().update(
                "delete from usuarios where id = ?", usuario.getId());
    }

    @Override
    public Usuario buscar(Integer id) {
        try {
            return getSimpleJdbcTemplate().queryForObject(
                    "select id, nombre, correo,password from usuarios where id=?",
                    new BeanPropertyRowMapper<Usuario>(Usuario.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                "select id,nombre,correo,password from usuarios",
                new BeanPropertyRowMapper<Usuario>(Usuario.class));
    }

    @Override
    public Usuario buscar(String correo) {
        try {
            return getSimpleJdbcTemplate().queryForObject(
                    "select id, nombre, correo,password from usuarios where correo=?",
                    new BeanPropertyRowMapper<Usuario>(Usuario.class), correo);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        try {
            Map<String,String> parametros = new HashMap<String,String>();
            parametros.put("nombre","%"+nombre+"%");
            return getSimpleJdbcTemplate().query(
                    "select * from usuarios where nombre like :nombre",
                    new BeanPropertyRowMapper<Usuario>(Usuario.class),parametros);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}