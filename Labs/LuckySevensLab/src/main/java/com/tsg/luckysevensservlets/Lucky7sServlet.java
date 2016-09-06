/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.luckysevensservlets;

import com.tsg.luckysevensservlets.dto.Lucky7Vars;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
@WebServlet(name = "Lucky7sServlet", urlPatterns = {"/Lucky7sServlet"})
public class Lucky7sServlet extends HttpServlet {

    int startBet;
    private Lucky7Vars stats;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lucky7sServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Lucky7sServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);

        RequestDispatcher rd = request.getRequestDispatcher("LuckyGame.jsp");
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

        startBet = (Integer.parseInt(request.getParameter("myRolls")));

        rollDice(startBet);

        int rolls = stats.getTotalRolls();
        int bestRoll = stats.getMaxDollarRolls();
        int bestBet = stats.getMaxDollars();

        request.setAttribute("startBet", startBet);
        request.setAttribute("rolls", rolls);
        request.setAttribute("bestRoll", bestRoll);
        request.setAttribute("bestBet", bestBet);

        RequestDispatcher rd = request.getRequestDispatcher("Response.jsp");
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

    public void rollDice(int dollars) {
        
        stats = new Lucky7Vars();

        int dieTotal;
        Random die1 = new Random();
        Random die2 = new Random();
        stats.setMaxDollars(dollars);
        stats.setMaxDollarRolls(0);
        stats.setTotalRolls(0);

        while (dollars > 0) {
            dieTotal = (die1.nextInt(6) + 1) + (die2.nextInt(6) + 1);
            stats.setTotalRolls(stats.getTotalRolls());

            if (dieTotal == 7) {
                dollars += 4;

                if (dollars > stats.getMaxDollarRolls()) {
                    stats.setMaxDollars(dollars);
                    stats.setMaxDollarRolls(stats.getTotalRolls());
                }

            } else {
                dollars -= 1;
            }
        }

    }

}
