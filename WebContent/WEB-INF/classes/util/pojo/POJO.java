package util.pojo;

/**
 * Plain Old Java Object, all interfaces that extends this interface and
 * whose objects are instantiated from the {@link POJOInstantiator} have all
 * the power of a POJO without implementing the actual code. If the interface
 * has the method {@code setXXX( Object o )} and {@code getXXX()} and
 * {@code o} is some object and the code {@code pojo.setXXX( o )} is called,
 * it is guarantied that the statement {@code o == pojo.getXXX()} will be
 * true and in the case of primitives, the values will be more or less the
 * same due to boxing issues
 * <pre>
 * interface Account extends POJO {
 *    // There are no restrictions about types, except that
 *    // setter's must return void or the same interface to achieve a
 *    // a chained method that returns the same object and have one
 *    // parameter or getter's must return something and have no parameters
 *    public void setBooleanProperty( boolean property );
 *    public void setStringProperty( String property );
 *    ...
 *    public boolean getBooleanProperty();
 *    public Object getObjectProperty();
 *    ...
 * }</pre>
 * In order to get new instances of the interface, get them from
 * {@link POJOInstantiator}
 * <pre>
 * Account account = POJOInstantiator.newInstance( Account.class );
 * </pre>
 * @see {@link POJOInstantiator}
 * @author Urbo
 *
 */
public interface POJO {



}

