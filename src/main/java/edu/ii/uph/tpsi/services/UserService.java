package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.User;

import java.util.List;

public interface UserService
{
        User create( User user);

        List<User> findAll();

        User update(User user);

        User removeById( Long id);
}
