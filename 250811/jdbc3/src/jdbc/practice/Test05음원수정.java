package jdbc.practice;

import jdbc.other.MusicDao;
import jdbc.other.MusicDto;

public class Test05음원수정 
{
	public static void main(String[] args) 
	{
		MusicDto musicDto = new MusicDto();
		musicDto.setMusicNo(2);
		musicDto.setMusicTitle("임시타이틀2");
		musicDto.setMusicAlbum("임시앨범2");
		musicDto.setMusicArtist("임시가수2");
		musicDto.setMusicPlay(0);
		musicDto.setMusicLike(0);
		musicDto.setMusicEdit(null);
		
		MusicDao musicDao = new MusicDao();
		musicDao.update(musicDto);
		System.out.println("음원 수정 완료!");
	}
}
