package com.ajaywagh.authcenter.endpoints;

import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/api",method = RequestMethod.POST)
public class ApiEndpoint {


    @RequestMapping(value = "/{*path}",method = RequestMethod.POST)
    public AdminResponse addAdmin(@RequestBody JsonNode node, @RequestHeader Map<String,String> headers, @PathVariable(name = "path") String path){
        log.info("New Request on path \"{}\"  \n[Headers] \n {} \n[Body] \n {}",path,headers,node);
        return null;
    }
}
