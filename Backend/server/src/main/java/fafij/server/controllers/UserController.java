package fafij.server.controllers;
import fafij.server.Repository.UserService;
import fafij.server.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    private static final int AUTH_OK= 200;
    private static final int USER_CREATED = 201;
    private static final int USER_UNCREATED = 402;
    private static final int AUTH_FAILURE = 403;
    @PostMapping ("/registration")
    public String registration(@RequestBody Users request) {
        try {
            userService.createUsers(request);
            return USER_CREATED + "";
       }catch (Exception e) {
            return AUTH_FAILURE+"";
        }
    }

    @PostMapping ("/login")
    public String login(@RequestBody Users request) {
        List<Users> usersList = userService.findAllByLogin(request.getLogin());
        if(request.getPassword().equals(usersList.get(0).getPassword())){
        return AUTH_OK+"";}
        else {
            return USER_UNCREATED+"";
        }
    }
}