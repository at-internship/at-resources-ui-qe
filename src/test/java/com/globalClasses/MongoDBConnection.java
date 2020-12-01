package com.globalClasses;

import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import static java.lang.Integer.parseInt;

public class MongoDBConnection {
	private static MongoClient mClient;
	private static MongoDatabase mDataBase;

	public MongoDBConnection(String env, String db) {
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.WARNING);
		try {
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			String uriString = prop.getProperty(env + "." + db);
			getMongoClient(uriString);
			mDataBase = getDB(db);
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to make connection!");
		}
	}

	private MongoClient getMongoClient(String uriString) {
		if (mClient == null) {
			mClient = new MongoClient(new MongoClientURI(uriString));
		}
		return mClient;
	}

	private MongoDatabase getDB(String db) {
		return mClient.getDatabase(db);
	}

	public void close() {
		try {
			if (mClient != null) {
				mClient.close();
				mClient = null;
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean compareID(String collection, String id) {
		boolean exist = false;
		MongoCollection<Document> coll = mDataBase.getCollection(collection);
		FindIterable<Document> findIterable = coll.find(Filters.eq("_id", new ObjectId(id)));
		try {
			for (Document doc : findIterable) {
				JSONObject mObject = new JSONObject(doc.toJson());
				String mongoID = mObject.getJSONObject("_id").get("$oid").toString();
				exist = mongoID.equals(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			exist = false;
		}
		return exist;
	}

	public String getObjectByID(String collection, String id) {
		String mObject = "";
		MongoCollection<Document> coll = mDataBase.getCollection(collection);
		FindIterable<Document> findIterable = coll.find(Filters.eq("_id", new ObjectId(id)));
		try {
			for (Document doc : findIterable) {
				JSONObject monObject = new JSONObject(doc.toJson());
				mObject = monObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mObject;
	}
	
	public String foundRandomID(String collection) {
		String id = "";
		MongoCollection<Document> coll = mDataBase.getCollection(collection);
		FindIterable<Document> findIterable = coll.find();
		try {
			JSONArray jResult = new JSONArray();
			JSONObject mObject = new JSONObject();
			for (Document doc : findIterable) {
				jResult.put(mObject = new JSONObject(doc.toJson()));
			}
			int jArrayLength = jResult.length()-1;
			mObject = jResult.getJSONObject((int) (Math.random()*(jArrayLength-0+1)+0));
			id = mObject.getJSONObject("_id").get("$oid").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
  public static String setFormatDate(String dates) {
    Long mili_date = Long.parseLong(dates);
    Date date = new Date(mili_date);
    SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
    format_date.setTimeZone(TimeZone.getTimeZone("UTC"));
    String date_formated = format_date.format(date);

    return date_formated;
  }

	public boolean compareAllJsonString(String collection, String object) {

		boolean bool = false;
		String data = "", name = "", priority = "", description = "", due_date = "", start_date = "";
    int storyPoints = 0, progress = 0;
    String status = "";

		MongoCollection<Document> coll = mDataBase.getCollection(collection);
		FindIterable<Document> findIterable = coll.find();

		for (Document document : findIterable) {
			JSONObject mongo = new JSONObject(document.toJson());
			String id = mongo.getJSONObject("_id").get("$oid").toString();
			String sprint_id = mongo.getJSONObject("sprint_id").get("$oid").toString();
			String user_id = mongo.getJSONObject("user_id").get("$oid").toString();
			if (mongo.has("name")) {name = mongo.getString("name");}
			String[] priorityList = {"High", "Medium", "Low"};
			if (mongo.has("priority")) {priority = priorityList[parseInt(mongo.get("priority").toString()) - 1];}
			if (mongo.has("story_points")) {storyPoints = (int) mongo.get("story_points");}
      if (mongo.has("progress")) {progress = (int) mongo.get("progress");}
      
      if (mongo.has("status")) {
        status =  mongo.get("status").toString();
      } else{
        status = "";
      }

      if (mongo.has("due_date")) {
        due_date = MongoDBConnection.setFormatDate(mongo.getJSONObject("due_date").get("$date").toString());
      } else{
        due_date = "";
      }

      if (mongo.has("start_date")) {
        start_date = MongoDBConnection.setFormatDate(mongo.getJSONObject("start_date").get("$date").toString());
      } else{
        start_date = "";
      }

      data = data + id + sprint_id + name + user_id + priority + storyPoints + status + progress + start_date + due_date;
    }
		bool = compareAllJS(data, object);

		return bool;
	}

	public boolean compareAllJS(String mongoJson, String object) {
		boolean bool = false;
		if (mongoJson.equals(object)) {
			bool = true;
		}
		return bool;
	}
}
