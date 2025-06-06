package mandya.two.commerce_app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mandya.two.commerce_app.entities.ShopUsers;
import mandya.two.commerce_app.repos.ShopUsersRepo;

@Service
public class ShopUsersService implements UserDetailsService{
    @Autowired
    private ShopUsersRepo repo;

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Shop users CRUD

    public ShopUsers newUser(ShopUsers users){
        return repo.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("user "+username+" trying fetch the details");
        ShopUsers shopUsers = repo.findByUsername(username);
        if(shopUsers==null)
            throw new UsernameNotFoundException(username);
        logger.info(username+" matched");
        return shopUsers;
    }
}
