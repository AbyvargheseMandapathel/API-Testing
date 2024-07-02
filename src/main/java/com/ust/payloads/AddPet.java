package com.ust.payloads;

public class AddPet {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;
    
    public AddPet() {
        
    }
    
    public AddPet(long id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String[] getPhotoUrls() {
        return photoUrls;
    }
    
    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }
    
    public Tag[] getTags() {
        return tags;
    }
    
    public void setTags(Tag[] tags) {
        this.tags = tags;
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
                "  \"category\": " + category + ",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [" + String.join(", ", photoUrls) + "],\n" +
                "  \"tags\": [" + tags[0] + "],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }
    
    public static class Category {
        private int id;
        private String name;
        
        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "{\n" +
                    "    \"id\": " + id + ",\n" +
                    "    \"name\": \"" + name + "\"\n" +
                    "}";
        }
    }
    
    public static class Tag {
        private int id;
        private String name;
        
        public Tag(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "{\n" +
                    "      \"id\": " + id + ",\n" +
                    "      \"name\": \"" + name + "\"\n" +
                    "    }";
        }
    }
}
