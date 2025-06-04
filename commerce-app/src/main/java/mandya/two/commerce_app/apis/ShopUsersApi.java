package mandya.two.commerce_app.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mandya.two.commerce_app.entities.ShopUsers;
import mandya.two.commerce_app.services.ShopUsersService;

@RestController
@RequestMapping("/api/users")
public class ShopUsersApi {
    @Autowired
    private ShopUsersService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // SignUp
    @PostMapping("/")
    public ShopUsers createNewUSer(@RequestBody ShopUsers shopUsers){
        shopUsers.setPassword(passwordEncoder.encode(shopUsers.getPassword()));
        return service.newUser(shopUsers);
    }
}
