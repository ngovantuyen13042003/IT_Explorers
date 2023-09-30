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
import java.util.*;

@Controller
@RequestMapping("/api/v1")
public class HomeController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private ImagesService imagesService;

    @GetMapping("/home")
    public String menu(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 9;
        Page<Food> foodPage = foodService.listFoods(page, pageSize);

        // Tạo một danh sách mới chứa các món ăn với một hình ảnh duy nhất
        List<Food> menuWithImages = new ArrayList<>();

        for (Food food : foodPage.getContent()) {
            List<Images> images = imagesService.findByFood(food);

            if (!images.isEmpty()) {
                // Chỉ lấy một hình ảnh đầu tiên cho món ăn
                food.setImages(Collections.singletonList(images.get(0)));
                System.out.println(images.get(0).getNameImage());
            } else {
                // Nếu không có hình ảnh nào, thì tạo một danh sách rỗng
                food.setImages(Collections.emptyList());
            }
            menuWithImages.add(food);
        }
        model.addAttribute("menu", menuWithImages);
        model.addAttribute("page", foodPage);


        return "Home";
    }

    @GetMapping("/food/detail/{id}")
    public String showFoodDetail(@PathVariable Long id, Model model) {
        Food food = foodService.findById(id);
        List<Images> images = imagesService.findByFood(food);
        food.setImages(images);
        model.addAttribute("food",food);
        return "detail";
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
                System.out.println(path);
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
        return "redirect:/api/v1/home";
    }
}
