package com.example.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class MainController {

    private static String UPLOADED_FOLDER = "E://Projekty//Gallery//src//main//resources//static//";
    private List<FileRep> fileNameList = new ArrayList<>();

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("files", fileNameList);

        return "index";
    }

    @PostMapping("/")
    public String hello2(@RequestParam("file") MultipartFile file, Model model) throws IOException, InterruptedException {



            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                fileNameList.add(new FileRep(file.getOriginalFilename()));
                model.addAttribute("files", fileNameList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "index";
    }

}
