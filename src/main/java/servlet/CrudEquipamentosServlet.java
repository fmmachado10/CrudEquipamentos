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

		equipamento.setDescricao(request.getParameter("descricao"));
		equipamento.setNumeroPatrimonio(request.getParameter("numeroPatrimonio"));
		equipamento.setLocal(request.getParameter("local"));

		equipamentoDAO = new EquipamentoDAO();
		equipamentoDAO.salvarEquipamento(equipamento);

		//carregarTabela(response);

		response.getWriter().append("<h1>Equipamento cadastrado com sucesso.</h1>");
		response.sendRedirect("/CrudEquipamentos/index.html");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		System.out.println("método doPost...");

	}

	/*
	private void carregarTabela(HttpServletResponse response) {

		int rowCount = 0;

		out.println("<P ALIGN='center'><TABLE BORDER=1>");

		ResultSetMetaData rsmd = rs.getMetaData();

		int columnCount = rsmd.getColumnCount(); // cabeçalho da tabela

		out.println("<TR>");

		for (int i = 0; i < columnCount; i++) {

			out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");

		}

		out.println("</TR>"); // colocando os dados na tabela

		while (rs.next()) {

			rowCount++;

			out.println("<TR>");

			for (int i = 0; i < columnCount; i++) {
				out.println("<TD>" + rs.getString(i + 1) + "</TD>");
			}

			out.println("</TR>");

		}

		out.println("</TABLE></P>");

	}
	
	*/

}
