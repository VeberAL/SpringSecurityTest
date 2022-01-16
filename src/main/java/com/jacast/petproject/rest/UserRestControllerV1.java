package com.jacast.petproject.rest;

import com.jacast.petproject.model.User_;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {
    private List<User_> Users = Stream.of(
            new User_(1L,"Иван","Иванов"),
            new User_(2L,"Федор","Федоров"),
            new User_(3L,"Константин","Константинов")
    ).collect(Collectors.toList());


    @GetMapping
    public List<User_> getAll(){
        return Users;
    }
    @GetMapping("/{id}")
    public User_ getById(@PathVariable Long id){
        return Users.stream().filter(user_ -> user_.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
