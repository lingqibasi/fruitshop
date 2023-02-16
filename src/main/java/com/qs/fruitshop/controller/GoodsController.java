package com.qs.fruitshop.controller;


import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.GoodsType;
import com.qs.fruitshop.service.GoodsService;
import com.qs.fruitshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("assets/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String List(Model model,@PathVariable Integer page){
        PageInfo<Goods> goodsListByPage = goodsService.goodsListByPage(page);
        model.addAttribute("goodsListByPage",goodsListByPage);
        return "assets/goods/goodsList";
}

    @RequestMapping(value = "/list/{page}",method = RequestMethod.GET)
    public String getGoodsList(Model model,@PathVariable Integer page){
        PageInfo<Goods> goodsListByPage = goodsService.goodsListByPage(page);
        model.addAttribute("goodsListByPage",goodsListByPage);
        System.out.println("goodsListByPage"+goodsListByPage);
        return "assets/goods/goodsList";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(Model model){
        List<GoodsType> typeList = goodsTypeService.typeList();
        model.addAttribute("typeList",typeList);
        return "assets/goods/goodsAdd";
    }

    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public String addGoods(Goods goods, Model model, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String path = "D:/java/images/";// 本地 D:\java\image
//            String path = "/myImage"; //阿里云
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            goods.setGoodsImg(filename);
        }

        Integer result = goodsService.addGoods(goods);
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
    public String toGoodsDetail(Integer id,Model model){
        Goods goodsDetail = goodsService.toGoodsDetailById(id);
        List<GoodsType> typeList = goodsTypeService.typeList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("goodsDetail",goodsDetail);
        return "assets/goods/goodsUpdate";
    }

    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public String updateGoods(Goods goods,MultipartFile file,Model model) throws IOException {

        if (!file.isEmpty()) {
            String path = "D:/java/images/";// 本地 D:\java\image
//            String path = "/myImage"; //阿里云
//            获取文件后缀
            String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);

            String filename = UUID.randomUUID().toString().replace("-","") + "."+ fileSuffix;

            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            goods.setGoodsImg(filename);
        }

        int result = goodsService.updateGoods(goods);
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
    @RequestMapping(value = "/deleteGoods",method = RequestMethod.GET)
    public String deleteGoods(Integer id){
        System.out.println("删除");
        int result = goodsService.deleteGoods(id);
        return "redirect:list/1";
    }

    @RequestMapping(value = "/likeSelectGoods",method = RequestMethod.POST)
    public String likeSelectGoods(Goods goods,Model model){
        PageInfo<Goods> goodsListByPage = goodsService.selectGoodsByNoAndName(goods);
//        System.out.println("条件---"+goodsList);
        model.addAttribute("goodsListByPage",goodsListByPage);
        return "assets/goods/goodsList";
    }

}
