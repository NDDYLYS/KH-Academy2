package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.dto.PokemonDto;
import jdbc.insert.JDBCHelper;
import jdbc.mapper.PokemonMapper;

public class PokemonDao 
{
	public void insert(PokemonDto pokemonDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		
		String sql = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) "
				+ "values (pokemon_seq.,nextval, ?, ?)";
		Object[] params = {pokemonDto.getPokemon_name(),
				pokemonDto.getPokemon_type()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(PokemonDto pokemonDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update pokemon set pokemon_name=?, pokemon_type=? "
    			+ "where pokemon_no=?";
    	Object[] params = {pokemonDto.getPokemon_name(), pokemonDto.getPokemon_type(), pokemonDto.getPokemon_no()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int pokemonNo) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "delete pokemon where pokemon_no=?";
    	Object[] params = {pokemonNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<BookDto> selectList(String column, String keyword)
	{
    	Set<String> allowList = Set.of("pokemon_name", "pokemon_type");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;		
		
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		PokemonMapper pokemonMapper = new PokemonMapper();
		String sql = "select * from pookemon where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, pokemon_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, params);
	}
}