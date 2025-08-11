package jdbcselect;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.insert.JDBCHelper;

public class newclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbc = JDBCHelper.getJdbcTemplate();
		
		String sql = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) values (pokemon_seq.nextval, '마기라스', '물기')";
		jdbc.update(sql);
		
	}

}
