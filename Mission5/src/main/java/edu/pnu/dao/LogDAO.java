package edu.pnu.dao;

public interface LogDAO {

	void addLog(String method, String sqlstring, boolean tf);

}
