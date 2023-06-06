package kz.bitlab.springboot.techboot.repository;

import kz.bitlab.springboot.techboot.model.ApplicationRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequestModel, Long> {

    List<ApplicationRequestModel> findAll();

    @Query("select distinct courseName from ApplicationRequestModel")
    List<String> findAllCourses();

    List<ApplicationRequestModel> findByHandled(boolean handled);



}
