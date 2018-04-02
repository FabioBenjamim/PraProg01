package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pergunta;
import service.PerguntaService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterPergunta.do")
public class ManterPerguntaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int  pId_Pergunta = Integer.parseInt(request.getParameter("id_pergunta"));
    	
        String pPergunta_Pergunta = request.getParameter("pergunta_pergunta");
       
        
        
        
        //instanciar o javabean
        Pergunta pergunta = new Pergunta();
        pergunta.setId_Pergunta(pId_Pergunta);
        pergunta.setPergunta_Pergunta(pPergunta_Pergunta);
       
        
        //instanciar o service
        PerguntaService PerguntaS = new PerguntaService();
        PerguntaS.criar(pergunta);
        pergunta = PerguntaS.carregar(pergunta.getId_Pergunta());
        
        //enviar para o jsp
        request.setAttribute("pergunta", pergunta);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Pergutna.jsp");
        view.forward(request, response);
        
    }
    
}
