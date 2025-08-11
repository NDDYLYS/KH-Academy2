package jdbc.other;

import java.sql.Timestamp;

public class MusicDto 
{
	private int musicNo;
	private String musicTitle;
	private String musicAlbum;
	private String musicArtist;
	private int musicPlay;
	private int musicLike;
	private Timestamp musicAdd;
	private Timestamp musicEdit;
	
	public MusicDto()
	{
		
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicAlbum() {
		return musicAlbum;
	}

	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}

	public String getMusicArtist() {
		return musicArtist;
	}

	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}

	public int getMusicPlay() {
		return musicPlay;
	}

	public void setMusicPlay(int musicPlay) {
		this.musicPlay = musicPlay;
	}

	public int getMusicLike() {
		return musicLike;
	}

	public void setMusicLike(int musicLike) {
		this.musicLike = musicLike;
	}

	public Timestamp getMusicAdd() {
		return musicAdd;
	}

	public void setMusicAdd(Timestamp musicAdd) {
		this.musicAdd = musicAdd;
	}

	public Timestamp getMusicEdit() {
		return musicEdit;
	}

	public void setMusicEdit(Timestamp musicEdit) {
		this.musicEdit = musicEdit;
	}

	@Override
	public String toString() {
		return "MusicDto [musicNo=" + musicNo + ", musicTitle=" + musicTitle + ", musicAlbum=" + musicAlbum
				+ ", musicArtist=" + musicArtist + ", musicPlay=" + musicPlay + ", musicLike=" + musicLike
				+ ", musicAdd=" + musicAdd + ", musicEdit=" + musicEdit + "]";
	}
	
	public int GetRankingPoint() 
	{
		return (getMusicLike() * 123) + getMusicPlay();
	}
}
