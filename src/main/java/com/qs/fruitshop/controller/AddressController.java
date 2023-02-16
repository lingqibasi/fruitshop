package com.qs.fruitshop.controller;


import com.qs.fruitshop.pojo.Address;
import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Orders;
import com.qs.fruitshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/front/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/address",method = RequestMethod.POST)
    public String addAddress(@RequestBody Orders orders, HttpSession session, Model model){
//        redirectAttributes.addFlashAttribute("orders",orders);
        session.setAttribute("orders",orders);
        return "/front/address/address";
    }

    @RequestMapping(value = "/addresslist")
    public String addresslist(Model model,HttpSession session){
        Orders orders = (Orders) session.getAttribute("orders");
        List<Address> addressList = addressService.selectAllAddressById(orders.getUid());
        model.addAttribute("addressList",addressList);

        System.out.println("orders"+orders);

        return "/front/address/address";
    }

    @RequestMapping(value = "/insertaddress", method = RequestMethod.POST)
        public String address(Address address){

        System.out.println("address--------"+address);
        addressService.insert(address);
        return "redirect:/front/address/addresslist";
        }


}
