package org.helpdesk.dao.inter;

import org.helpdesk.bean.Users;

import java.util.List;

public interface UserDaoInter {

    List<Users>getAllUser();

    public boolean updateUser(Users u);

    public boolean removeUser(int id);
}
