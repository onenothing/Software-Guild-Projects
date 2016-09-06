/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.week6interestcalculatorlab;

import com.tsg.week6interestcalculatorlab.interest.InterestCalc;
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
@WebServlet(name = "InterestServlet", urlPatterns = {"/InterestServlet", "/"})
public class InterestServlet extends HttpServlet {

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
        //processRequest(request, response);

        RequestDispatcher rd = request.getRequestDispatcher("interest.jsp");
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
        //processRequest(request, response);

        String newAPR = request.getParameter("percentageToCalc");
        Double apr = Double.parseDouble(newAPR);
        String newPrincipal = request.getParameter("intitialPrincipal");
        Double principal = Double.parseDouble(newPrincipal);
        String investLength = request.getParameter("periodToInvest");
        int year = Integer.parseInt(investLength);
        String compoundType = request.getParameter("typeOfCompounding");
        InterestCalc.TypeOfCompounding type = InterestCalc.TypeOfCompounding.fromAbbrv(compoundType);

        InterestCalc calc = new InterestCalc(apr, principal, year, type);
        
        request.setAttribute("interestYearsCalcs", calc.getYearlyInterestCalculations());
        request.setAttribute("interestCalcError", calc.getError());
        
        doForward( request, response, "/Total.jsp");
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
    
    private void doForward( HttpServletRequest request, HttpServletResponse response, String forwardPath ) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
        rd.forward(request, response);
    }

}
