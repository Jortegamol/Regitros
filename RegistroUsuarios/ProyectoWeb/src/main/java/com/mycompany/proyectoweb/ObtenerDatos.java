/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class ObtenerDatos extends HttpServlet {

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
     String nombre = request.getParameter("nombre");
             String apPat = request.getParameter("apPat");
              String apMat = request.getParameter("apMat");
               String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");
                 String genero = request.getParameter("genero");
                 String estado = request.getParameter("estado");
                 String ubicacion = request.getParameter("ubicacion");
                 String password = request.getParameter("clave");
                 int estadoint = Integer.parseInt(estado);
       response.setContentType("text/HTML;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              System.out.println("lolololo");
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ObtenerDatos</title>");            
            out.println("</head>");
            out.println("<body>");
           UsuarioDAO dao= new UsuarioDAO();
           Usuario u = new Usuario();
             u.setNombre(nombre);
           u.setApMat(apMat);
           u.setApPat(apPat);
           u.setTelefono(telefono);
           u.setEstado(estadoint);
           u.setGenero(genero);
           u.setUbicacion(ubicacion);
           u.setCorreo(correo);
           u.setPassword(password);
           dao.insertarCarrera(u);

          // Usuario u = new Usuario(nombre,apPat,apMat,genero,estadoint, ubicacion, telefono,correo,password);   
           dao.insertarCarrera(u);
           out.println("</body>");
            out.println("</html>"); 
            out.close();
         } catch (SQLException ex) {
               Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
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
       String nombre = request.getParameter("nombre");
             String apPat = request.getParameter("apPat");
              String apMat = request.getParameter("apMat");
               String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");
                 String genero = request.getParameter("genero");
                 String estado = request.getParameter("estado");
                 String ubicacion = request.getParameter("ubicacion");
                 String password = request.getParameter("clave");
                 int estadoint = Integer.parseInt(estado);
       response.setContentType("text/HTML;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ObtenerDatos</title>");            
            out.println("</head>");
            out.println("<body>");
           UsuarioDAO dao= new UsuarioDAO();
           Usuario u = new Usuario();
           u.setNombre(nombre);
           u.setApMat(apMat);
           u.setApPat(apPat);
           u.setTelefono(telefono);
           u.setEstado(estadoint);
           u.setGenero(genero);
           u.setUbicacion(ubicacion);
           u.setCorreo(correo);
           u.setPassword(password);
           dao.insertarCarrera(u);
           out.println("</body>");
            out.println("</html>"); 
            out.close();
         } catch (SQLException ex) {
               Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
           }
        
 
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
        
             String nombre = request.getParameter("nombre");
             String apPat = request.getParameter("apPat");
              String apMat = request.getParameter("apMat");
               String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");
                 String genero = request.getParameter("genero");
                 String estado = request.getParameter("estado");
                 String ubicacion = request.getParameter("ubicacion");
                 String password = request.getParameter("clave");
                 int estadoint = Integer.parseInt(estado);
       response.setContentType("text/HTML;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              System.out.println("lolololo");
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ObtenerDatos</title>");            
            out.println("</head>");
            out.println("<body>");
           UsuarioDAO dao= new UsuarioDAO();
           Usuario u = new Usuario();   
            u.setNombre(nombre);
           u.setApMat(apMat);
           u.setApPat(apPat);
           u.setTelefono(telefono);
           u.setEstado(estadoint);
           u.setGenero(genero);
           u.setUbicacion(ubicacion);
           u.setCorreo(correo);
           u.setPassword(password);
           dao.insertarCarrera(u);

           dao.insertarCarrera(u);
           out.println("</body>");
            out.println("</html>"); 
            out.close();
         } catch (SQLException ex) {
               Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
           }
        
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

}
