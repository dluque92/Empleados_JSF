package entity;

import entity.Empleado;
import entity.SueldoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T17:42:49")
@StaticMetamodel(Sueldo.class)
public class Sueldo_ { 

    public static volatile SingularAttribute<Sueldo, Date> fechaHasta;
    public static volatile SingularAttribute<Sueldo, SueldoPK> sueldoPK;
    public static volatile SingularAttribute<Sueldo, Empleado> empleado;
    public static volatile SingularAttribute<Sueldo, Integer> cantidad;

}