package com.example.classtracker.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Dao: contains the methods used for accessing the database
@Dao
public interface DAO {

    //User_________________________________________________
    @Query("select * from user")
    List<User> getAllUsers();

//    @Query("select * from User where username = :username and password= :password")
//    User login(String username, String password);

    @Insert
    long addUser(User user);

    @Update
    int updateUser(User user);


    @Delete
    void deleteUser(User user);

    //Course_________________________________________________

    @Query("select * from course")
    List<Course> getAllCourses();

    @Insert
    long addNewCourse(Course course);

    @Update
    int updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);
}
