/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoprueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guill
 */
@WebServlet(name = "AgregarEmpresa", urlPatterns = {"/AgregarEmpresa"})
public class AgregarEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            String nomEmp = request.getParameter("nom");
            String ceo =  request.getParameter("ceo");
            String tel = request.getParameter("tel");
            EmpresaDAO emp =  new EmpresaDAO();
            Empresa e = new Empresa();
            e.setNombreEmpresa(nomEmp);
            e.setCEO(ceo);
            e.setTelefono(tel);
            emp.insertarEmpresa(e);
            out.println("<div class=\"alert alert-danger\" role=\"alert\">\n  A simple danger alert—check it out!\n</div>");
            out.println("<a href='Listado'>Listado</a>");
            
            out.println("<h1>Servlet AgregarEmpresa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(AgregarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
        
            String nomEmp = request.getParameter("nom");
            String ceo =  request.getParameter("ceo");
            String tel = request.getParameter("tel");
       // processRequest(request, response);
         response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            EmpresaDAO emp =  new EmpresaDAO();
            Empresa e = new Empresa();
            e.setNombreEmpresa(nomEmp);
            e.setCEO(ceo);
            e.setTelefono(tel);
            emp.insertarEmpresa(e);
            out.println("<div class=\"alert alert-danger\" role=\"alert\">\n  A simple danger alert—check it out!\n</div>");
            out.println("<a href='Listado'>Listado</a>");
            out.println("<h1>Servlet AgregarEmpresa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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

}
