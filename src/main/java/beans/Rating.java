package beans;
//
public class Rating {

	private int ratingId;
	private double rating;
	private User owner;
	private User doctor;
	private Appointment appointment;
	private String comment;

	public Rating() {
		super();
	}

	public Rating(int ratingId, double rating, User owner, User doctor, Appointment appointment, String comment) {
		super();
		this.ratingId = ratingId;
		this.rating = rating;
		this.owner = owner;
		this.doctor = doctor;
		this.appointment = appointment;
		this.comment = comment;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", rating=" + rating + ", owner=" + owner + ", doctor=" + doctor
				+ ", appointment=" + appointment + ", comment=" + comment + "]";
	}

}
