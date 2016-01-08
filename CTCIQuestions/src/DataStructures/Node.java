package DataStructures;

import java.util.List;

/**
 * Interface used by all Tree nodes
 * @author Brian
 *
 * @param <T>
 */
public interface Node<T>{
	public T getData();
	public void setData(T data);
	List<Node<T>> getChildren();
}