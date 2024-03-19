package sba.sms.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sba.sms.models.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @ParameterizedTest
    @CsvSource({
            "annette@gmail.com, password, true",
            "anthony@gmail.com, password, true",
            "ariadna@gmail.com, password, true"
    })
    void testValidateStudent(String email, String password, boolean expected) {
        Student student = new Student(email, "Test Student", password);
        studentService.createStudent(student);
        assertEquals(expected, studentService.validateStudent(email, password));
    }

}