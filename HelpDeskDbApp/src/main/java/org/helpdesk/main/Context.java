package org.helpdesk.main;

import org.helpdesk.dao.impl.UserDaoImpl;
import org.helpdesk.dao.inter.UserDaoInter;

public class Context {

     public static UserDaoInter userDaoImpl(){
         return new UserDaoImpl();
}
}
