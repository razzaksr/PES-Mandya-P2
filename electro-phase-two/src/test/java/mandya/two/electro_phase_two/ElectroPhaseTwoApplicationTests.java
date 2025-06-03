package mandya.two.electro_phase_two;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import mandya.two.electro_phase_two.models.Technician;

@SpringBootTest
class ElectroPhaseTwoApplicationTests {

	@Mock
	private TechnicianRepository repository;
	@InjectMocks
	private TechnicianService service;

	@BeforeEach
    void settingUp(){
        MockitoAnnotations.openMocks(this);
    }
	@Test
    void testGetAllTechnicians() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Technician(1,"Prakash","prakash","vinayak",7656765467L),
				new Technician(9,"Richard","richard","armstrong",876578767L),
				new Technician(11,"Dheena","dheena","dhayal",8765787657L)
        ));
        assertEquals(3, service.readAll().size());
    }
	@Test
    void testGetAllTechnicians1() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Technician(1,"Prakash","prakash","vinayak",7656765467L),
				new Technician(9,"Richard","richard","armstrong",876578767L),
				new Technician(11,"Dheena","dheena","dhayal",8765787657L)
        ));
        assertNotSame("sabari", service.readAll().get(1).getUsername());
    }
    @Test
    void testGetById() {
        when(repository.findById(1)).thenReturn(Optional.of(new Technician(1,"Prakash","prakash","vinayak",7656765467L)));
        Technician technician = service.readById(1);
        assertEquals(7656765467L, technician.getContact());
    }
	@Test
    void testGetById1() {
        when(repository.findById(1)).thenReturn(Optional.of(new Technician(1,"Prakash","prakash","vinayak",76567654111L)));
        Technician technician = service.readById(1);
        assertFalse(7656765467L==technician.getContact());
    }
	@Test
	void testSave(){
		Technician technician1 = new Technician(1,"Prakash","prakash","vinayak",7656765467L);
		Technician technician2 = new Technician(9,"Richard","richard","armstrong",876578767L);
		Technician technician3 = new Technician(11,"Dheena","dheena","dhayal",8765787657L);
		when(repository.save(technician1)).thenReturn(technician1);
		assertTrue(service.createTech(technician1).getTechnicianName().equals("Prakash"));
	}
	@Test
	void testSave1(){
		Technician technician1 = new Technician(1,"Prakash","prakash","vinayak",7656765467L);
		Technician technician2 = new Technician(9,"Richard","richard","armstrong",876578767L);
		Technician technician3 = new Technician(11,"Dheena","dheena","dhayal",8765787657L);
		when(repository.save(technician2)).thenReturn(technician2);
		assertFalse(service.createTech(technician2).getTechnicianName().equals("Dheena"));
	}
	@Test
    void testDelete() {
        when(repository.existsById(1)).thenReturn(true);
        doNothing().when(repository).deleteById(1);
        service.eraseById(1);
        verify(repository, times(1)).deleteById(1);
    }
}
