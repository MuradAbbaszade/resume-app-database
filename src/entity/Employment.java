package entity;

import java.sql.Date;

public class Employment {
	private int user_id;
	private String jobDescription;
	private Date beginDate;
	private Date endDate;

	public Employment(int user_id, String jobDescription, Date beginDate, Date endDate) {
		super();
		this.user_id = user_id;
		this.jobDescription = jobDescription;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public int getId() {
		return user_id;
	}

	@Override
	public String toString() {
		return "Employment [user_id=" + user_id + ", jobDescription=" + jobDescription + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + "]";
	}

	public void setId(int user_id) {
		this.user_id = user_id;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
