package com.andygomez.main.service;

import com.andygomez.main.dto.UserDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${spring.external.base.url}")
    private String basePath;

    private final RestTemplate template;
    public List<UserDTO> getAllUsers(){
        UserDTO[] response = template.getForObject(basePath+"/users",UserDTO[].class);
        return Arrays.asList(response);
    }

    public void saveUser(UserDTO user){
        template.postForObject(basePath+"/users",user, UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO user){
        template.put(basePath+"/users/"+ id, user);
    }

    public void deleteUser(Integer id){
        template.delete(basePath+"/users/"+id);
    }

}
