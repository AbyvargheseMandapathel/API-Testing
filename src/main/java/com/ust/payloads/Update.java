package com.ust.payloads;

public class Update {
	private long id;
	private int cat_id;
	private String name;
	private String name_2;
	private String photoUrls;
	private int tag_id;
	private String tag_name;
	private String status;
	
	public Update() {
		
	}
	
	
	public Update(long id , int cat_id , String name , String name_2  ,String photoUrls,
			int tag_id , String tag_name , String status 
			) {
		this.id = id;
		this.cat_id = cat_id;
		this.name= name;
		this.name_2 = name_2;
		this.photoUrls = photoUrls;
		this.tag_id = tag_id;
		this.tag_name = tag_name;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_2() {
		return name_2;
	}
	public void setName_2(String name_2) {
		this.name_2 = name_2;
	}
	public String getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": " + cat_id + ",\n" +
                "    \"name\": \"" + name + "\"\n" +
                "  },\n" +
                "  \"name\": \"" + name_2 + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"" + photoUrls + "\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + tag_id + ",\n" +
                "      \"name\": \"" + tag_name + "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }


}
