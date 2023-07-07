package com.sanndag.login.logic;

import com.sanndag.login.logic.Role;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-07T14:19:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, Role> userRole;
    public static volatile SingularAttribute<User, String> username;

}