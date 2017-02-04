package util;


/**
 * Interface for the subject
 * @author anmol
 *
 */
public interface SubjectInterface {

	public void addListener(ListenerInterface lobj);
	public void deleteListener(ListenerInterface lobj);
	public void notifyListenener(int val);
}
