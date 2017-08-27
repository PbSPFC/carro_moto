package model;

import entidade.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarroDAO {
	
	public void create(Carro carro) {
		String sql = "insert into carro (nome, marca, ano, potencia) values(?,?,?,?)";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, carro.getNome());
				stm.setString(2, carro.getMarca());
                                stm.setInt(3, carro.getAno());
                                stm.setInt(4, carro.getPotencia());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Carro carro) {
		String sql = "update carro set nome=?, marca=?, ano=?, potencia=? where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, carro.getNome());
				stm.setString(2, carro.getMarca());
                                stm.setInt(3, carro.getAno());
                                stm.setInt(4, carro.getPotencia());
				stm.setInt(5, carro.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Carro carro){
		Integer id = carro.getId();
		if(id == null){
			create(carro);
		} else {
			update(carro);
		}
	}
	
	public void delete(Carro carro) {
		String sql = "delete from carro where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setInt(1, carro.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public List<Carro> listAll(){
		List<Carro> carro = new ArrayList<>();
		
		String sql = "select * from carro order by id";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()) {
				while(rs.next()){
					carro.add(new Carro(rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("marca"),
                                                        rs.getInt("ano"),
                                                        rs.getInt("potencia")));
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return carro;
	}
	
	
}
