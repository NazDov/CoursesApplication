package org.nazar.dao.interfaces;

import java.sql.SQLException;

import org.nazar.user.Course;
import org.nazar.user.User;

public interface ApplicationInterface<T, M> {
	
	public T getDataByName(Object t) throws SQLException;

	//boolean checkIfhasUser(M m, T t) throws SQLException;

}
