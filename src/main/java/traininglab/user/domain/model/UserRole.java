package traininglab.user.domain.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "user_role")
public class UserRole implements GrantedAuthority {

	@Id
	private String role;

	@Override
	public String getAuthority() {
		return this.role;
	}
}
