/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author r.almeida.barbosa
 */
@WebServlet(name = "ServletTeste", urlPatterns = {"/ServletTeste"})
public class ServletTeste extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        ObjetoTeste novo = (ObjetoTeste) sessao.getAttribute("novoProduto");
        String destino;
        if (novo != null) {
            request.setAttribute("novoProd", novo);

            sessao.removeAttribute("novoProd");
            destino = "respostaTeste.jsp";
        } else { // usuario acessou normalmente
            destino = "Tela.jsp";
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));

        ObjetoTeste novoTeste = new ObjetoTeste(nome, idade);

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoProduto", novoTeste);

        try {
            DaoObjetoTeste teste = new DaoObjetoTeste();
            teste.inserir(novoTeste);
        } catch (Exception e) {
            Logger.getLogger(ServletTeste.class.getName()).log(Level.SEVERE, null, e);
        }

        response.sendRedirect(request.getContextPath() + "/ServletTeste");

    }

}
