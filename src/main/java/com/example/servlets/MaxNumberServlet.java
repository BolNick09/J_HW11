package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MaxNumberServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        // Генерация трех случайных чисел от 0 до 1000
        Random random = new Random();
        int num1 = random.nextInt(1001);
        int num2 = random.nextInt(1001);
        int num3 = random.nextInt(1001);

        // Вычисление максимума
        int max = Math.max(num1, Math.max(num2, num3));

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Максимум из 3 чисел</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
        out.println(".numbers { font-size: 20px; margin: 20px 0; }");
        out.println(".max { font-size: 24px; color: #d32f2f; font-weight: bold; margin: 20px 0; padding: 15px; background-color: #ffebee; border: 2px solid #d32f2f; }");
        out.println(".number { display: inline-block; margin: 0 10px; padding: 10px; background-color: #e3f2fd; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Задание 2: Максимум из 3 чисел</h1>");

        out.println("<div class='numbers'>");
        out.println("<h3>Сгенерированные числа:</h3>");
        out.println("<span class='number'>" + num1 + "</span>");
        out.println("<span class='number'>" + num2 + "</span>");
        out.println("<span class='number'>" + num3 + "</span>");
        out.println("</div>");

        out.println("<div class='max'>");
        out.println("<h3>Максимальное число:</h3>");
        out.println(max);
        out.println("</div>");

        out.println("<br>");
        out.println("<a href='/J_Lesson11/quote'>Задание 1: Цитата</a><br>");
        out.println("<a href='/J_Lesson11/math'>Задание 3: Максимум и среднее</a>");
        out.println("</body>");
        out.println("</html>");
    }
}