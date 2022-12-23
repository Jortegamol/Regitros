/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprueba;

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
 *
 * @author guill
 */
public class EmpresaDAO {
    
    private static final String SQL_INSERTAR
            = "insert into Empresa(nombreEmpresa, CEO, telefono) values (?, ?, ?)";
    private static final String SQL_UPDATE
            = "update Empresa set nombreempresa = ?, CEO = ?, telefono = ? where idEmpresa = ?";
    private static final String SQL_DELETE = "delete from Empresa where idempresa =?";
    private static final String SQL_SELECT = "select * from empresa where idempresa =?";
    private static final String SQL_SELECT_ALL = "select * from Empresa";
    
    private Connection con;

    private void obtenerConexion() {
        String usuario = "root";
        String clave = "ulises.123";
        String url = "jdbc:mysql://localhost:3306/ProjectoWeb2";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarEmpresa(Empresa e) throws SQLException {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_INSERTAR);
            ps.setString(1, e.getNombreEmpresa());
            ps.setString(2, e.getCEO());
            ps.setString(3, e.getTelefono());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void eliminarEmpresa(Empresa e) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, e.getIdEmpresa());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public List mostrarEmpresas() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            Empresa e = new Empresa();
            e.setIdEmpresa(rs.getInt("idempresa"));
            e.setNombreEmpresa(rs.getString("nombreEmpresa"));
            e.setCEO(rs.getString("CEO"));
            e.setTelefono(rs.getString("telefono"));
            resultados.add(e);
        }
        return resultados;
    }
    
}
