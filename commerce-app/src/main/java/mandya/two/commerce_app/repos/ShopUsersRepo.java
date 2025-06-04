package mandya.two.commerce_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mandya.two.commerce_app.entities.ShopUsers;

@Repository
public interface ShopUsersRepo extends JpaRepository<ShopUsers,Integer>{
    ShopUsers findByUsername(String username);
}
