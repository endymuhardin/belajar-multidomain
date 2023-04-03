package com.example.demomultidomain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RegistrasiController {

    private static final String DOMAIN_KARYAWAN = "karyawan.example.com";
    private static final String DOMAIN_REGULER = "reguler.example.com";

    @GetMapping("/")
    public String daftar(@RequestHeader(name="Host", required=false) final String host, ModelMap model){
        log.info("Hostname : {}", host);
        model.addAttribute("host", host);

        if(host.contains(DOMAIN_KARYAWAN)) {
            return "karyawan";
        } else if (host.contains(DOMAIN_REGULER)) {
            return "reguler";
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "domain tidak dikenali"
        );
    }
}
