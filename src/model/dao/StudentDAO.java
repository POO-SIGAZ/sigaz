package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.StudentVO;
import model.vo.ClassroomVO;

public class StudentDAO extends BaseDAO {
	
	public void create(StudentVO student) {
		String query = "INSERT INTO students (name, email, password, registration, address) VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(query);
			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setString(3, student.getPassword());
			statement.setString(4, student.getRegistration());
			statement.setString(5, student.getAdress());
			statement.execute();
		} catch (SQLException e) {
			System.out.println("Não foi possível adicionar o aluno!");
			e.printStackTrace();
		}
	}
	
	public List<StudentVO> findAll() {
		String query = "SELECT * FROM students";
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet set = statement.executeQuery(query);

			while (set.next()) {
				StudentVO student = new StudentVO();
				student.setId(set.getLong("id"));
				student.setName(set.getString("name"));
				student.setEmail(set.getString("email"));
				student.setPassword(set.getString("password"));
				student.setRegistration(set.getString("registration"));
				student.setAddress(set.getString("address"));
				studentList.add(student);
			}

		} catch (SQLException e) {
			System.out.println("Não foi possível buscar os alunos!");
			e.printStackTrace();
		}

		return studentList;
	}
	
	public List<StudentVO> findByName(StudentVO student) {
		String query = "SELECT * FROM students WHERE name = ?";
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(query);
			statement.setString(1, student.getName());
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				student.setId(set.getLong("id"));
				student.setEmail(set.getString("email"));
				student.setPassword(set.getString("password"));
				student.setAddress(set.getString("address"));
				student.setCpf(set.getString("cpf"));
				student.add(student);
			}
			
		} catch(SQLException e) {
			System.out.println("Não foi possível buscar estudantes!");
			e.printStackTrace();
		}
		
		return classroomList;
	}
	
	public List<StudentVO> findByClassroom(ClassroomVO classroom) {
		String sql = "SELECT * FROM students, students_classrooms WHERE students_classrooms.classroom_id = ? AND students.id = students_classrooms.student_id";
		List<StudentVO> studentList = new ArrayList<StudentVO>();

		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setLong(1, classroom.getId());
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				StudentVO student = new StudentVO();
				student.setId(set.getLong("students.id"));
				student.setName(set.getString("students.name"));
				student.setEmail(set.getString("students.email"));
				student.setPassword(set.getString("students.password"));
				student.setRegistration(set.getString("students.registration"));
				student.setAddress(set.getString("students.address"));
			}

		} catch (SQLException e) {
			System.out.println("Não foi possível buscar alunos");
			e.printStackTrace();
		}

		return studentList;
	}
	
	public void update(StudentVO student) {
		String query = "UPDATE students SET name = ?, email = ?, password = ?, registration = ?, address = ? WHERE id = ?";
		
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(query);
			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setString(3, student.getPassword());
			statement.setString(4, student.getRegistration());
			statement.setString(5, student.getAddress());
			statement.setLong(6, student.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Não foi possível alterar o aluno!");
			e.printStackTrace();
		}
	}
	
	public void delete(StudentVO student) {
		String query = "DELETE FROM students WHERE id = ?";
		
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(query);
			statement.setLong(1, student.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Não foi possível excluir o aluno!");
			e.printStackTrace();
		}
	}
}
