package kz.bitlab.springboot.techboot.repository;

import kz.bitlab.springboot.techboot.model.ApplicationRequestModel;
import kz.bitlab.springboot.techboot.model.MusicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequestModel, Long> {

    List<ApplicationRequestModel> findAll();


//
//    List<ApplicationRequestModel> get
//
//
//
//
//    @Query("select distinct course_name from applications")
//    List<ApplicationRequestModel> findAllCourses;


    @Query("select distinct courseName from ApplicationRequestModel")
    List<String> findAllCourses();


}
