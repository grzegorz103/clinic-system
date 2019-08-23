package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService
{
        User create( User user);

        boolean isLoginCorrect(String username, String password);

        boolean hasAdminRole ();
}
