package jdbcselect;

import jdbc.dao.StudentDao;
import jdbc.dto.StudentDto;

public class Test02학생상세 
{
	 public static void main(String[] args) 
    {
    	StudentDao studentDao = new StudentDao();
    	StudentDto student = studentDao.selectOne("student_no", 99);
    	
    	if (student == null)
			System.out.println("학생이 존재하지 않습니다.");
		else
			System.out.println(student);
    }
}
