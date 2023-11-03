package st.nvt.managerrestaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

    @GetMapping("/reservation")
    public String viewReservation() {
        return "Reservation";
    }

    @GetMapping("/reservation/confirm")
    public String viewConfirmReservation() {
        return "confirmationPage";
    }

    @PostMapping("/reservation/bookTable")
    public ModelAndView bookTable(
            @RequestParam("days") String day,
            @RequestParam("hours") String hour,
            @RequestParam("fullName") String fullName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("numPersons") int numPersons,
            Model model) {


        // Xử lý đặt bàn ở đây
        // Đây là nơi bạn có thể gọi các phương thức lưu trữ thông tin đặt bàn vào cơ sở dữ liệu hoặc thực hiện các hành động khác

        // Truyền thông tin đặt bàn vào model để hiển thị trên trang xác nhận
        model.addAttribute("day", day);
        model.addAttribute("hour", hour);
        model.addAttribute("fullName", fullName);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("numPersons", numPersons);

        // Chuyển hướng đến trang xác nhận
        ModelAndView modelAndView = new ModelAndView("confirmationPage");
        return modelAndView;
    }
}
