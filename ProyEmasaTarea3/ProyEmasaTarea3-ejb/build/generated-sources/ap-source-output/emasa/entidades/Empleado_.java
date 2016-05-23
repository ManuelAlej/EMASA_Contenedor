package emasa.entidades;

import emasa.entidades.Aviso;
import emasa.entidades.Brigada;
import emasa.entidades.Historico;
import emasa.entidades.Visitas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-23T23:11:34")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> apellidos;
    public static volatile CollectionAttribute<Empleado, Historico> historico;
    public static volatile SingularAttribute<Empleado, Integer> turno;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, String> especialidad;
    public static volatile SingularAttribute<Empleado, String> eMail;
    public static volatile CollectionAttribute<Empleado, Visitas> visitas;
    public static volatile SingularAttribute<Empleado, String> zona;
    public static volatile SingularAttribute<Empleado, String> password;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile CollectionAttribute<Empleado, Aviso> avisos;
    public static volatile SingularAttribute<Empleado, String> departamento;
    public static volatile SingularAttribute<Empleado, Brigada> numBrigada;
    public static volatile SingularAttribute<Empleado, String> cargo;
    public static volatile SingularAttribute<Empleado, String> dni;

}