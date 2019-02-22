package repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into equipamentos(descricao, numeroPatrimonio, local) values (?, ?, ? )");
	            
	            preparedStatement.setString(1, equipamento.getDescricao());
	            
	            preparedStatement.setString(2, equipamento.getNumeroPatrimonio());
	            
	            preparedStatement.setString(3, equipamento.getLocal());
	            
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	}

	public void excluirEquipamento(Equipamento equipamento) {

	}

	public void atualizarEquipamento(Equipamento equipamento) {

	}

}
