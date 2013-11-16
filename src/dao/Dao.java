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
}
