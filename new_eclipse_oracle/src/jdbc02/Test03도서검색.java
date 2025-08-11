package jdbc02;

import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dao.StudentDao;
import jdbc.dto.BookDto;
import jdbc.dto.StudentDto;

public class Test03도서검색 
{

    public static void main(String[] args) 
    {
       	BookDao bookDao = new BookDao();
    	List<BookDto> list = bookDao.selectList("book_title", "지");
    	
    	System.out.println("조회 결과 : " + list.size() + "개");
    	for (BookDto bookDto : list) 
    	{
    		System.out.println(bookDto);
    	}
    }
}
