package controle;

import entidade.Carro;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CarroDAO;

@WebServlet("/CarroController")
public class CarroController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String flag = req.getParameter("flag");
		
		if(flag.equals("create")){
			
			String nome = req.getParameter("nome");
			String marca = req.getParameter("marca");
                        Integer ano = Integer.parseInt(req.getParameter("ano"));
                        Integer potencia = Integer.parseInt(req.getParameter("potencia"));
			
			Carro carro = new Carro(nome, marca, ano, potencia);
			CarroDAO carroDAO = new CarroDAO();
			carroDAO.create(carro);
			
			req.setAttribute("carro", carro);
			RequestDispatcher dispacher = req.getRequestDispatcher("carroSuccess.jsp");
			dispacher.forward(req, resp);
			
		}else if(flag.equals("update")){
			
			Integer id;
			String nome = req.getParameter("nome");
			String marca = req.getParameter("marca");
                        Integer ano = Integer.parseInt(req.getParameter("ano"));
                        Integer potencia = Integer.parseInt(req.getParameter("potencia"));

			if(req.getParameter("id").equals("") == false){
				
				id = Integer.parseInt(req.getParameter("id"));
				Carro carro = new Carro(id, nome, marca, ano, potencia);
				CarroDAO carroDAO = new CarroDAO();
				carroDAO.update(carro);
				List<Carro> lista = carroDAO.listAll();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("listaCarro.jsp");
				dispacher.forward(req, resp);
				
			} else {
				
				Carro carro = new Carro(nome, marca, ano, potencia);
				CarroDAO carroDAO = new CarroDAO();
				carroDAO.create(carro);
				List<Carro> lista = carroDAO.listAll();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("listaCarro.jsp");
				dispacher.forward(req, resp);
				
			}
			
		} else if(flag.equals("delete")){
			
			Integer id;
			id = Integer.parseInt(req.getParameter("id"));
			Carro carro = new Carro();
			carro.setId(id);
			CarroDAO carroDAO = new CarroDAO();
			carroDAO.delete(carro);
			
			List<Carro> lista = carroDAO.listAll();
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("listaCarro.jsp");
			dispacher.forward(req, resp);
			
		} else if(flag.equals("list")){
			
			CarroDAO dao = new CarroDAO();
			List<Carro> lista = dao.listAll();
			
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("listaCarro.jsp");
			dispacher.forward(req, resp);
			
		} else {
			
			RequestDispatcher dispacher = req.getRequestDispatcher("index.html");
			dispacher.forward(req, resp);
			
		}
		
		
		
		
		
		
		
		
	}

}
