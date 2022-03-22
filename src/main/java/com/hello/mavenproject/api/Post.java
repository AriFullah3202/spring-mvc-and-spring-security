package com.hello.mavenproject.api;

public class Post {
  private int pid;
  private String ptitle;
  private String pcontent;
  private int catid;
  public Post() {
	// TODO Auto-generated constructor stub
}
public Post(int pid, String ptitle, String pcontent, int catid) {
	
	this.pid = pid;
	this.ptitle = ptitle;
	this.pcontent = pcontent;
	this.catid = catid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}
public String getPcontent() {
	return pcontent;
}
public void setPcontent(String pcontent) {
	this.pcontent = pcontent;
}
public int getCatid() {
	return catid;
}
public void setCatid(int catid) {
	this.catid = catid;
}
  
}
