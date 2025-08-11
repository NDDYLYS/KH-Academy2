package jdbc.practice;

import jdbc.other.MusicDao;
import jdbc.other.MusicDto;

public class Test04음원상세 
{
	public static void main(String[] args) 
	{
		int musicNo = 3;
		
		MusicDao musicDao = new MusicDao();
		MusicDto musicDto = musicDao.selectOne(musicNo);
		
		if (musicDto == null)
			System.out.println("존재하지 않습니다.");
		else 
		{
			System.out.println(musicDto);
			System.out.println("내 랭킹 포인트 : " + musicDto.GetRankingPoint());
		}
	}
}
