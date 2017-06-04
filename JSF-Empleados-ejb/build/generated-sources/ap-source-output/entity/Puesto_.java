package entity;

import entity.Empleado;
import entity.PuestoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-04T17:42:49")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, Date> fechaHasta;
    public static volatile SingularAttribute<Puesto, Empleado> empleado;
    public static volatile SingularAttribute<Puesto, PuestoPK> puestoPK;

}