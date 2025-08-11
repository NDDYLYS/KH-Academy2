package jdbc.dto;

public class PokemonDto 
{
	private int pokemon_no;
	private String pokemon_name;
	private String pokemon_type;
	
	public PokemonDto() 
	{
	}

	public int getPokemon_no() {
		return pokemon_no;
	}

	public void setPokemon_no(int pokemon_no) {
		this.pokemon_no = pokemon_no;
	}

	public String getPokemon_name() {
		return pokemon_name;
	}

	public void setPokemon_name(String pokemon_name) {
		this.pokemon_name = pokemon_name;
	}

	public String getPokemon_type() {
		return pokemon_type;
	}

	public void setPokemon_type(String pokemon_type) {
		this.pokemon_type = pokemon_type;
	}

	@Override
	public String toString() {
		return "PokemonDto [pokemon_no=" + pokemon_no + ", pokemon_name=" + pokemon_name + ", pokemon_type="
				+ pokemon_type + "]";
	}	
}