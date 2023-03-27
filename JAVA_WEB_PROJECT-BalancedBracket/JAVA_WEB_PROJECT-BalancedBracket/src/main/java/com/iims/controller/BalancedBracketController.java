package com.iims.controller;

import com.iims.util.BalancedBracket;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "balancedBracket", urlPatterns = "/balancedBracket")
public class BalancedBracketController extends HttpServlet {

    /**
     * It takes the expression from the index.jsp page and sends it to the BalancedBracket class. Then it checks if the
     * output is "Yes" or "No" and redirects to the appropriate page
     *
     * @param req The request object represents the HTTP request and contains the query string, form data, and headers.
     * @param resp This is the response object that is used to send the response to the client.
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, IOException {
        PrintWriter out = resp.getWriter();
        String expression = req.getParameter("expression");
        String output = BalancedBracket.isBalanced(expression);
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        if (output.equals("Yes")) {
            resp.sendRedirect("ans.jsp");
        } else if (output.equals("No")) {
            resp.sendRedirect("error.jsp");
        }

        out.println(output);
    }

}
