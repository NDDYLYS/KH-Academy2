package jdbc.other;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;


public class MusicDao 
{
	public void insert(MusicDto musicDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		//OracleConnector connector = new OracleConnector();
		String sql = "insert into music (music_no, music_title, "
				+ "music_album, music_artist, music_play, music_like, "
				+ "music_add, music_edit) "
				+ "values (music_seq.nextval, ?, ?, ?, ?, ?, systimestamp, ?)";
		Object[] params = {musicDto.getMusicTitle(), 
				musicDto.getMusicAlbum(), 
				musicDto.getMusicArtist(), 
				musicDto.getMusicPlay(),
				musicDto.getMusicLike(),
				musicDto.getMusicEdit()};		
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(MusicDto musicDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update music set music_title=?, music_album=?, music_artist=?, music_play=?, "
    			+ "music_like=?, music_add=systimestamp, music_edit=? where music_no=?";
    	Object[] params = {musicDto.getMusicTitle(), 
				musicDto.getMusicAlbum(), 
				musicDto.getMusicArtist(), 
				musicDto.getMusicPlay(),
				musicDto.getMusicLike(),
				musicDto.getMusicEdit(),
				musicDto.getMusicNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public boolean delete(int musicNo) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "delete music where music_no=?";
    	Object[] params = {musicNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<MusicDto> selectList(String column, String keyword)
	{
		Set<String> allowList = Set.of("music_no", "music_title");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;		
		
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		MusicMapper musicMapper = new MusicMapper();
		String sql = "select * from music where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, music_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, musicMapper, params);
	}
	
	public MusicDto selectOne(int musicNo) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		String sql = "select * from music where music_no = ?";
    	Object[] params = {musicNo};
    	MusicMapper musicMapper = new MusicMapper();
    	// sql, params, mapper를 쓰면 List가 나온다
    	// ResultSetExtractor / PokemonDto
    	List<MusicDto> list = jdbcTemplate.query(sql, musicMapper, params);
    	
    	return list.isEmpty() ? null : list.get(0);
	}
}