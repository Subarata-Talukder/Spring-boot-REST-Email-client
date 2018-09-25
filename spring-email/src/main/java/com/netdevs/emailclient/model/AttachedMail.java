package com.netdevs.emailclient.model;

public class AttachedMail extends SimpleMail{
	
	private String pathToAttachment;

	public String getPathToAttachment() {
		return pathToAttachment;
	}

	public void setPathToAttachment(String pathToAttachment) {
		this.pathToAttachment = pathToAttachment;
	}
}
