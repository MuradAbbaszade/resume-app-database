package abstractdao;

import java.util.List;

import entity.Skill;

public abstract class AbstractSkillDao extends AbstractDao {
	public abstract List<Skill> getAll();

}
