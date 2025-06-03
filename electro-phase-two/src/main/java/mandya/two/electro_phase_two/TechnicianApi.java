package mandya.two.electro_phase_two;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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

    // Specification endpoint
    @PostMapping("/specs")
    public ResponseEntity<Page<Technician>> getTechnicians(
        @RequestBody SearchRequest searchRequest) {

        Sort sort = searchRequest.getSortDir().equalsIgnoreCase("asc") 
                    ? Sort.by(searchRequest.getSortBy()).ascending() 
                    : Sort.by(searchRequest.getSortBy()).descending();

        Pageable pageable = PageRequest.of(searchRequest.getPage(), searchRequest.getSize(), sort);
        Page<Technician> products = service.getFilteredTechnicians(searchRequest.getFilters(), pageable);
        return ResponseEntity.ok(products);
    }

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
