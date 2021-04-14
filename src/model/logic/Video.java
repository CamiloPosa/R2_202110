package model.logic;

public class Video implements Comparable<Video> {

	private String id;
	private String date;
	private String title;
	private int categoryId;
	private String publishTime;
	private String tags;
	private int views;
	private int likes;
	private int dislikes;
	private String country; 
	private int diasTrending; 
	
	
	public Video(String pid, String pdate, String ptitle, int pcategory, String ppublish, String ptags, int pviews, int plikes, int pdislikes, String pcountry ) {
		id = pid;
		date = pdate; 
		title = ptitle; 
		categoryId = pcategory; 
		publishTime = ppublish; 
		tags = ptags;
		views = pviews; 
		likes = plikes; 
		dislikes = pdislikes; 
		country = pcountry; 
		
		
	}
	
	public String darId() {
		return id; 
	}
	public String darDate() {
		return date; 
	}
	public String darTitle() {
		return title; 
	}
	public int darCategory() {
		return categoryId; 
	}
	public String darPublishTime() {
		return publishTime; 
	}
	public String darTags() {
		return tags; 
	}
	public int darViews() {
		return views; 
	}
	public String darCountry() {
		return country; 
	}
	public int darLikes() {
		return likes; 
	}
	public int darDislikes() {
		return dislikes; 
	}
	

	@Override
	public int compareTo(Video arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
