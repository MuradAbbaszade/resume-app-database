package main;

import abstractdao.AbstractEmploymentDao;
import abstractdao.AbstractSkillDao;
import abstractdao.AbstractUserDao;
import abstractdao.AbstractUserSkillDao;
import dao.EmploymentDao;
import dao.SkillDao;
import dao.UserDao;
import dao.UserSkillDao;

public class Context {
	public static AbstractUserDao instanceUserDao() {
		return new UserDao();
	}

	public static AbstractUserSkillDao instanceUserSkillDao() {
		return new UserSkillDao();
	}

	public static AbstractSkillDao instanceSkillDao() {
		return new SkillDao();
	}

	public static AbstractEmploymentDao instanceEmploymentDao() {
		return new EmploymentDao();
	}

}
