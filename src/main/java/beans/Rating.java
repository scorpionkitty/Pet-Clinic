package beans;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "RATING") //rename Physical table even though the bean is different
public class Rating {

	@Id
	@Column(name = "RATING_ID", nullable=false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingId;
	
	@OneToOne
	@Column(name="RATING", nullable=false, updatable=false)
	private double rating;
	
	@OneToOne
	@JoinColumn(name="APPT_ID", nullable=false, updatable=false)
	private Appointment appt;
	
	@OneToOne
	@Column(name="COMMENT")
	private String comment;

	public Rating() {
		super();
	}

	public Rating(int rating, Appointment appt, String comment) {
		super();
		this.rating = rating;
		this.appt = appt;
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
    
	public Appointment getAppt() {
		return appt;
	}
    
	public void setAppt(Appointment appt) {
		this.appt = appt;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", rating=" + rating + ", appt=" + appt + ", comment=" + comment + "]";
	}

}
