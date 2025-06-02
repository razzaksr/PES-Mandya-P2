package mandya.two.electro_phase_two;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;
    // CRUD
    public Technician createTech(Technician technician){
        return repository.save(technician);
    }
    public List<Technician> readAll(){
        return repository.findAll();
    }
    public Technician readById(int technicianId){
        return repository.findById(technicianId).orElse(null);
    }
    public void eraseById(int technicianId){
        repository.deleteById(technicianId);
    }
}
