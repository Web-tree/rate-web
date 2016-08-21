package org.webtree.rate.web.model;

import com.google.common.collect.Lists;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
    private String username;
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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
