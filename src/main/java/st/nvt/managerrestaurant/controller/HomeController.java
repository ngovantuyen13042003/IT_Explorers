package st.nvt.managerrestaurant.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import st.nvt.managerrestaurant.dto.AccountDTO;
import st.nvt.managerrestaurant.model.account.Account;
import st.nvt.managerrestaurant.model.account.Customer;
import st.nvt.managerrestaurant.model.service.Cart;
import st.nvt.managerrestaurant.model.service.Food;
import st.nvt.managerrestaurant.model.service.Images;
import st.nvt.managerrestaurant.service.*;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.*;

@Controller
@SessionAttributes("account")
public class HomeController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerService customerService;
    @Autowired
    IAccountService accountService;

    @ModelAttribute("account")
    public AccountDTO accountDTO(){
        return new AccountDTO();
    }

    @GetMapping("/home")
    public String menu(@RequestParam(defaultValue = "0") int page, Model model, Principal principal, HttpServletResponse response, HttpSession session) throws Exception{

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


        // cart
        if(principal != null) {
            Account account = accountService.findByUserName(principal.getName());
            Customer customer = customerService.findById(account.getCustomerId()).orElseThrow(
                    () -> new Exception()
            );
            List<Cart> carts = cartService.getAll(customer.getId());


            double totalBill = 0.0;
            int totalQuantity = 0;
            for (Cart cart : carts) {
                totalBill += cart.getTotalPrice();
                totalQuantity += cart.getTotalItems();
            }

            model.addAttribute("totalBill", totalBill);
            session.setAttribute("totalQuantity", totalQuantity);
            Cookie cookie = new Cookie("totalQuantity", String.valueOf(totalQuantity));
            cookie.setAttribute("totalQuantity", String.valueOf(totalQuantity));
            cookie.setMaxAge(3600 * 3600 );
            response.addCookie(cookie);
            model.addAttribute("carts", carts);
        }


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
    public String showFormAddFood(@ModelAttribute Food food, Model model, Principal principal) {

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
                image.setTypeImage(imageFile.getContentType());
                image.setNameImage(imageFile.getOriginalFilename());
                image.setFood(food);
                imagesList.add(image);
            }
            food.setImages(imagesList);
            foodService.saveOrUpdate(food);
        }
        return "redirect:/home";
    }

    @GetMapping("/about-us/privacy-policy")
    public String showPolicy() {
        return "privacyPolicy";
    }

    @GetMapping("/about-us/terms-and-conditions")
    public String showTerms() {
        return "terms";
    }


}
