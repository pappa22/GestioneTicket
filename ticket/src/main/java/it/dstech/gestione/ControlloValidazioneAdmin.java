package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Admin;



@WebServlet(urlPatterns = {"/validazioneAdmin"})
public class ControlloValidazioneAdmin extends HttpServlet {
		  @Override
		  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   HttpSession session = req.getSession();
			  Admin admin = (Admin) session.getAttribute("admin");
		    Controller gestione;
		   
		    gestione = new Controller();
		    gestione.attivazioneAdmin(admin);
		    req.setAttribute("mess", "L'admin " + admin.getMail() + " è stato validato");
		    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
		    
		  }
}
