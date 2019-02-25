package servlet;

import java.io.IOException;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Equipamento;
import repositorio.EquipamentoDAO;

@WebServlet("/CrudEquipamentosServlet")
public class CrudEquipamentosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EquipamentoDAO equipamentoDAO;

	public CrudEquipamentosServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Equipamento equipamento = new Equipamento();

		equipamento.setId(Long.parseLong(request.getParameter("id").toString()));
		equipamento.setDescricao(request.getParameter("descricao"));
		equipamento.setNumeroPatrimonio(request.getParameter("numeroPatrimonio"));
		equipamento.setLocal(request.getParameter("local"));

		
		if (request.getParameter("submit").equals("submit_Buscar") ) {
			
			buscar(equipamento);
			response.getWriter().println("Buscado com sucesso.");
			
		} else if (request.getParameter("submit").equals("submit_Cadastrar")) {
			
			cadastrar(equipamento);
			response.getWriter().println("Cadastrado com sucesso.");
			
		} else if (request.getParameter("submit").equals("submit_Excluir")) {
			
			excluir(equipamento);
			response.getWriter().println("Excluído com sucesso.");
			
		}
	
	}
	
	private void buscar(Equipamento equipamento) {
		
		equipamentoDAO = new EquipamentoDAO();
		equipamentoDAO.buscarEquipamento(equipamento);
		
	}
	
	private void cadastrar(Equipamento equipamento) {
		
		equipamentoDAO = new EquipamentoDAO();
		equipamentoDAO.salvarEquipamento(equipamento);
		
	}
	
	private void excluir(Equipamento equipamento) {
		
		equipamentoDAO = new EquipamentoDAO();
		equipamentoDAO.excluirEquipamento(equipamento);
		
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		System.out.println("método doPost...");

	}
	
}
