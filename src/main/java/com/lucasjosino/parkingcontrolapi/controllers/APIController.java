package com.lucasjosino.parkingcontrolapi.controllers;

import com.lucasjosino.parkingcontrolapi.configs.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ApiInfo;

@RestController
@RequestMapping("/")
@Api(tags = "API Controller")
public class APIController {
    @GetMapping
    @Transactional(readOnly = true)
    @ApiOperation("Get all API information.")
    public ResponseEntity<ApiInfo> getAPInfo() {
        return ResponseEntity.ok(SwaggerConfig.metadata());
    }
}
