package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.dto.StudentDto;
import jdbc.insert.JDBCHelper;
import jdbc.mapper.StudentMapper;

public class StudentDao 
{
	
	public void insert(StudentDto studentDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		//OracleConnector connector = new OracleConnector();
		String sql = "insert into student (student_no, student_name, "
				+ "student_kor, student_eng, student_mat, student_reg) "
				+ "values (student_seq.nextval, ?, ?, ?, ?, systimestamp)";
		Object[] params = {studentDto.getStudentName(), 
				studentDto.getStudentKor(), 
				studentDto.getStudentEng(), 
				studentDto.getStudentMat()};		
		//connector.RunSQL(sql, params);
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(StudentDto studentDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update student set student_name=?, student_kor=?, student_eng=?, student_mat=? where student_no=?";
    	Object[] params = {studentDto.getStudentName(), studentDto.getStudentKor(), 
    			studentDto.getStudentEng(), studentDto.getStudentMat(), 
    			studentDto.getStudentNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int studentNo) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "delete student where student_no=?";
    	Object[] params = {studentNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<StudentDto> selectList(String column, String keyword)
	{
		Set<String> allowList = Set.of("student_name");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;		
		
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		StudentMapper studentMapper = new StudentMapper();
		String sql = "select * from student where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, student_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, studentMapper, params);
	}
	
	public StudentDto selectOne(String column, int student_no)
	{
		Set<String> allowList = Set.of("student_no");
		
		if (allowList.contains(column) == false)
			return null; // 비어있는 리스트;	
		
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "select * from student where student_no = ?";
    	Object[] params = {student_no};
    	StudentMapper studentMapper = new StudentMapper();
    	List<StudentDto> list = jdbcTemplate.query(sql, studentMapper, params);
    	return list.isEmpty() ? null : list.get(0);
	}
}