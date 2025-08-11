package jdbc.practice;

import jdbc.other.MusicDao;
import jdbc.other.MusicDto;

public class Test01음원등록 
{
	public static void main(String[] args) 
	{
		// dao, dto, mapper, jdbchelper
		// 테이블 이름 music
		// 음원번호 music_no number, 필수, 중복X, 시퀀스로 자동 설정
		// 음원제목, music_title, 한글 50자 이내, 필수, 중복O
		// 앨범명, music_album varchar2(150), null
		// 아티스트 music_artist varchar2(150), NULL, UNIQUe, default 'Varoius Artist'
		// 재생수 music_play number not null, default 0, check(music_play > 0)
		// 좋아요 music_like number not null, default 0, check(music_like > 0)
		// 등록일 music_add timestamp, not null, default systimestamp
		// 수정일 music_edit timestamp, null, 
		
		MusicDto musicDto = new MusicDto();
		musicDto.setMusicTitle("임시타이틀4");
		musicDto.setMusicAlbum("임시앨범4");
		musicDto.setMusicArtist("임시가수4");
		musicDto.setMusicPlay(0);
		musicDto.setMusicLike(0);
		musicDto.setMusicEdit(null);
		
		MusicDao musicDao = new MusicDao();
		musicDao.insert(musicDto);
		System.out.println("음원 등록 완료!");
	}
}
