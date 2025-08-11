package jdbc.practice;

import jdbc.other.MusicDao;
import jdbc.other.MusicDto;

public class Test06음원삭제 
{
	public static void main(String[] args) 
	{
		MusicDao musicDao = new MusicDao();
		musicDao.delete(1);
		System.out.println("음원 삭제 완료!");
	}
}
