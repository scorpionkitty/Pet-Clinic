package beans;

public class Rating {

	private int ratingId;
	private int rating;
	private int ownerId;
	private int doctorId;
	private int apptId;
	private String comment;
	
	public Rating() {
		super();
	}
	public Rating(int ratingId, int rating, int ownerId, int doctorId, int apptId, String comment) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
		this.ownerId = ownerId;
		this.doctorId = doctorId;
		this.apptId = apptId;
		this.comment = comment;
	}
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getApptId() {
		return apptId;
	}
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", rating=" + rating + ", ownerId=" + ownerId + ", doctorId=" + doctorId
				+ ", apptId=" + apptId + ", comment=" + comment + "]";
	}
}
