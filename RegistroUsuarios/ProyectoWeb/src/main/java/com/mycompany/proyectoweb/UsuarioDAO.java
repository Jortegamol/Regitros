/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *CREATE TABLE Usuario(
  idUsuario INT NOT NULL AUTO_INCREMENT,
  nombreUsuario VARCHAR(50) NOT NULL,
  pass VARCHAR(50) NOT NULL,
  apPat VARCHAR(50) NOT NULL,
  apMat VARCHAR(50) NOT NULL,
  genero VARCHAR(50) NOT NULL,
  telefono VARCHAR(12) NOT NULL,
  ubicacion VARCHAR(100) NOT NULL,
  estado TINYINT NOT NULL,
  correo VARCHAR(50) NOT NULL,
  PRIMARY KEY (idusuario));

 */
public class UsuarioDAO {
    private static final String SQL_INSERTAR="insert into Usuario(nombreUsuario, pass, apPat, apMat, genero, telefono, ubicacion, estado, correo) values(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update Usuario set nombreUsuario = ?,pass = ?, apPat = ?, apMat = ?, genero= ?, telefono= ?, ubicacion= ?, estado = ?, correo =? where idUsuario = ?";
    private static final String SQL_DELETE =  "delete from Usuario where idUsuario = ?";
    private static final String SQL_SELECT = "select * from Usuario where idUsuario = ?";
    private static final String SQL_SELECT_ALL = "select * from Usuario";
    
    private Connection con;
    
    private void obtenerConexion()
    {
        String usuario = "root";
        String clave ="ulises.123";
        String url = "jdbc:mysql://localhost:3306/ProjectoWeb2";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo conectar :c");
        }
    }
    
    public void insertarCarrera(Usuario u) throws SQLException{
        PreparedStatement ps = null; //acceso a datos
        obtenerConexion();
        try{
            ps=con.prepareStatement(SQL_INSERTAR);//PREPARAR LA CONSULTA
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getApPat());
            ps.setString(4, u.getApMat());
            ps.setString(5, u.getGenero());
            ps.setString(6, u.getTelefono());
            ps.setString(7, u.getUbicacion());
            ps.setInt(8, u.getEstado());
            ps.setString(9, u.getCorreo());
            ps.executeUpdate();
  
        }finally
        {
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
        
      
    }
    
    public void actualizarCarrera(Usuario u) throws SQLException
    {
        obtenerConexion();
        PreparedStatement ps = null; //Prepara las consultas;
        try
        {
            ps= con.prepareStatement(SQL_UPDATE);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getApPat());
            ps.setString(4, u.getApMat());
            ps.setString(5, u.getGenero());
            ps.setString(6, u.getTelefono());
            ps.setString(7, u.getUbicacion());
            ps.setInt(8, u.getEstado());
            ps.setString(9, u.getCorreo());
            ps.setInt(9, u.getIdUsuario());
            ps.executeUpdate();
        }finally
        {
             if(ps != null) ps.close();
            if(con != null) con.close();      
        }
    }
    
    
    public void eliminarCarrera(Usuario u) throws SQLException
    {
        obtenerConexion();
        PreparedStatement ps = null; //Prepara las consultas;
        try
        {
            ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1,u.getIdUsuario() );
            ps.executeUpdate();
        }finally
        {
             if(ps != null) ps.close();
            if(con != null) con.close();      
        }
    }
    
    public List mostrarTodo() throws SQLException
    {
        obtenerConexion();
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs= ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() >0) {
                return resultados;
            }
            else
            {
                return null;
            }
        }finally
        {
            if(rs!= null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();   
        }
    }
    
    
    public Usuario MostrarUno(Usuario u) throws SQLException{
        obtenerConexion();
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
            rs= ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return (Usuario) resultados.get(0);
            }
            else
            {
                return null;
            }
            }
        finally{
            if(rs!= null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close(); 
        }
  
}

    
    public static void main(String[] args) {
        Usuario u = new Usuario();
      //  c.setIdCarrera(2);
       
        
        
        //c.setIdCarrera(2)
        UsuarioDAO dao= new UsuarioDAO();
        try {
           dao.insertarCarrera(u);
          // dao.actualizarCarrera(c);
          //dao.eliminarCarrera(c);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    private List obtenerResultados(ResultSet rs) throws SQLException{
       List resultados = new ArrayList();
       while(rs.next())
       {
           Usuario u = new Usuario();
           u.setIdUsuario(rs.getInt("IdUsuario"));
           u.setNombre(rs.getString("nombreUsuario"));
           u.setApPat(rs.getString("apPat"));
           u.setApMat(rs.getString("apMat"));
           u.setEstado(rs.getInt("estado"));
           u.setUbicacion(rs.getString("ubicacion"));
           u.setTelefono(rs.getString("telefono"));
           u.setCorreo(rs.getString("correo"));
           u.setPassword(rs.getString("pass"));
           resultados.add(u);
       }
       
       return resultados;
    }
 
}
