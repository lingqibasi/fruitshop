package com.qs.fruitshop.controller.rest;


import com.qs.fruitshop.pojo.Address;
import com.qs.fruitshop.pojo.Result;
import com.qs.fruitshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class AddressRest {

    @Autowired
    AddressService addressService;

    @Autowired
    Result<Address> result;

    @ResponseBody
    @RequestMapping(value = "/address/delete/{id}",method = RequestMethod.DELETE)
    public Result<Address> deleteAddress (@PathVariable Integer id){
        addressService.deleteByid(id);
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }
}
