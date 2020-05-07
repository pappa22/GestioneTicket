package it.dstech.utility;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "indietro", urlPatterns = { "/Admin/indietro", "/indietro" })
public class TornaIndietroAdmin extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/Admin/ProfiloAdmin.jsp").forward(req, resp);

    }
}
