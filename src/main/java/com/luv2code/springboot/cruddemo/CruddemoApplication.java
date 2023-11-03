package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.dao.AppDAO;
import com.luv2code.springboot.cruddemo.entity.*;
import org.hibernate.boot.model.source.internal.hbm.AttributesHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            // findInstructorDetail(appDAO);

            // deleteInstructorDetail(appDAO);

            // createInstructorWithCourses(appDAO);

            // findInstructorWithCourses(appDAO);

            // findCoursesForInstructor(appDAO);

            // findInstructorWithCoursesJohnFetch(appDAO);

            // updateInstructor(appDAO);

            // updateCourse(appDAO);

            // deleteCourse(appDAO);

            // createCourseAndReviews(appDAO);

            // retrieveCourseAndReviews(appDAO);

            // deleteCourseAndReviews(appDAO);

            // createCourseAndStudents(appDAO);

            // retrieveCourseAndStudents(appDAO);
            
            // retrieveStudentAndCourses(appDAO);

            // addCoursesForStudent(appDAO);

            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting student id: " + theId);
        appDAO.deleteStudentById(theId);
        System.out.println("Done!");
    }

    private void addCoursesForStudent(AppDAO appDAO) {
        int theId = 1;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        // create more courses
        Course tempCourse1 = new Course("Music");
        Course tempCourse2 = new Course("Science");
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);
        System.out.println("Saving student " + tempStudent);
        appDAO.update(tempStudent);
        System.out.println("Done!");
    }

    private void retrieveStudentAndCourses(AppDAO appDAO) {
        int theId = 1;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
        System.out.println("Loaded student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());
        System.out.println("Done!");
    }

    private void retrieveCourseAndStudents(AppDAO appDAO) {
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());
        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        // create course
        Course tempCourse = new Course("Chemistry");

        // create students
        Student tempStudent1 = new Student("first_name1", "last_name1", "email_1");
        Student tempStudent2 = new Student("first_name2", "last_name2", "email_2");
        Student tempStudent3 = new Student("first_name3", "last_name3", "email_3");
        // add students to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        tempCourse.addStudent(tempStudent3);

        // save the course and associated students

        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students " + tempCourse.getStudents());
        appDAO.save(tempCourse);
        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int theId = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(theId);
        System.out.println(course);
        System.out.println(course.getReviews());
        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course tempCourse = new Course("Literature");

        tempCourse.addReview(new Review("very good course"));
        tempCourse.addReview(new Review("i very like it"));
        tempCourse.addReview(new Review("it quite good"));

        // save the course and leverage the cascade all
        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());
        appDAO.save(tempCourse);
        System.out.println("Done");
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("new course");

        appDAO.update(tempCourse);
        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("update lastname");
        appDAO.update(tempInstructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJohnFetch(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");

    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");

        // create the instructor detail
        Course tempCourse1 = new Course("Math");
        Course tempCourse2 = new Course("History");
        Course tempCourse3 = new Course("Geography");

        // associate the objects
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);

        // save the instructor

        // Note: this will also save the details object because of CascadeType.All
        System.out.println("Save instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 4;
        System.out.println("Deleting instructor detail id: " + theId);
        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Delete instructor detail done");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Finding instructor detail id: " + theId);
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("the associated instructor:" + tempInstructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);
        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http:/link", "stream");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor

        // Note: this will also save the details object because of CascadeType.All
        System.out.println("Save instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done");
    }
}
