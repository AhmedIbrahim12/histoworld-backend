package com.booker.services.lectures;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "lecture")
public class Lecture {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String description;

	private String attachmentDownloadUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachmentDownloadUrl() {
		return attachmentDownloadUrl;
	}

	public void setAttachmentDownloadUrl(String attachmentDownloadUrl) {
		this.attachmentDownloadUrl = attachmentDownloadUrl;
	}
}
