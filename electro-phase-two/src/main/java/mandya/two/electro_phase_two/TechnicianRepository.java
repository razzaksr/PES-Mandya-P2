package mandya.two.electro_phase_two;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import mandya.two.electro_phase_two.models.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Integer>, JpaSpecificationExecutor<Technician>{
    
}
