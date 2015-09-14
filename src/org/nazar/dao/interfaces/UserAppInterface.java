package org.nazar.dao.interfaces;

import java.sql.SQLException;

public interface UserAppInterface<T> {
	
	public boolean checkIfhasCourses(T t) throws SQLException;

}
