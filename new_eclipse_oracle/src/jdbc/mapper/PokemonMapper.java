package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PokemonDto;


public class PokemonMapper implements RowMapper<PokemonDto>
{

	@Override
	public PokemonDto mapRow(ResultSet rs, int idx) throws SQLException 
	{
		PokemonDto pokemonDto = new PokemonDto();
		
		pokemonDto.setPokemon_no(rs.getInt("pokemon_no"));
		pokemonDto.setPokemon_name(rs.getString("pokemon_name"));
		pokemonDto.setPokemon_type(rs.getString("pokemon_type"));
		
		// TODO Auto-generated method stub
		return pokemonDto;
	}
}