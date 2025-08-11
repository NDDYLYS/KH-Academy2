package jdbcselect;

import java.util.List;

import jdbc.dao.StudentDao;
import jdbc.dto.StudentDto;

public class Test02학생검색 
{
	 public static void main(String[] args) 
	    {
	    	StudentDao studentDao = new StudentDao();
	    	List<StudentDto> list = studentDao.selectList("student_name", "이");
	    	
	    	System.out.println("조회 결과 : " + list.size() + "개");
	    	for (StudentDto studentDto : list) 
	    	{
	    		System.out.println(studentDto);
	    	}
	    }
}
