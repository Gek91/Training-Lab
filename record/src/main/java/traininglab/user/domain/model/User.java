package traininglab.user.domain.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity(name = "users")
public class User implements UserDetails {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String password;
	private boolean enabled;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<UserRole> userRoles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.userRoles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
