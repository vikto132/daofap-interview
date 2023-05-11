package com.backend.controllers;

import com.backend.dto.ResponseError;
import com.backend.services.ChildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("child")
public class ChildController {
    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/{parentId}")
    public ResponseEntity getChildByParentId(@PathVariable Long parentId) {
        try {
            return new ResponseEntity<>(this.childService.getListChildByParentId(parentId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseError(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
