package com.example.soccer_1.controller;


import com.example.soccer_1.service.SoccerV1Service;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1")
@Log4j2
public class SoccerV1 {

    @Autowired
    SoccerV1Service v1Service;

    @GetMapping("/soccer")
    public String doSoccer(Model model) {

        /* 전체리스트 조회*/
        List<Map<String, String>> list = v1Service.doSoccerList();

        model.addAttribute("list", list);

        // System.out.println(list);

        return "/v1/soccer";
    }
    @PostMapping ("/soccer")
    public String doSoccerPost(HttpServletRequest request, Model model) {

        String strStart_date = request.getParameter("start_date");
        String strEnd_date = request.getParameter("end_date");
        String strName = request.getParameter("name");
        String strKind = request.getParameter("kind");
        log.info(strKind);


        /* 전체리스트 조회 - 오버로딩*/
        List<Map<String, String>> list = v1Service.doSoccerList(strStart_date, strEnd_date, strName, strKind);

        model.addAttribute("list", list);

        // System.out.println(list);

        return "/v1/soccer";
    }

    /* 등록하기 Get */
    @GetMapping("/insert")
    public String doInsert() {
        return "/v1/soccer_Ins";
    }

    /* 등록하기 Post, HttpServletRequest 사용 */
    @PostMapping("/insert")
    public String doInsertPost(@RequestParam(value = "name") String name,
                               @RequestParam(value= "kind") String kind,
                               @RequestParam(value= "price") String price,
                               Model model) {
        log.info(name + kind + price);
        int intI = v1Service.doInsert(name, kind, price);

        return "redirect:/v1/soccer";
    }

    /* 수정하기 Get */
    @GetMapping("/update")
    public String doUpdate(@RequestParam(value="soccer_id") String strSoccer_id, Model model) {

        Map<String, String> map = v1Service.doListOne(strSoccer_id);
        model.addAttribute("map", map);

        return "/v1/soccer_Up";
    }

    /* 수정하기 Post */
    @PostMapping("/update")
    public String doUpdatePost(
            @RequestParam(value = "soccer_id") String strSoccer_id,
            @RequestParam(value= "name") String strName,
            @RequestParam(value= "kind") String strKind,
            @RequestParam(value= "price") String strPrice
    ){

        int intI = v1Service.doUpdate(strSoccer_id, strName, strKind, strPrice);

        return "redirect:/v1/soccer";
    }

    /* 삭제하기 */
    @GetMapping("/delete")
    public String doDelete(@RequestParam(value="soccer_id") String strSoccer_id) {

        int intI = v1Service.doDelete(strSoccer_id);

        return "redirect:/v1/soccer";
    }

}
