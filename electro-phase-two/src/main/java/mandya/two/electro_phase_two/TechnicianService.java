package mandya.two.electro_phase_two;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import mandya.two.electro_phase_two.models.SearchCriteria;
import mandya.two.electro_phase_two.models.Technician;
import mandya.two.electro_phase_two.models.TechnicianSpecification;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;

    // Specification>> filter, pagination, sorting
    public Page<Technician> getFilteredTechnicians(List<SearchCriteria> criteriaList, Pageable pageable) {
        Specification<Technician> spec = Specification.where(null);
        for (SearchCriteria criteria : criteriaList) {
            spec = spec.and(new TechnicianSpecification(criteria));
        }
        return repository.findAll(spec, pageable);
    }

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
