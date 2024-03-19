package sba.sms.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseService is a concrete class. This class implements the
 * CourseI interface, overrides all abstract service methods and
 * provides implementation for each method.
 */
public class CourseService implements CourseI {

    @Override
    public void createCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Course> getAllCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courses = session.createQuery("from Course", Course.class).list();
        session.close();
        return courses;
    }
    @Override
    public Course getCourseById(int courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, courseId);
        session.close();
        return course;
    }
}

