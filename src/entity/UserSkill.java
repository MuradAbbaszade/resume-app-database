package entity;

public class UserSkill {
	private int skillId;
	private int power;
	private int userId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserSkill(int skillId, int power, int userId) {
		super();
		this.skillId = skillId;
		this.power = power;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserSkill [skillId=" + skillId + ", power=" + power + ", userId=" + userId + "]";
	}

}
