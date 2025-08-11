package jdbcselect;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03도서상세 
{
    public static void main(String[] args) 
    {
    	BookDao bookDao = new BookDao();
    	BookDto book = bookDao.selectOne("book_id", 50);
    	
    	if (book == null)
			System.out.println("도서가 존재하지 않습니다.");
		else
			System.out.println(book);
    }
}