package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Genders;

public class GendersDao extends DataSourceOptions implements GendersInt{
	public boolean existeGender (Genders gender) {
		String sql = "SELECT COUNT(name) from genders WHERE name=?";
		Connection con = null;
		DataSource dataSource = this.getDataSource();
		boolean respuesta = false;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, gender.getName());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			
			if ( rs.next() ) {
				count = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			con.close();
			
			if ( count == 0 ) {
				respuesta = false;
			}
			else {
				respuesta = true;
			}
		}
		catch ( SQLException e ) {
			throw new RuntimeException (e);
		}
		
		return respuesta;
	}
}
