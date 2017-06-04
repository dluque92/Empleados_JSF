package entity;

import entity.DeptEmp;
import entity.DeptManager;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T17:42:48")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> nombre;
    public static volatile SingularAttribute<Departamento, String> deptNo;
    public static volatile CollectionAttribute<Departamento, DeptEmp> deptEmpCollection;
    public static volatile CollectionAttribute<Departamento, DeptManager> deptManagerCollection;

}