package jdbcselect;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.insert.JDBCHelper;

public class newclass02 
{
//	public static void main(String[] args) 
//	{
//		//포켓몬 검색
//		//- column : 검색할 항목(pokemon_name, pokemon_type)
//		//- keyword : 검색할 키워드, 검색어
//		
//		String column = "pokemon_test";
//		String keyword = "피카";
//		
//		PokemonDao pokemonDao = new PokemonDao();
//		List<PokemonDto> pokemonList = pokemonDao.selectList(column, keyword);
//		
//		System.out.println("검색 결과 : "+pokemonList.size());
//		for(PokemonDto pokemonDto : pokemonList) {
//			System.out.println(pokemonDto);
//		}
//	}	
//	
//	public List<PokemonDto> selectList(String column, String keyword)
//	{
//		Set<String> allowList = Set.of("pokemon_name", "pokemon_type");
//		
//		if (allowList.contains(column) == false)
//			return List.of(); // 비어있는 리스트;
//		
//		JdbcTemplate jdbctemplate = JDBCHelper.getJdbcTemplate();
//		PokemonMapper pokemonMapper = new PokemonMapper();
//		String sql = "select * from pokemon where instr("+column+", ?) > 0 "
//						+ "order by "+column+" asc, pokemon_no asc";
//		Object[] params = {keyword};
//		return jdbctemplate.query(sql, pokemonMapper, params);
//	}
}
