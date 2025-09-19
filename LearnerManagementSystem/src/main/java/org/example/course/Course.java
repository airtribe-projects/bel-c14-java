package org.example.course;

import java.util.ArrayList;
import java.util.List;
import org.example.cohort.Cohort;


public abstract class Course {
  private Long courseId;

  private String courseName;

  private String courseDescription;

  private CourseLanguage courseLanguage;

  private List<Cohort> cohorts;

  public Course(Long courseId, String courseName, String courseDescription, CourseLanguage courseLanguage,
      List<Cohort> cohorts) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.courseLanguage = courseLanguage;
    this.cohorts = cohorts;
  }

  public Course(Long courseId, String courseName, String courseDescription, CourseLanguage courseLanguage) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.courseLanguage = courseLanguage;
    this.cohorts = new ArrayList<>();
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseDescription() {
    return courseDescription;
  }

  public void setCourseDescription(String courseDescription) {
    this.courseDescription = courseDescription;
  }

  public CourseLanguage getCourseLanguage() {
    return courseLanguage;
  }

  public void setCourseLanguage(CourseLanguage courseLanguage) {
    this.courseLanguage = courseLanguage;
  }

  public List<Cohort> getCohorts() {
    return cohorts;
  }

  public void setCohorts(List<Cohort> cohorts) {
    this.cohorts = cohorts;
  }

  public void addCohortToCourse(Cohort cohort) {
    this.cohorts.add(cohort);
  }

  public abstract void displayCourseDetails();
}
