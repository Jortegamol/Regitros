/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GSS_ING
 */
public class ListadoUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container-fluid'>");
            out.println("<div class='mb-3'>");
            out.println("<div class='card'");
            out.println("<div class='card-header text-center text-primary'>");
            out.println("<h1 class='card-title'>Listado de Usuarios registrados</h1>");
            out.println("</div>");
            out.println("<div class='card-body text-primary'>");
            out.println("<table class='table table-light'>");
            out.println("<tr>");
            out.println("<td>ID USUARIO</th>");
            out.println("<td>NOMBRE DEL USUARIO</th>");
            out.println("<td>APELLIDO PATERNO</th>");
            out.println("<td>APELLIDO MATERNO</th>");
            out.println("<td>ESTADO LABORAL</th>");
            out.println("<td>UBICACION</th>");
            out.println("<td>TELEFONO DE CONTACTO</th>");
            out.println("<td>CORREO</th>");
            out.println("<td>PASSOWORD</th>");
            out.println("<td colspan='2'>ACCIONES</th>");
            out.println("</tr>");
            UsuarioDAO dao = new UsuarioDAO();
            List lista;
            try {
                lista = dao.mostrarTodo();
                for (int i = 0; i < lista.size(); i++) {
                Usuario u = (Usuario) lista.get(i);    
                out.println("<tr>");
                   // out.println("<td><a href='MostrarCarrera?id="+c.getIdCarrera()+"' class='btn btn-info'>Eliminar</a>"+c.getIdCarrera()+"</td>");
                   out.println("<td>"+u.getIdUsuario()+"</td>");
                   out.println("<td>"+u.getNombre()+"</td>");
                       out.println("<td>"+u.getApPat()+"</td>");
                       out.println("<td>"+u.getApMat()+"</td>");
                       out.println("<td>"+u.getEstado()+"</td>");
                  out.println("<td>"+u.getUbicacion()+"</td>");
                       out.println("<td>"+u.getTelefono()+"</td>");
                       out.println("<td>"+u.getCorreo()+"</td>");
                       out.println("<td>"+u.getPassword()+"</td>");
                       out.println("<td><a href='EliminarUsuario?id="+u.getIdUsuario()+"' class='btn btn-danger'>Eliminar</a></td>");
                            out.println("</tr>");
            }
            } catch (SQLException ex) {
                Logger.getLogger(ListadoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<h1>Servlet Listado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
            }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
/*
    CREATE DATABASE ProjectoWeb2;
USE ProjectoWeb2;
CREATE TABLE Usuario(
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
    
    
CREATE TABLE empresa(
  idempresa INT NOT NULL AUTO_INCREMENT,
  nombreEmpresa VARCHAR(55) NOT NULL,
  CEO VARCHAR(55) NOT NULL,
  telefono VARCHAR(55) NULL,
  PRIMARY KEY (idempresa));
    */
}
