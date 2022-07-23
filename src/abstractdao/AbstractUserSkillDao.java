package abstractdao;

import java.util.List;

import entity.Skill;
import entity.UserSkill;

public abstract class AbstractUserSkillDao extends AbstractDao {
	public abstract List<UserSkill> getUserSkills(int id);

	public abstract void addUserSkill(int userId, Skill skill, int power);

	public abstract void removeUserSkills(int userId);

	public abstract String getSkillName(UserSkill us);
}
