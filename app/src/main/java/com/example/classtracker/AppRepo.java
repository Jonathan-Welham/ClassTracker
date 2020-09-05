// TODO: WIP
//
// package com.example.classtracker;
//
//import android.app.Application;
//
//import androidx.lifecycle.LiveData;
//
//import com.example.classtracker.DB.AppDataBase;
//import com.example.classtracker.DB.Course;
//import com.example.classtracker.DB.DAO;
//
//import java.util.List;
//
//public class AppRepo {
//    private DAO dao;
//    private LiveData<List<Course>> allCourses;
//
//    public AppRepo(Application application){
//        AppDataBase database = AppDataBase.getInstance(application);
//        dao = database.dao();
//        allCourses = (LiveData<List<Course>>) dao.getAllCourses();
//    }
//
//    public void insert(Course course){
//
//    }
//
//    public void update(Course course){
//
//    }
//}
