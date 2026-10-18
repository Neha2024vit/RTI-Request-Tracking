package com.example.rti;
import jakarta.persistence.*;
@Entity @Table(name="app_users")
public class AppUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=150) private String fullName;
 @Column(nullable=false,unique=true,length=150) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false,length=20) private String role;
 public Long getId(){return id;} public String getFullName(){return fullName;} public void setFullName(String x){fullName=x;}
 public String getEmail(){return email;} public void setEmail(String x){email=x;} public String getPassword(){return password;} public void setPassword(String x){password=x;}
 public String getRole(){return role;} public void setRole(String x){role=x;}
}