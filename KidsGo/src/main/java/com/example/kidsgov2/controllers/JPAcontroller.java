package com.example.kidsgov2.controllers;

import com.example.kidsgov2.models.services.JPAuserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JPAcontroller {
    @Autowired
    private JPAuserDetailService jpAuserDetailService;
    private Logger logger = LoggerFactory.getLogger(JPAuserDetailService.class);


    @GetMapping("listarViajesByUser/")
    public String UserId(Long id) {
        logger.info("ID user: " + id);
        return "redirect:/listarViajesByUser/" + id;
    }
}
