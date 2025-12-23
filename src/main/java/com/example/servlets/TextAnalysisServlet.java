package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/text")
public class TextAnalysisServlet extends HttpServlet
{

    private static final String VOWELS = "аеёиоуыэюяAEIOUYaeiouy";
    private static final String CONSONANTS = "бвгджзйклмнпрстфхцчшщBCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
    private static final String PUNCTUATION = ".,!?;:-()\"'";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("""
            <html>
            <body>
                <h2>Анализ текста</h2>
                <form method="post">
                    <textarea name="text" rows="6" cols="60" required></textarea><br><br>
                    <button type="submit">Анализировать</button>
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

        String text = req.getParameter("text");

        Set<Character> vowels = new LinkedHashSet<>();
        Set<Character> consonants = new LinkedHashSet<>();
        Set<Character> punctuation = new LinkedHashSet<>();

        for (char c : text.toCharArray()) {
            if (VOWELS.indexOf(c) >= 0) vowels.add(c);
            else if (CONSONANTS.indexOf(c) >= 0) consonants.add(c);
            else if (PUNCTUATION.indexOf(c) >= 0) punctuation.add(c);
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Результат анализа</h2>");
        out.println("<p>Гласные (" + vowels.size() + "): " + vowels + "</p>");
        out.println("<p>Согласные (" + consonants.size() + "): " + consonants + "</p>");
        out.println("<p>Знаки препинания (" + punctuation.size() + "): " + punctuation + "</p>");
        out.println("<br><a href='text'>Назад</a>");
        out.println("</body></html>");
    }
}