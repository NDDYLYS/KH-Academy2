package jdbc.other;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MusicMapper implements RowMapper<MusicDto>
{
	@Override
	public MusicDto mapRow(ResultSet rs, int idx) throws SQLException 
	{
		MusicDto musicDto = new MusicDto();
		
		musicDto.setMusicNo(rs.getInt("music_no"));
		musicDto.setMusicTitle(rs.getString("music_title"));
		musicDto.setMusicAlbum(rs.getString("music_album"));
		musicDto.setMusicArtist(rs.getString("music_artist"));
		musicDto.setMusicPlay(rs.getInt("music_play"));
		musicDto.setMusicLike(rs.getInt("music_like"));
		musicDto.setMusicAdd(rs.getTimestamp("music_add"));
		musicDto.setMusicEdit(rs.getTimestamp("music_edit"));
		
		return musicDto;
	}
}