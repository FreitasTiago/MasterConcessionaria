package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.connectionFactory;
import model.bean.Veiculo;

public class VeiculoDAO {
    private static final Connection con = null;

    public void create(Veiculo v) {

        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO veiculo(modelo, marca, chassi, placa, ano, cambioA) VALUES" + "(?,?,?,?,?,?)");

            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getChassi());
            stmt.setString(4, v.getPlaca());
            stmt.setInt(5, v.getAno());
            stmt.setBoolean(6, v.getCambioA());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Veiculo registrado com sucesso!");

        } catch(SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);


        }finally {

        connectionFactory.closeConnection(con,stmt);

        }
    }

    public List<Veiculo> read(){
    	Connection con = connectionFactory.getConnection();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	List<Veiculo> veiculos = new ArrayList<>();
    	
    	try {
			stmt = con.prepareStatement("SELECT * FROM veiculo;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("id"));
				v.setModelo(rs.getString("modelo"));
				v.setMarca(rs.getString("marca"));
				v.setChassi(rs.getString("chassi"));
				v.setPlaca(rs.getString("placa"));
				v.setAno(rs.getInt("ano"));
				v.setCambioA(rs.getBoolean("cambioA"));
				veiculos.add(v);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		}finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
    	return veiculos;
    }  
    public Veiculo read(int id){
		Connection con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Veiculo v = new Veiculo();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Veiculo WHERE Id=? Limit 1");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				v.setId(rs.getInt("Id"));
				v.setModelo(rs.getString("Modelo"));
				v.setMarca(rs.getString("Marca"));
				v.setChassi(rs.getString("Chassi"));
				v.setPlaca(rs.getString("Placa"));
				v.setAno(rs.getInt("Ano"));
				v.setCambioA(rs.getBoolean("CambioA"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
		return v;
	}

	public void  update(Veiculo v) {
		Connection con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("UPDATE `veiculo` SET `modelo`=?,`marca`=?,`chassi`=?,`placa`=?,`ano`=?,`cambioA`=? WHERE id = ? LIMIT 1");
			stmt.setString(1, v.getModelo());
			stmt.setString(2, v.getMarca());
			stmt.setString(3, v.getChassi());
			stmt.setString(4, v.getPlaca());
			stmt.setInt(5, v.getAno());
			stmt.setBoolean(6, v.getCambioA());
			stmt.setInt(7, v.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Banco de dado atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Banco de Dados " + e);
			e.printStackTrace();
		}
		finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Veiculo v) {
		Connection con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM Veiculo WHERE Id =?");
			stmt.setInt(1, v.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!");
			
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao delatar: " + e);
			e.printStackTrace();
		} finally {
			connectionFactory.closeConnection(con);	
		}
	}
    
}
