package abstractdao;

import java.util.List;

import entity.User;

public abstract class AbstractUserDao extends AbstractDao {

	public abstract List<User> getAll();

	public abstract User getById(int userId) throws Exception;

	public abstract boolean updateUser(User u);

	public abstract boolean insertUser(User u);

	public abstract boolean removeUser(int id);
}
