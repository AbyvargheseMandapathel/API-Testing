Feature: Verify Get Request

Background: 
* def baseurl = 'https://petstore.swagger.io/v2'
And configure ssl = true

	@get
  Scenario: Verify Find Pet By Id
  
  	* def endpoint = "/pet/5"
  	 
  	
    Given url baseurl
    * def schema = read('classpath:schemas/getpetbyid.json')
	  And header Content-Type = 'application/json'
    And path endpoint
		When method get
		Then status 200
		And print response
		And match response.data.id == 5 
    And match response.data.category.name == 'string
    And match response == schema
    
    
		
      
      
   @delete  
   Scenario: Delete user via API
  
  	* def endpoint = "/pet/7"
	  Given url baseurl
	  And path endpoint
	  When method delete
	  Then status 404
	  
	  @put
	  		Scenario: Update
  
  	* def endpoint = "/pet"
  	
    Given url baseurl
    And path endpoint
    And request {
  	id: <id>,
  	category: {
    id: <cat_id>,
    name: <cat_name>
  	},
  	"name": <name>,
  	"photoUrls": [
   	 <photoUrls>
  	],
  	"tags": [
    {
      "id": <tag_id>,
      "name": <tag_name>
    }
  	],
  	"status": <status>
	}

		When method put
		Then status 200
		
		Examples: 
      | id|       cat_id| cat_name  |name  | photoUrls|tag_id|tag_name|status|
      | 0 |     0       | string    |doggie|string      |0   |tag_name|available|
      
      
  @post
		Scenario: Verify Create a New Pet
  
  	* def endpoint = "/pet"
  	
    Given url baseurl
    And path endpoint
    And request {
  	id: <id>,
  	category: {
    id: <cat_id>,
    name: <cat_name>
  	},
  	"name": <name>,
  	"photoUrls": [
   	 <photoUrls>
  	],
  	"tags": [
    {
      "id": <tag_id>,
      "name": <tag_name>
    }
  	],
  	"status": <status>
	}

		When method post
		Then status 200
		
		Examples: 
      | id|       cat_id| cat_name  |name  | photoUrls|tag_id|tag_name|status|
      | 0 |     0       | string    |doggie|string      |0   |tag_name|available|



