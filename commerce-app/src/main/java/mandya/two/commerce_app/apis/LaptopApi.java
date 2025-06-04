package mandya.two.commerce_app.apis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mandya.two.commerce_app.entities.Laptop;
import mandya.two.commerce_app.services.LaptopService;

@RestController
@RequestMapping("/api/laptop")
public class LaptopApi {
    @Autowired
    private LaptopService service;

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Laptop endpoints
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/new")
    public Laptop callCreate(@RequestBody Laptop laptop){
        logger.info("admin trying to add new laptop");
        return service.addStock(laptop);
    }
    @PreAuthorize("hasAnyAuthority('admin','customer')")
    @GetMapping("/view")
    public List<Laptop> callREadAll(){
        return service.readAll();
    }
    @PreAuthorize("hasAnyAuthority('admin','customer')")
    @GetMapping("/by/{model}")
    public Laptop callReadOne(@PathVariable String model){

        return service.readByModel(model);
    }
    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/remove/{model}")
    public void callDelete(@PathVariable String model){
        service.eraseByModel(model);
    }
}
