package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao extends AbstractDao {
	public List<Unit> findAllUnits() throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try {

	        st = getConnection().createStatement();
	        rs = st.executeQuery("select * from unit");
	        while(rs.next()){
	        	Unit unit = new Unit();
	        	unit.setId(Integer.parseInt(rs.getString("id")));
	        	unit.setName(rs.getString("name"));
	        	unit.setCode(rs.getString("code"));
	        	units.add(unit);
	        }
	    } finally {
			closeResources();
	    }
		return units;
	}
    public List<Unit> search(String s)  throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try {

			st = getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM unit WHERE lower(name) LIKE '%" + s.toLowerCase() + "%'");
	        while(rs.next()){
	        	Unit unit = new Unit();
	        	unit.setId(Integer.parseInt(rs.getString("id")));
	        	unit.setName(rs.getString("name"));
	        	unit.setCode(rs.getString("code"));
	        	units.add(unit);
	        }
	    } finally {
			closeResources();
	    }
		return units;
    }
    public boolean deleteAll() throws SQLException {
        try {
                st = getConnection().createStatement();
                rs = st.executeQuery("DELETE FROM unit");
        } finally {
                closeResources();
        }
        return true;
	}
	
	public boolean deleteUnit(int id) throws SQLException {
	        try {
	                st = getConnection().createStatement();
	                rs = st.executeQuery("DELETE FROM unit WHERE id = " + id);
	        } finally {
	                closeResources();
	        }
	        return true;
	}
    public boolean addUnit(String name, String code) throws SQLException {
        try {
                st = getConnection().createStatement();
                rs = st.executeQuery("INSERT INTO unit VALUES (NEXT VALUE FOR seq1), '" + name + "', '" + code + "'");
        } finally {
                closeResources();
        }
        return true;
    }
}
