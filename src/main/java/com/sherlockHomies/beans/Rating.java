package com.sherlockHomies.beans;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 * Rating bean to be mapped to RATING table in our relational database with the following columns:
 * 		RATING_ID, RATING, APPT_ID, COMMENTS
 */

@Cacheable
@Entity
@Table(name = "RATING")
public class Rating {

	@Id
	@Column(name = "RATING_ID", nullable=false, updatable = false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int ratingId;
	
	@Column(name="RATING", nullable=false)
	private double rating;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="APPT_ID", nullable=false)
	@ForeignKey(name="APPT_ID_FK_")
	@NotNull
	private Appointment appt;
	
	@Column(name="COMMENTS")
	private String comment;

	public Rating() {
		super();
	}

	public Rating(int ratingId, int rating, Appointment appt, String comment) {
		super();
		this.ratingId = ratingId;
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
