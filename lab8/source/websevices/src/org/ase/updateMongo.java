package org.ase;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;
public class updateMongo {

	public boolean updatedb(String input, String username) {
			MongoClientURI uri  = new MongoClientURI("mongodb://root:password@ds037824.mongolab.com:37824/lab7"); 
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());
			DBCollection Users = db.getCollection("userdata");
			DBObject inputDBObj = ( DBObject ) JSON.parse( input );
			System.out.println(inputDBObj.toString());
			BasicDBObject searchQuery = new BasicDBObject().append("username",username);
			Users.update(searchQuery, inputDBObj);
			client.close();
        
		return true;
	}

}
