package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class QuoteServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Цитата Линуса Торвальдса</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
        out.println(".quote { font-size: 24px; font-style: italic; margin: 20px 0; padding: 20px; background-color: #f5f5f5; border-left: 5px solid #4CAF50; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Цитата Линуса Торвальдса</h1>");
        out.println("<div class='quote'>");
        out.println("Bad programmers worry about the code. Good programmers<br>");
        out.println("worry about data structures and their relationships");
        out.println("</div>");
        out.println("<br>");
        out.println("<a href='/J_Lesson11/max'>Задание 2: Максимум из 3 чисел</a><br>");
        out.println("<a href='/J_Lesson11/math'>Задание 3: Максимум и среднее</a>");
        out.println("</body>");
        out.println("</html>");
    }
}