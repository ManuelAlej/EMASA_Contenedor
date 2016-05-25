package emasa.entidades;

import emasa.entidades.Aviso;
import emasa.entidades.Cliente;
import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T01:20:52")
@StaticMetamodel(Aviso.class)
public class Aviso_ { 

    public static volatile SingularAttribute<Aviso, Empleado> idEmpleado;
    public static volatile CollectionAttribute<Aviso, Aviso> avisosRelacionados;
    public static volatile CollectionAttribute<Aviso, Historico> historico;
    public static volatile SingularAttribute<Aviso, Aviso> relacionado;
    public static volatile SingularAttribute<Aviso, Date> fechaEntrada;
    public static volatile SingularAttribute<Aviso, Integer> idAviso;
    public static volatile SingularAttribute<Aviso, String> origen;
    public static volatile SingularAttribute<Aviso, Cliente> dni;

}