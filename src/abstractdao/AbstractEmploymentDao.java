package abstractdao;

import java.util.List;

import entity.Employment;

public abstract class AbstractEmploymentDao extends AbstractDao {
	public abstract List<Employment> getAll();

	public abstract boolean updateUserEmployment(Employment e);

	public abstract List<Employment> getUserEmployment(int userId);

	public abstract void addUserEmployment(Employment e);

	public abstract void removeUserEmployments(int userId);
}
