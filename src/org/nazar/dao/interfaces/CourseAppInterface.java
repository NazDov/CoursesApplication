package org.nazar.dao.interfaces;

import java.sql.SQLException;

public interface CourseAppInterface<T, M, K> {

	public K getUserCourse(T t, M m) throws SQLException;
	
	public T getCourseByUser(M m) throws SQLException;
}
