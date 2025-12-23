package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("""
            <html>
            <body>
                <h2>Калькулятор</h2>
                <form method="post">
                    <input type="number" name="a" step="any" required>
                    <select name="op">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                        <option value="^">^</option>
                        <option value="%">%</option>
                    </select>
                    <input type="number" name="b" step="any" required>
                    <br><br>
                    <button type="submit">Посчитать</button>
                </form>
                <br><a href="index.html">На главную</a>
            </body>
            </html>
        """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {

        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        String op = req.getParameter("op");

        double result;

        switch (op)
        {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            case "^": result = Math.pow(a, b); break;
            case "%": result = a * b / 100; break;
            default: throw new IllegalArgumentException("Неизвестная операция");
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("""
            <html>
            <body>
                <h2>Результат</h2>
                <p>%s %s %s = %s</p>
                <br><a href="calc">Назад</a>
            </body>
            </html>
        """.formatted(a, op, b, result));
    }
}