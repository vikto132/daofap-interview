package com.backend.controllers;

import com.backend.dto.Page;
import com.backend.dto.ParentDto;
import com.backend.services.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("parent")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping()
    public ResponseEntity<Page<ParentDto>> getParents(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int pageSize) {
        return new ResponseEntity<>(this.parentService.getParents(page, pageSize), HttpStatus.OK);
    }
}
