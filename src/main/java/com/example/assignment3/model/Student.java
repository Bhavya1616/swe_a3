// package com.example._assignment3.model;
// // all the student getters/ setters  - for all the filds 

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Student {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

    


    
// }
package com.example.assignment3.model;

import java.util.Date;
import java.util.List;
// import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.MapKeyColumn;



@Entity
@Table(name="students")
public class Student {
	
	public Student() {
        // Default constructor
    }

	
	public Student(Long id, String firstName, String lastName, String streetAddress, String city, String state,
			String zip, String telephone, String email, Date dateOfSurvey, List<String> likedOptions,
			String likelihoodToRecommend, SourceOfInterest sourceOfInterest, String comments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephone = telephone;
		this.email = email;
		this.date = dateOfSurvey;
		this.likedOptions = likedOptions;
		this.likelihoodToRecommend = likelihoodToRecommend;
		this.sourceOfInterest = sourceOfInterest;
		this.comments = comments;
	} 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "street_address")
	private String streetAddress;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "zip")
	private String zip;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfSurvey() {
		return date;
	}
	public void setDateOfSurvey(Date dateOfSurvey) {
		this.date = dateOfSurvey;
	}

	public String getLikelihoodToRecommend() {
		return likelihoodToRecommend;
	}
	public void setLikelihoodToRecommend(String likelihoodToRecommend) {
		this.likelihoodToRecommend = likelihoodToRecommend;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "email")
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	// @ElementCollection
	// @CollectionTable(name = "liked_options", joinColumns = @JoinColumn(name = "student_id"))
	// @Column(name = "option_value")
	// @MapKeyColumn(name = "option_name")
	// private Map<String, Boolean> likedOptions;

	@ElementCollection
    @CollectionTable(name = "liked_options", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "option_name")
    private List<String> likedOptions;

   

    
    @Column(name = "likelihood_to_recommend", nullable = true)
    private String likelihoodToRecommend; 
    
    @Enumerated(EnumType.STRING)
    @Column(name = "source_of_interest", nullable = true)
    private SourceOfInterest sourceOfInterest;
    
    @Column(name = "comments", nullable = true)
    private String comments;
	public SourceOfInterest getSourceOfInterest() {
		return sourceOfInterest;
	}

	public void setSourceOfInterest(SourceOfInterest sourceOfInterest) {
		this.sourceOfInterest = sourceOfInterest;
	}

	public List<String> getLikedOptions() {
        return likedOptions;
    }

    public void setLikedOptions(List<String> likedOptions) {
        this.likedOptions = likedOptions;
    }
	// public Map<String, Boolean> getLikedOptions() {
    //     return likedOptions;
    // }

	// public void setLikedOptions(Map<String, Boolean> likedOptions) {
    //     this.likedOptions = likedOptions;
    // }
	
	@Override
	public String toString() {
	    return "Student{" +
	            "id=" + id +
	            ", firstName='" + firstName + '\'' +
	            ", lastName='" + lastName + '\'' +
	            ", streetAddress='" + streetAddress + '\'' +
	            ", city='" + city + '\'' +
	            ", state='" + state + '\'' +
	            ", zip='" + zip + '\'' +
	            ", telephone='" + telephone + '\'' +
	            ", email='" + email + '\'' +
	            ", date=" + date +
	            ", likedOptions=" + likedOptions +
	            ", likelihoodToRecommend='" + likelihoodToRecommend + '\'' +
	            ", sourceOfInterest=" + sourceOfInterest +
	            ", comments='" + comments + '\'' +
	            '}';
	}
	

}