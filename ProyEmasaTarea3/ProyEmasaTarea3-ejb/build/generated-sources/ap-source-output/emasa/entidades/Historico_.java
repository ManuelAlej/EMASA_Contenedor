package emasa.entidades;

import emasa.entidades.Aviso;
import emasa.entidades.Empleado;
import emasa.entidades.HistoricoPK;
import emasa.entidades.OrdTrabajo;
import emasa.entidades.Visitas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T23:46:24")
@StaticMetamodel(Historico.class)
public class Historico_ { 

    public static volatile SingularAttribute<Historico, String> descripcion;
    public static volatile SingularAttribute<Historico, String> ubicacionGps;
    public static volatile SingularAttribute<Historico, String> estado;
    public static volatile SingularAttribute<Historico, String> redAgua;
    public static volatile SingularAttribute<Historico, Boolean> duplicado;
    public static volatile SingularAttribute<Historico, String> causa;
    public static volatile SingularAttribute<Historico, String> direccion;
    public static volatile SingularAttribute<Historico, HistoricoPK> historicoPK;
    public static volatile SingularAttribute<Historico, Visitas> visitas;
    public static volatile SingularAttribute<Historico, String> tipoAviso;
    public static volatile SingularAttribute<Historico, Date> fechaCierre;
    public static volatile SingularAttribute<Historico, String> docAdjunto;
    public static volatile SingularAttribute<Historico, Empleado> idEmpleado;
    public static volatile SingularAttribute<Historico, String> urgencia;
    public static volatile SingularAttribute<Historico, Aviso> aviso;
    public static volatile CollectionAttribute<Historico, OrdTrabajo> ordenesTrabajo;

}