package com.italo.santana.telegram_backend.models.entities;

import com.italo.santana.telegram_backend.enums.UserRole;
import com.italo.santana.telegram_backend.models.dtos.RegisterDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "TB_USERS")
public class UserModel implements UserDetails {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;


    public UserModel(String fullName, String email, String password, UserRole role){
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserModel(RegisterDTO data){
        this.fullName = data.fullName();
        this.email = data.email();
        this.password = data.password();
        this.role = data.userRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.OWNER) return List.of(new SimpleGrantedAuthority("ROLE_OWNER"), new SimpleGrantedAuthority("ROLE_EMPLOYER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword(){
        return password;
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
