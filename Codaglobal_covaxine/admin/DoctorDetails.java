package admin;

public class DoctorDetails {

	private int doctor_id;
	private String doctor_name;
	private String specialization;
	private String from_slot;
	private String to_slot;
	
	public DoctorDetails(int doctor_id, String doctor_name, String specialization, String from_slot, String to_slot) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.specialization = specialization;
		this.from_slot = from_slot;
		this.to_slot = to_slot;
	}
	
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getFrom_slot() {
		return from_slot;
	}
	public void setFrom_slot(String from_slot) {
		this.from_slot = from_slot;
	}
	public String getTo_slot() {
		return to_slot;
	}
	public void setTo_slot(String to_slot) {
		this.to_slot = to_slot;
	}
	
}
