package model;

import entidade.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MotoDAO {
	
	public void create(Moto moto) {
		String sql = "insert into moto (nome, marca, ano, potencia) values(?,?,?,?)";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, moto.getNome());
				stm.setString(2, moto.getMarca());
                                stm.setInt(3, moto.getAno());
                                stm.setInt(4, moto.getPotencia());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Moto moto) {
		String sql = "update moto set nome=?, marca=?, ano=?, potencia=? where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, moto.getNome());
				stm.setString(2, moto.getMarca());
                                stm.setInt(3, moto.getAno());
                                stm.setInt(4, moto.getPotencia());
				stm.setInt(5, moto.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Moto moto){
		Integer id = moto.getId();
		if(id == null){
			create(moto);
		} else {
			update(moto);
		}
	}
	
	public void delete(Moto moto) {
		String sql = "delete from moto where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setInt(1, moto.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public List<Moto> listAll(){
		List<Moto> moto = new ArrayList<>();
		
		String sql = "select * from moto order by id";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()) {
				while(rs.next()){
					moto.add(new Moto(rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("marca"),
                                                        rs.getInt("ano"),
                                                        rs.getInt("potencia")));
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return moto;
	}
	
	
}
