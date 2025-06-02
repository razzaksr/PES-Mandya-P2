package mandya.two.electro_phase_two;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicianApi {
    @Autowired
    private TechnicianService service;

    // CRUD endpoints
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        service.eraseById(id);
    }
    @GetMapping("/{technicianId}")
    public Technician callReadOne(@PathVariable int technicianId){
        return service.readById(technicianId);
    }
    @GetMapping("/")
    public List<Technician> callReadAll(){
        return service.readAll();
    }
    @PostMapping("/")
    public Technician callCreate(@RequestBody Technician technician){
        return service.createTech(technician);
    }

}
