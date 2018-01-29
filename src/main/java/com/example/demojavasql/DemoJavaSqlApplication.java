package com.example.demojavasql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;
import java.lang.Thread;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource({
		"classpath:config.spring/appContext-jdbc-test.xml"
        , "classpath:config.spring/appContext-repository.xml", "classpath:config.spring/appContext-service.xml"
        ,"classpath:config.spring/appContext-controller.xml"})
public class DemoJavaSqlApplication extends SpringBootServletInitializer {

	@PostConstruct
	public void init() throws IOException {
		loadAccess();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoJavaSqlApplication.class, args);
	}

	/**
	 * Method in charge of creating and parsing the data from access.log data-h2.sql
	 * @throws IOException Exception
	 */
	private static void loadAccess() throws IOException {

		File initialFile = new File("src/main/resources/access.log");
		FileInputStream fstream = new FileInputStream(initialFile);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		ArrayList<String> list = new ArrayList<String>();
		while ((strLine = br.readLine()) != null) {
			list.add(strLine);
		}
		File file = new File("src/main/resources/data-h2.sql");

		file.createNewFile(); // if file already exists will do nothing

		//Write Content
		FileWriter writer = new FileWriter(file);

		Iterator itr;
		int index = 1;
		for (itr = list.iterator(); itr.hasNext(); ) {
			String str = itr.next().toString();
			String[] splitSt = str.split(Pattern.quote("|"));
			String startDate = "";
			String ip = "";
			startDate = splitSt[0];
			String dateFormat ="YYYY-MM-DD HH24:MI:SS.?????";
			ip = splitSt [1];
			writer.write(  "INSERT INTO ACCESS (ACCESS_ID,STARTDATE,IP) VALUES" + "(" + index + ","
					+ "to_date(" + "'" + startDate + "'" + "," + "'" + dateFormat + "'"+ ")" + "," + "'" + ip + "'"+  ")" + ";" + System.getProperty("line.separator"));

			index++;
		}

		writer.close();
	}

}
