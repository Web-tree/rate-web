package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Max
 *         Created on 7/25/2016.
 */
@Data
@NodeEntity
public class User implements GraphModel, UserDetails {
    @GraphId
    private Long id;
//    @Indexed(unique = true)
    @Size(min = 3, max = 30)
    @NotNull
    private String username;
    @JsonIgnore
    @Min(6)
    @NotNull
    private String password;
    private String displayName;

    @Relationship(type = "CREATION")
    private List<Item> items;

    private Long rate = 0L;

    private transient List<GrantedAuthority> authorities = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"));

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
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
