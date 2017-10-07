package com.reboot.admin.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class CommonModel {
	@ApiModelProperty(hidden=true)
	private String Created_By;
	private Date Created_Date;
	private String Updated_By;
	private Date Updated_Date;

	public String getCreated_By() {
		return Created_By;
	}

	public void setCreated_By(String created_By) {
		Created_By = created_By;
	}

	public Date getCreated_Date() {
		return Created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		Created_Date = created_Date;
	}

	public String getUpdated_By() {
		return Updated_By;
	}

	public void setUpdated_By(String updated_By) {
		Updated_By = updated_By;
	}

	public Date getUpdated_Date() {
		return Updated_Date;
	}

	public void setUpdated_Date(Date updated_Date) {
		Updated_Date = updated_Date;
	}
}