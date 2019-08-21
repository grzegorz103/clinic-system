package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.models.User;
import edu.ii.uph.tpsi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
        private final UserRepository userRepository;

        @Autowired
        public UserServiceImpl ( UserRepository userRepository )
        {
                this.userRepository = userRepository;
        }

        @Override
        public User create ( @NotNull User user )
        {
                return null;
        }

        @Override
        public List<User> findAll ()
        {
                return null;
        }

        @Override
        public User update ( User doctor )
        {
                return null;
        }

        @Override
        public User removeById ( Long id )
        {
                return null;
        }
}
