package com.example.rti;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="rti_requests")
public class RtiRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=20) private String requestCode;
 @NotBlank @Size(max=150) @Column(nullable=false,length=150) private String citizenName;
 @Email @NotBlank @Size(max=150) @Column(nullable=false,length=150) private String email;
 @NotBlank @Size(max=255) @Column(nullable=false,length=255) private String subject;
 @NotBlank @Size(max=3000) @Column(nullable=false,length=3000) private String description;
 private LocalDate submissionDate; private LocalDate deadlineDate;
 @Column(nullable=false,length=30) private String status;
 @Column(length=5000) private String response; private LocalDate responseDate;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="owner_id") @JsonIgnore private AppUser owner;
 public Long getId(){return id;} public String getRequestCode(){return requestCode;} public void setRequestCode(String x){requestCode=x;}
 public String getCitizenName(){return citizenName;} public void setCitizenName(String x){citizenName=x;} public String getEmail(){return email;} public void setEmail(String x){email=x;}
 public String getSubject(){return subject;} public void setSubject(String x){subject=x;} public String getDescription(){return description;} public void setDescription(String x){description=x;}
 public LocalDate getSubmissionDate(){return submissionDate;} public void setSubmissionDate(LocalDate x){submissionDate=x;} public LocalDate getDeadlineDate(){return deadlineDate;} public void setDeadlineDate(LocalDate x){deadlineDate=x;}
 public String getStatus(){return status;} public void setStatus(String x){status=x;} public String getResponse(){return response;} public void setResponse(String x){response=x;}
 public LocalDate getResponseDate(){return responseDate;} public void setResponseDate(LocalDate x){responseDate=x;} public AppUser getOwner(){return owner;} public void setOwner(AppUser x){owner=x;}
}