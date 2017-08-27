package controle;

import entidade.Moto;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MotoDAO;


@WebServlet("/MotoController")
public class MotoController extends HttpServlet {

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
			
			Moto moto = new Moto(nome, marca, ano, potencia);
			MotoDAO motoDAO = new MotoDAO();
			motoDAO.create(moto);
			
			req.setAttribute("moto", moto);
			RequestDispatcher dispacher = req.getRequestDispatcher("motoSuccess.jsp");
			dispacher.forward(req, resp);
			
		}else if(flag.equals("update")){
			
			Integer id;
			String nome = req.getParameter("nome");
			String marca = req.getParameter("marca");
                        Integer ano = Integer.parseInt(req.getParameter("ano"));
                        Integer potencia = Integer.parseInt(req.getParameter("potencia"));

			if(req.getParameter("id").equals("") == false){
				
				id = Integer.parseInt(req.getParameter("id"));
				Moto moto = new Moto(id, nome, marca, ano, potencia);
				MotoDAO motoDAO = new MotoDAO();
				motoDAO.update(moto);
				List<Moto> lista = motoDAO.listAll();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("listaMoto.jsp");
				dispacher.forward(req, resp);
				
			} else {
				
				Moto moto = new Moto(nome, marca, ano, potencia);
				MotoDAO motoDAO = new MotoDAO();
				motoDAO.create(moto);
				List<Moto> lista = motoDAO.listAll();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("listaMoto.jsp");
				dispacher.forward(req, resp);
				
			}
			
		} else if(flag.equals("delete")){
			
			Integer id;
			id = Integer.parseInt(req.getParameter("id"));
			Moto moto = new Moto();
			moto.setId(id);
			MotoDAO motoDAO = new MotoDAO();
			motoDAO.delete(moto);
			
			List<Moto> lista = motoDAO.listAll();
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("listaMoto.jsp");
			dispacher.forward(req, resp);
			
		} else if(flag.equals("list")){
			
			MotoDAO dao = new MotoDAO();
			List<Moto> lista = dao.listAll();
			
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("listaMoto.jsp");
			dispacher.forward(req, resp);
			
		} else {
			
			RequestDispatcher dispacher = req.getRequestDispatcher("index.html");
			dispacher.forward(req, resp);
			
		}
		
		
		
		
		
		
		
		
	}

}
