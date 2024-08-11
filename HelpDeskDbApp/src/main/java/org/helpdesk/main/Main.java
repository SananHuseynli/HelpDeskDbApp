package org.helpdesk.main;


import org.helpdesk.bean.Users;
import org.helpdesk.dao.impl.UserDaoImpl;
import org.helpdesk.dao.inter.UserDaoInter;


import java.util.List;

public class Main {


    public static void main(String[] args)  {
        UserDaoInter userDaoInter=Context.userDaoImpl();

        List<Users>usersList=userDaoInter.getAllUser();



    }
}