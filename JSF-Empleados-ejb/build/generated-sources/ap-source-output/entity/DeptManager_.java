package entity;

import entity.Departamento;
import entity.DeptManagerPK;
import entity.Empleado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T17:42:49")
@StaticMetamodel(DeptManager.class)
public class DeptManager_ { 

    public static volatile SingularAttribute<DeptManager, DeptManagerPK> deptManagerPK;
    public static volatile SingularAttribute<DeptManager, Date> fechaHasta;
    public static volatile SingularAttribute<DeptManager, Date> fechaDesde;
    public static volatile SingularAttribute<DeptManager, Empleado> empleado;
    public static volatile SingularAttribute<DeptManager, Departamento> departamento;

}