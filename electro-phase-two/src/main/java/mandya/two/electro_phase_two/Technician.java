package mandya.two.electro_phase_two;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technician {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int technicianId;
    private String technicianName;
    private String username;
    private String password;
    private long contact;
    public Technician() {
    }
    public Technician(int technicianId, String technicianName, String username, String password, long contact) {
        this.technicianId = technicianId;
        this.technicianName = technicianName;
        this.username = username;
        this.password = password;
        this.contact = contact;
    }
    public int getTechnicianId() {
        return technicianId;
    }
    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }
    public String getTechnicianName() {
        return technicianName;
    }
    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getContact() {
        return contact;
    }
    public void setContact(long contact) {
        this.contact = contact;
    }
}
