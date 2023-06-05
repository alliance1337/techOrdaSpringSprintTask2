package kz.bitlab.springboot.techboot.controller;

import kz.bitlab.springboot.techboot.db.Music;
import kz.bitlab.springboot.techboot.dbconnect.MusicManager;
import kz.bitlab.springboot.techboot.model.ApplicationRequestModel;
import kz.bitlab.springboot.techboot.model.MusicModel;
import kz.bitlab.springboot.techboot.repository.ApplicationRequestRepository;
import kz.bitlab.springboot.techboot.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {



    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;


    @GetMapping(value = "/") //@WebServlet(value = "/") + doGet()
    public String indexPage(Model model){
        List<ApplicationRequestModel> applicationRequestModelList = applicationRequestRepository.findAll();//musicRepository.findAllByDurationGreaterThan(0);
        model.addAttribute("applications", applicationRequestModelList); // request.setAttribute("muzikalar", musicArray);
        return "index"; //request.getRequestDispatcher("/index.html").forward(request,response)
    }

    @PostMapping(value = "/add-new-application")
    public String addApplication(ApplicationRequestModel application){
        applicationRequestRepository.save(application);
        return "redirect:/";
    }


    @GetMapping(value = "/application-details")
    public String getApplication(@RequestParam(name = "applicationId") Long id, Model model){
        ApplicationRequestModel application = applicationRequestRepository.findById(id).orElse(null);
        return "details";
    }



    @GetMapping(value = "/details/{applicationId}")
    public String applicationDetails(@PathVariable(name = "applicationId") Long id, Model model){
        ApplicationRequestModel apl = applicationRequestRepository.findById(id).orElse(null);
        model.addAttribute("apl", apl);
        List<String> courseNames = applicationRequestRepository.findAllCourses();
        model.addAttribute("courseNames", courseNames);
        model.addAttribute("selectedCourse", apl.getCourseName());
        return "details";
    }




    @PostMapping(value = "/save-application")
    public String saveApplication(ApplicationRequestModel application){
        applicationRequestRepository.save(application);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-application")
    public String deleteApplication(@RequestParam(name = "id") Long id){
        applicationRequestRepository.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/add-application")
    public String showAddApplicationPage(Model model) {
        List<String> courseNames = applicationRequestRepository.findAllCourses();
        model.addAttribute("courseNames", courseNames);
        return "addapplication";
    }





//    @PostMapping(value = "/add-music")
//    public String addMusic(MusicModel music){
////    public String addMusic(Music music){
////        manager.addMusic(music);
//        musicRepository.save(music);
//        return "redirect:/"; //response.sendRedirect("/");
//    }
//
//
//    @GetMapping(value = "/music-details")
//    public String getMusic(@RequestParam(name = "musicId") Long id, Model model){
////        Music music = DBManager.getMusic(id);
////        model.addAttribute("muzyka", music);
//        MusicModel music = musicRepository.findById(id).orElse(null);
//        return "details";
//    }
//
//    @GetMapping(value = "/add-music")
//    public String addMusicPage(Model model){
//        return "addmusic";
//    }
//
//    @GetMapping(value = "/details/{musicId}")
//    public String musicDetails(@PathVariable(name = "musicId") Long id, Model model){
//        MusicModel music = musicRepository.findById(id).orElse(null);
//        model.addAttribute("muzyka", music);
//        return "details";
//    }

//    @PostMapping(value = "/save-music")
//    public String saveMusic(MusicModel music){
//        musicRepository.save(music);
//        return "redirect:/";
//    }
//
//    @PostMapping(value = "/delete-music")
//    public String deleteMusic(@RequestParam(name = "id") Long id){
//        musicRepository.deleteById(id);
//        return "redirect:/";
//    }

}



























