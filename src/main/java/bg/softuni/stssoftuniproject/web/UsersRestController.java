package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/users-all")
public class UsersRestController {
    private final UserService userService;

    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }
}
