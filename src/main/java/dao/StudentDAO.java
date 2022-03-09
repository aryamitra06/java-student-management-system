package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
	//jdbc auth
	private String URI = "jdbc:mysql:///stdmsys";
	private String username = "root";
	private String password = "";
	
	//CRUD sql statements
	private static final String INSERT_STUDENT_SQL = "insert into students" + "  (name, roll, section) values " + " (?, ?, ?);";
	private static final String SELECT_STUDENT_BY_ID_SQL = "select id, name, roll, section from students where id =?";
	private static final String SELECT_ALL_STUDENTS_SQL = "select * from students";
	private static final String DELETE_STUDENT_BY_ID_SQL = "delete from students where id = ?;";
	private static final String UPDATE_STUDENT_BY_ID_SQL = "update students set name = ?, roll= ?, section =? where id = ?;";
	
	public StudentDAO() {
	}
	
	//connection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URI, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	// <------------ CRUD ------------->
	
	//SELECT ALL STUDENTS
	public List<Student> selectAllStudents() {
		List<Student> students = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String roll = rs.getString("roll");
				String section = rs.getString("section");
				students.add(new Student(id, name, roll, section));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	
	//INSERT
	public void insertStudent(Student student) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getRoll());
			preparedStatement.setString(3, student.getSection());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE
	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID_SQL);) {
			statement.setString(1, student.getName());
			statement.setString(2, student.getRoll());
			statement.setString(3, student.getSection());
			statement.setInt(4, student.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//DELETE
	public boolean deleteStudent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_BY_ID_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//SELECT STUDENT BY ID
	public Student selectStudent(int id) {
		Student student = null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID_SQL);) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String roll = rs.getString("roll");
				String section = rs.getString("section");
				student = new Student(id, name, roll, section);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
}
