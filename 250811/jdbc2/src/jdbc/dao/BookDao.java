package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.insert.JDBCHelper;
import jdbc.mapper.BookMapper;
import jdbc.mapper.StudentMapper;

public class BookDao 
{
	public void insert(BookDto bookDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		
		String sql = "insert into pokemon (book_id, book_title, book_author,"
				+ "book_publication_date, book_price, book_publisher,"
				+ "book_page_count, book_genre) "
				+ "values (book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {bookDto.getBookTitle(), 
				bookDto.getBookAuthor(),
				bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(),
				bookDto.getBookPublisher(),
				bookDto.getBookPageCount(),
				bookDto.getBookGenre()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(BookDto bookDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update book set book_title=?, book_author=?, "
    			+ "book_publication_date=?, book_price=?, book_publisher=?, book_page_count=?,"
    			+ "book_genre=? where book_id=?";
    	Object[] params = {bookDto.getBookTitle(), bookDto.getBookAuthor(), 
    			bookDto.getBookPublicationDate(), bookDto.getBookPrice(), bookDto.getBookPublisher(),
    			bookDto.getBookPageCount(), bookDto.getBookGenre(), bookDto.getBookId()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int bookId) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "delete book where book_id=?";
    	Object[] params = {bookId};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<BookDto> selectList(String column, String keyword)
	{
    	Set<String> allowList = Set.of("book_title", "book_author", "book_publisher");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;		
		
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		BookMapper bookMapper = new BookMapper();
		String sql = "select * from book where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, book_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
}