package com.tutorial.aws.spring.service;

import com.tutorial.aws.spring.model.SemiBankedData;
import com.tutorial.aws.spring.repository.SemiBankedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class S3FileReader {
    private final SemiBankedRepository semiBankedRepository;

    @Autowired
    public S3FileReader(SemiBankedRepository semiBankedRepository) {
        this.semiBankedRepository = semiBankedRepository;
    }

    @PostConstruct
    public  void Callingmethod() {
        String bucketName = "nehabatch";
        String fileName = "hurricanes.csv";

        String fileContent = readFileFromS3(bucketName, fileName);
        if (fileContent != null) {
            System.out.println("File content:");
            System.out.println(fileContent);
        } else {
            System.out.println("Error reading file from S3.");
        }
        String dbUrl = "jdbc:oracle:thin:@//localhost:1521/orcl";

        String dbUser = "";
        String dbPassword = "";

        // Establish database connection
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

            List<SemiBankedData> data = new ArrayList<>();
            String[] rows = fileContent.split("\n");
            boolean firstRow = true;
            for (String row : rows) {
                String[] columns = row.split(",");
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                // Clean up column names, remove double quotes and trim spaces

                String month = columns[1].replace("\"","").trim();
                BigDecimal average = new BigDecimal(columns[2].replace("\"", "").trim());
                int year2005 = Integer.parseInt(columns[3].replace("\"", "").trim());
                int year2006 = Integer.parseInt(columns[4].replace("\"", "").trim());
                int year2007 = Integer.parseInt(columns[5].replace("\"", "").trim());
                int year2008 = Integer.parseInt(columns[6].replace("\"", "").trim());
                int year2009 = Integer.parseInt(columns[7].replace("\"", "").trim());
                int year2010 = Integer.parseInt(columns[8].replace("\"", "").trim());
                int year2011 = Integer.parseInt(columns[9].replace("\"", "").trim());
                int year2012  = Integer.parseInt(columns[10].replace("\"", "").trim());
                int year2013 = Integer.parseInt(columns[11].replace("\"", "").trim());
                int year2014 = Integer.parseInt(columns[12].replace("\"", "").trim());
                int year2015 = Integer.parseInt(columns[13].replace("\"", "").trim());
                // Continue to parse other columns based on their data types

                // Create a SemiBankedData object with the parsed values
                SemiBankedData semiBankedData = new SemiBankedData(null,month, average, year2005, year2006, year2007, year2008, year2009, year2010, year2011, year2012, year2013, year2014, year2015);

// Create a new SemiBankedData entity and set the composite key
                data.add(semiBankedData);
            }
            // Save the data to the database
            semiBankedRepository.saveAll(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFileFromS3(String bucketName, String fileName) {
        try (S3Client s3Client = S3Client.builder().region(Region.US_EAST_1).build())
        {
            // Create a GetObjectRequest to retrieve the file
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build();

            // Get the S3Object, which contains the file content
            ResponseInputStream<GetObjectResponse> s3Object = s3Client.getObject(getObjectRequest);

            // Read the content of the S3Object
            try (InputStream objectDataStream = s3Object) {
                InputStreamReader inputStreamReader = new InputStreamReader(objectDataStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder contentBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }

                return contentBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
