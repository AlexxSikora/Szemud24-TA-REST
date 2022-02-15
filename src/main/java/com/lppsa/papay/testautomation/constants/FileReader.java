package com.lppsa.papay.testautomation.constants;

import java.io.*;

public class FileReader {

    public static final String CREATE_PAYMENT_FILE = "src/main/resources/requestBody/createTransaction.json";
    public static final String CREATE_REFUND_FILE = "src/main/resources/requestBody/createRefund.json";
    public static final String CREATE_CAPTURE_FILE = "src/main/resources/requestBody/createCapture.json";
    public static final String CREATE_SHORTENED_SECOND_REFUND = "src/main/resources/requestBody/createRefundShortenedOrderSecondItem.json";
    public static final String CREATE_SHORTENED_FIRST_REFUND = "src/main/resources/requestBody/createRefundShortenedOrderFirstItem.json";


    public static String readFileContent(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
