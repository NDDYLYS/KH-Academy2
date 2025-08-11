package jdbcselect;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬상세조회 
{
	public static void main(String[] args) 
	{
		// 하나의 포켓몬 중뷰믄 보기 위한 코드
		// 한 개만 나오려면 조건에 사용하는 항목이 유일하거나 프라이머리 키여야 한다.
		// 일반적으로 primary key를 사용
		
		int pokemonNo = 3;
		
		PokemonDao pokemonDao = new PokemonDao();
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		
		if (pokemonDto == null)
			System.out.println("존재하지 않습니다.");
		else
			System.out.println(pokemonDto);
		
		System.out.println(pokemonDto);
	}
}