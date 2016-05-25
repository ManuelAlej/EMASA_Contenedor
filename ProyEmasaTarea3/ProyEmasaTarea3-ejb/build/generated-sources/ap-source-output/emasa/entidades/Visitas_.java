package emasa.entidades;

import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T23:46:24")
@StaticMetamodel(Visitas.class)
public class Visitas_ { 

    public static volatile SingularAttribute<Visitas, Empleado> idEmpleado;
    public static volatile SingularAttribute<Visitas, Date> fechaVisita;
    public static volatile SingularAttribute<Visitas, Historico> historico;
    public static volatile SingularAttribute<Visitas, Integer> idVisita;

}