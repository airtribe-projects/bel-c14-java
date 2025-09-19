package org.example;

import org.example.cohort.Cohort;
import org.example.course.Course;
import org.example.course.CourseLanguage;
import org.example.course.OfflineCourse;
import org.example.course.OnlineCourse;
import org.example.instructors.Instructor;
import org.example.learners.JavaLearner;
import org.example.learners.Learner;
import org.example.learners.NodeLearner;


public class Main {
  public static void main(String[] args) {
    Course nodeOfflineCourse = new OfflineCourse(
        1L,
        "Node.js Offline Course",
        "Learn Node.js in an offline setting",
        CourseLanguage.NODE,
        "Bangalore"
    );

    Course nodeOnlineCourse = new OnlineCourse(
        2L,
        "Node.js Online Course",
        "Learn Node.js online",
        CourseLanguage.NODE,
        "https://zoom.us/123"
    );

    Course javaOfflineCourse = new OfflineCourse(
        3L,
        "Java Offline Course",
        "Learn Java in an offline setting",
        CourseLanguage.JAVA,
        "Bangalore"
    );


    Course javaOnlineCourse = new OnlineCourse(
        4L,
        "Java Online Course",
        "Learn Java online",
        CourseLanguage.JAVA,
        "https://zoom.us/456"
    );

    Cohort c1 = new Cohort(1L, "Cohort 1", "Cohort 1 Description", new java.util.Date(), new java.util.Date());
    Cohort c2 = new Cohort(2L, "Cohort 2", "Cohort 2 Description", new java.util.Date(), new java.util.Date());
    Cohort c3 = new Cohort(3L, "Cohort 3", "Cohort 3 Description", new java.util.Date(), new java.util.Date());
    Cohort c4 = new Cohort(4L, "Cohort 4", "Cohort 4 Description", new java.util.Date(), new java.util.Date());
    Cohort c5 = new Cohort(5L, "Cohort 5", "Cohort 5 Description", new java.util.Date(), new java.util.Date());

    nodeOnlineCourse.addCohortToCourse(c1);
    nodeOnlineCourse.addCohortToCourse(c2);
    nodeOnlineCourse.addCohortToCourse(c3);
    nodeOnlineCourse.addCohortToCourse(c4);
    nodeOnlineCourse.addCohortToCourse(c5);


    Learner javaLearner1 = new JavaLearner("Java Learner 1", "test", 1L, true);
    Learner javaLearner2 = new JavaLearner("Java Learner 2", "test", 2L, false);
    Learner nodeLearner1 = new NodeLearner("Node Learner 1", "test", 3L, 2);
    Learner nodeLearner2 = new NodeLearner("Node Learner 2", "test", 4L, 6);

    c1.addLearnerToCohort(javaLearner1);
    c1.addLearnerToCohort(nodeLearner2);
    c2.addLearnerToCohort(javaLearner2);
    c3.addLearnerToCohort(nodeLearner1);

    Instructor instructor1 = new Instructor(1L, "Instructor 1", "test");
    c1.addInstructorToCohort(instructor1);

    nodeOnlineCourse.displayCourseDetails();

  }
}