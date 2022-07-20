package org.icmic.icmicweb.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/pay")
public class PayController {

    @PostMapping("/ok")
    public String ok(@RequestParam("Userid") String userId,
                     @RequestParam("Username") String userName,
                     @RequestParam("Signdate") @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime payDate,
                     @RequestParam("Prdtnm") String productName,
                     @RequestParam("Prdtprice") String price,
                     Model model) {

        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        model.addAttribute("payDate", payDate);
        model.addAttribute("productName", productName);
        model.addAttribute("price", price);

        return "pay/ok";
    }
}
