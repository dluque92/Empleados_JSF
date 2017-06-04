package entity;

import entity.Departamento;
import entity.DeptEmpPK;
import entity.Empleado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T17:42:48")
@StaticMetamodel(DeptEmp.class)
public class DeptEmp_ { 

    public static volatile SingularAttribute<DeptEmp, DeptEmpPK> deptEmpPK;
    public static volatile SingularAttribute<DeptEmp, Date> fechaHasta;
    public static volatile SingularAttribute<DeptEmp, Date> fechaDesde;
    public static volatile SingularAttribute<DeptEmp, Empleado> empleado;
    public static volatile SingularAttribute<DeptEmp, Departamento> departamento;

}