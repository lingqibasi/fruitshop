package com.qs.fruitshop.controller;



import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.GoodsType;
import com.qs.fruitshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/assets/type")
public class GoodsTypeController {

    @Autowired
    GoodsTypeService goodsTypeService;


    @RequestMapping(value = "/list/{page}",method = RequestMethod.GET)
    public String getList(Model model, @PathVariable Integer page){
        PageInfo<GoodsType> typePage = goodsTypeService.list(page);
        model.addAttribute("typePage",typePage);
        System.out.println("typeByPage"+typePage);
        return "assets/type/typeList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "assets/type/typeAdd";
    }

    @RequestMapping(value = "/addType",method = RequestMethod.POST)
    public String addGoodsType(GoodsType type, Model model) throws IOException {
        int result = goodsTypeService.insert(type);
        if (result == 1) {
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "增加成功！");
            model.addAttribute("second", 2);
        } else {
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "增加失败！");
            model.addAttribute("second", 2);
        }
        return "tip";
    }

    @RequestMapping(value = "/toDetail",method = RequestMethod.GET)
    public String toDetail(Integer id,Model model){
        GoodsType typeDetail = goodsTypeService.queryById(id);
        model.addAttribute("typeDetail",typeDetail);
        return "assets/type/typeUpdate";
    }

    @RequestMapping(value = "/updateType",method = RequestMethod.POST)
    public String updateType(GoodsType type,Model model) throws IOException {

        int result = goodsTypeService.updateById(type);
        if (result == 1) {
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "修改成功！");
            model.addAttribute("second", 2);
        } else {
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "修改失败！");
            model.addAttribute("second", 2);
        }
        return "tip";

    }

    //    @GetMapping(value = "/deleteGoods")
    @RequestMapping(value = "/deleteType",method = RequestMethod.GET)
    public String delete(Integer id){
        System.out.println("删除");
        int result = goodsTypeService.deleteById(id);
        return "redirect:list/1";
    }


}
