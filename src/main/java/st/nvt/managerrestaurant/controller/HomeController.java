package st.nvt.managerrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import st.nvt.managerrestaurant.dto.FoodDTO;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.service.FoodService;
import st.nvt.managerrestaurant.service.ImagesService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private ImagesService imagesService;

    @GetMapping
    public String menu(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 9;
        Page<Food> foodPage = foodService.listFoods(page,pageSize);
        model.addAttribute("menu", foodPage.getContent());
        model.addAttribute("page", foodPage);
        model.addAttribute("imgs", imagesService.findAll());
        return "Home";
    }

    @GetMapping("/creation-food")
    public String showFormAddFood(@ModelAttribute Food food, Model model) {
        model.addAttribute("food", food);
        return "CreationFood";
    }

    @PostMapping("/add-food")
    public String creationFood(@RequestParam("file") MultipartFile[] images, @ModelAttribute("food")Food food) throws IOException {
        List<Images> imagesList = new ArrayList<>();

        if(images != null){
            File saveFile = new ClassPathResource("static/img").getFile();
            for(MultipartFile imageFile : images) {
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + imageFile.getOriginalFilename());
                Files.copy(imageFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                Images image = new Images();
                image.setDataImage(imageFile.getBytes());
                image.setTypeImage(imageFile.getContentType());
                image.setNameImage(imageFile.getOriginalFilename());
                image.setFood(food);
                imagesList.add(image);
            }
            food.setImages(imagesList);
            foodService.saveOrUpdate(food);
        }
        return "redirect:/";
    }





}
