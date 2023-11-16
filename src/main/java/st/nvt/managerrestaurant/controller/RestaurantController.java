package st.nvt.managerrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.model.service.Restaurant;
import st.nvt.managerrestaurant.model.service.TypeRestaurant;
import st.nvt.managerrestaurant.service.ImagesService;
import st.nvt.managerrestaurant.service.RestaurantService;
import st.nvt.managerrestaurant.service.TypeRestaurantService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {
    @Autowired
    private TypeRestaurantService typeRestaurantService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ImagesService imagesService;
    @GetMapping("/add-restaurant")
    public String showFormAddRestaurant() {

        return "AddRestaurant";
    }

    @GetMapping("/update-infor-restaurant/{id}")
    public String updateInforRes(@PathVariable Long id, Model model) {
        // Lấy thông tin nhà hàng
        Restaurant restaurant = restaurantService.findById(id);
        //Lấy tất cả hình ảnh nhà hàng
        List<Images> images = imagesService.findByRestaurant(restaurant);
        restaurant.setImages(images);
        // Lấy danh sách loại nhà hàng
        List<TypeRestaurant> typeRestaurants = typeRestaurantService.findAll();
        model.addAttribute("typeres", typeRestaurants);
        model.addAttribute("restaurant", restaurant);
        return "UpdateInforRestaurant";
    }

    @PostMapping("/update-infor-restaurant/save")
    public String updateInforRes(@RequestParam("file") MultipartFile[] images, @ModelAttribute("restaurant")Restaurant restaurant) throws IOException {
        List<Images> imagesList = new ArrayList<>();

        if (images != null) {
            File saveFile = new ClassPathResource("static/img").getFile();
            for (MultipartFile imageFile : images) {
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + imageFile.getOriginalFilename());
                Files.copy(imageFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(path);
                Images image = new Images();
                image.setTypeImage(imageFile.getContentType());
                image.setNameImage(imageFile.getOriginalFilename());
                image.setRestaurant(restaurant);
                imagesList.add(image);
            }
            restaurant.setImages(imagesList);
            restaurantService.saveOrUpdate(restaurant);
        }
        return "redirect:/home";
    }
}
