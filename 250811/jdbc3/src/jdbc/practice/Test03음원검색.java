package jdbc.practice;

import java.util.List;

import jdbc.other.MusicDao;
import jdbc.other.MusicDto;

public class Test03음원검색 
{
	public static void main(String[] args) 
	{
		MusicDao musicDao = new MusicDao();
    	List<MusicDto> list = musicDao.selectList("music_title", "임시");
    	
    	System.out.println("조회 결과 : " + list.size() + "개");
    	for (MusicDto musicDto : list) 
    	{
    		System.out.println(musicDto);
    	}
	}
}
