package mandya.two.commerce_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mandya.two.commerce_app.entities.Laptop;
import mandya.two.commerce_app.repos.LaptopRepo;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepo repo;

    // CRUD
    public Laptop addStock(Laptop laptop){
        return repo.save(laptop);
    }
    public List<Laptop> readAll(){
        return repo.findAll();
    }
    public Laptop readByModel(String model){
        return repo.findById(model).orElse(null);
    }
    public void eraseByModel(String model){
        repo.deleteById(model);
    }
}
