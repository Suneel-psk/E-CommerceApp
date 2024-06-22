package in.psk.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles_rt")
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer roleId;
	private String rolenName;
	@ManyToMany(mappedBy="roles")
	private List<Users> user;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRolenName() {
		return rolenName;
	}
	public void setRolenName(String rolenName) {
		this.rolenName = rolenName;
	}
	public List<Users> getUser() {
		return user;
	}
	public void setUser(List<Users> user) {
		this.user = user;
	}
	
	
}
