package com.ecommerceApp.ecommerceApp.controller;

import com.ecommerceApp.ecommerceApp.dtos.AddressDto;
import com.ecommerceApp.ecommerceApp.dtos.SellerViewProfileDto;
import com.ecommerceApp.ecommerceApp.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

public class SellerController {

    @Autowired
    SellerService sellerService;
    @GetMapping("/seller/profile")
    public SellerViewProfileDto getProfileDetails(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return sellerService.getSellerProfile(username);
    }

    @PatchMapping("/seller/update_profile")
    public ResponseEntity updateProfileDetails(@RequestBody SellerViewProfileDto profileDto, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return sellerService.updateSellerProfile(username,profileDto);
    }

    @PatchMapping("/seller/update/addresses/{id}")
    public ResponseEntity<String> updateAddress(@Valid @RequestBody AddressDto addressDto, @PathVariable Long id, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return sellerService.updateSellerAddress(username, id, addressDto);
    }
}

