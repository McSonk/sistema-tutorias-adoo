package util.pojo;

/**
 * Plain Old Java Object validator, accepts a
 * whose objects are instantiated from the {@link POJOInstantiator} have
 * 
 * @see {@link POJO}
 * @see {@link POJOInstantiator}
 * @author Urbo
 *
 */
public interface POJOValidator<T extends POJO> {

	public void validate(T pojo);

}

