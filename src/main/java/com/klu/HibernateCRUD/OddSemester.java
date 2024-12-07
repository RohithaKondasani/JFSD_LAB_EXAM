package com.klu.HibernateCRUD;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
@DiscriminatorValue("OddSemester")

@Entity
public class OddSemester extends Student {

  //@Id
  String course;
  String registration;
  
  public String getCourse() {
    return course;
  }
  public void setCourse(String course) {
    this.course = course;
  }
  public String getRegistration() {
    return registration;
  }
  public void setRegistration(String registration) {
    this.registration = registration;
  }
}