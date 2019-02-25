package repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.DbUtil;
import modelo.Equipamento;

public class EquipamentoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8288611855432346547L;

	private Connection connection;

	public EquipamentoDAO() {

		connection = DbUtil.getConnection();

	}

	public void salvarEquipamento(Equipamento equipamento) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into equipamentos(descricao, numeroPatrimonio, local) values (?, ?, ? )");

			preparedStatement.setString(1, equipamento.getDescricao());

			preparedStatement.setString(2, equipamento.getNumeroPatrimonio());

			preparedStatement.setString(3, equipamento.getLocal());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Equipamento> buscarEquipamento(Equipamento equipamento) {

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		List<Equipamento> lista = new ArrayList<Equipamento>();

		try {

			pstmt = connection.prepareStatement("SELECT * FROM Equipamentos WHERE Id = ?");
			
			pstmt.setLong(1, equipamento.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Equipamento bean = new Equipamento();

				bean.setId(rs.getInt("id"));

				bean.setDescricao(rs.getString("descricao"));
				
				bean.setNumeroPatrimonio(rs.getString("numeroPatrimonio"));
				
				bean.setLocal(rs.getString("local"));

				lista.add(bean);

			}

			return lista;

		} catch (Exception ex) {

			ex.getMessage();

		} finally {

			pstmt = null;

		}

		return null;

	}

	public void excluirEquipamento(Equipamento equipamento) {

	}

	public void atualizarEquipamento(Equipamento equipamento) {

	}

}
