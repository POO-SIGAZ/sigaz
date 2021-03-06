package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.PrincipalVO;

public class PrincipalDAO implements IUserDAO<PrincipalVO> {
	public void create(PrincipalVO principal) throws SQLException {
		String sql = "INSERT INTO principals (name, email, password) VALUES (?, ?, ?)";

		PreparedStatement statement = BaseDAO.getInstance().getConnection().prepareStatement(sql);
		statement.setString(1, principal.getName());
		statement.setString(2, principal.getEmail());
		statement.setString(3, principal.getPassword());
		statement.execute();
	}

	public List<PrincipalVO> findAll() throws SQLException {
		String sql = "SELECT * FROM principals";
		List<PrincipalVO> principalList = new ArrayList<PrincipalVO>();

		Statement statement = BaseDAO.getInstance().getConnection().createStatement();
		ResultSet set = statement.executeQuery(sql);

		try {
			while (set.next()) {
				PrincipalVO principal = new PrincipalVO();
				principal.setId(set.getLong("id"));
				principal.setName(set.getString("name"));
				principal.setEmail(set.getString("email"));
				principal.setPassword(set.getString("password"));
				principalList.add(principal);
			}
		} catch (Exception e) {
			throw new SQLException("Erro crítico, dados inválidos salvos no banco");
		}

		return principalList;
	}

	public PrincipalVO findByEmail(PrincipalVO data) throws SQLException {
		String sql = "SELECT * FROM principals WHERE email = ?";
		PrincipalVO principal = null;

		PreparedStatement statement = BaseDAO.getInstance().getConnection().prepareStatement(sql);
		statement.setString(1, data.getEmail());
		ResultSet set = statement.executeQuery();

		try {
			if (set.next()) {
				principal = new PrincipalVO();
				principal.setId(set.getLong("id"));
				principal.setName(set.getString("name"));
				principal.setEmail(set.getString("email"));
				principal.setPassword(set.getString("password"));
			}
		} catch (Exception e) {
			throw new SQLException("Erro crítico, dados inválidos salvos no banco");
		}

		return principal;
	}

	public void update(PrincipalVO principal, PrincipalVO data) throws SQLException {
		String sql = "UPDATE principals SET name = ?, email = ?, password = ? WHERE id = ?";

		PreparedStatement statement = BaseDAO.getInstance().getConnection().prepareStatement(sql);
		statement.setString(1, data.getName());
		statement.setString(2, data.getEmail());
		statement.setString(3, data.getPassword());
		statement.setLong(6, principal.getId());
		statement.executeUpdate();
	}

	public void delete(PrincipalVO principal) throws SQLException {
		String sql = "DELETE FROM principals WHERE id = ?";

		PreparedStatement statement = BaseDAO.getInstance().getConnection().prepareStatement(sql);
		statement.setLong(1, principal.getId());
		statement.executeUpdate();
	}
}
