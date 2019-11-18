package rpc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;


public class RpcHelper {
	// A JSONArray to http response.
	public static void writeJSONArray(HttpServletResponse response, JSONArray array) throws IOException {
		response.setContentType("application/json");
		response.getWriter().print(array);
	}
	
	// A JSONObject to http response. 
	public static void writeJSONObject(HttpServletResponse response, JSONObject obj) throws IOException {
		response.setContentType("application/json");
		response.getWriter().print(obj);
	}
	
	// Parses a JSONObject from http request
	public static JSONObject readJSONObject(HttpServletRequest request) {
		StringBuilder builder = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			return new JSONObject(builder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new JSONObject();
	}
}
