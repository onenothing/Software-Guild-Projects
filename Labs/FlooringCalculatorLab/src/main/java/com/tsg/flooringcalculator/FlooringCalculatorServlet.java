/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.flooringcalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@WebServlet(name = "FlooringCalculatorServlet", urlPatterns = {"/FlooringCalculatorServlet","/"})
public class FlooringCalculatorServlet extends HttpServlet {

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
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
        
        String newWidth = request.getParameter("width");
        Double width = Double.parseDouble(newWidth);
        String newLength = request.getParameter("length");
        Double length = Double.parseDouble(newLength);
        String newCost = request.getParameter("costSqFt");
        Double costPerSqFt = Double.parseDouble(newCost);

        FlooringCalculator floorCalc = new FlooringCalculator(width, length, costPerSqFt);
        
        double newArea = floorCalc.getArea(width, length);
        double newMatCost = floorCalc.getMateialCost(newArea, costPerSqFt);
        double newLaborCost = floorCalc.getLaborRate();
        double newTotal = floorCalc.getOrderTotal(newLaborCost, newMatCost);
        double totalTime = newArea / 20;

        request.setAttribute("newMatCost", newMatCost);
        request.setAttribute("newLaborCost", newLaborCost);
        request.setAttribute("newArea", newArea);
        request.setAttribute("newTotal", newTotal);
        request.setAttribute("totalTime", totalTime);

        RequestDispatcher rd = request.getRequestDispatcher("outcome.jsp");
        rd.forward(request, response);
        

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
