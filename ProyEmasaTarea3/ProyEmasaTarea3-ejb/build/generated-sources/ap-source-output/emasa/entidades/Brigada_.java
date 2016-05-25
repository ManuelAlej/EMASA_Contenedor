package emasa.entidades;

import emasa.entidades.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T01:20:52")
@StaticMetamodel(Brigada.class)
public class Brigada_ { 

    public static volatile SingularAttribute<Brigada, Integer> numBrigada;
    public static volatile SingularAttribute<Brigada, Integer> turno;
    public static volatile SingularAttribute<Brigada, Character> contrata;
    public static volatile CollectionAttribute<Brigada, Empleado> miembros;

}