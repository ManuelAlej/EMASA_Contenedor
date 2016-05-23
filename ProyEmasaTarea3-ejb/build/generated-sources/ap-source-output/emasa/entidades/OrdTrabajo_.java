package emasa.entidades;

import emasa.entidades.Actuaciones;
import emasa.entidades.Brigada;
import emasa.entidades.Historico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-23T20:24:30")
@StaticMetamodel(OrdTrabajo.class)
public class OrdTrabajo_ { 

    public static volatile SingularAttribute<OrdTrabajo, String> trabajoARealizar;
    public static volatile SingularAttribute<OrdTrabajo, String> estado;
    public static volatile CollectionAttribute<OrdTrabajo, Actuaciones> actuaciones;
    public static volatile SingularAttribute<OrdTrabajo, Historico> historico;
    public static volatile SingularAttribute<OrdTrabajo, Date> fechaCreacion;
    public static volatile SingularAttribute<OrdTrabajo, Brigada> numBrigada;
    public static volatile SingularAttribute<OrdTrabajo, Integer> idOrden;
    public static volatile SingularAttribute<OrdTrabajo, Date> fechaFinalizacion;

}