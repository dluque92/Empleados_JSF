package entity;

import entity.DeptEmp;
import entity.DeptManager;
import entity.Puesto;
import entity.Sueldo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T17:42:48")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> apellidos;
    public static volatile SingularAttribute<Empleado, Date> fechaContrato;
    public static volatile CollectionAttribute<Empleado, Sueldo> sueldoCollection;
    public static volatile CollectionAttribute<Empleado, Puesto> puestoCollection;
    public static volatile SingularAttribute<Empleado, Integer> empNo;
    public static volatile SingularAttribute<Empleado, String> sexo;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile CollectionAttribute<Empleado, DeptEmp> deptEmpCollection;
    public static volatile SingularAttribute<Empleado, Date> nacimiento;
    public static volatile CollectionAttribute<Empleado, DeptManager> deptManagerCollection;

}