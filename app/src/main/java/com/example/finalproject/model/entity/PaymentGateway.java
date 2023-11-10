package com.example.finalproject.model.entity;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class PaymentGateway {
    private static final String VNP_TMNCODE = "DIY6W4QL";
    private static final String VNP_HASHSECRET = "RRKFYAWVWBRWYCPWBKEDXTQNGLBEKBAI";
    private static final String VNP_URL = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";

//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
//        System.out.println(createPaymentUrl(100.0, "http://returnurl.com"));
//    }

    public static String createPaymentUrl(double total, String returnUrl) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        String createDate = dateFormat.format(date);

        String orderId = new SimpleDateFormat("ddHHmmss").format(date);
        long amount = (long) total * 100;

        String ipAddr = "104.28.205.74";
        String locale = "vn";
        String currCode = "VND";

        SortedMap<String, String> vnp_Params = new TreeMap<>();
        vnp_Params.put("vnp_Version", "2.1.0");
        vnp_Params.put("vnp_Command", "pay");
        vnp_Params.put("vnp_TmnCode", VNP_TMNCODE);
        vnp_Params.put("vnp_Locale", locale);
        vnp_Params.put("vnp_CurrCode", currCode);
        vnp_Params.put("vnp_TxnRef", orderId);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan cho ma GD:" + orderId);
        vnp_Params.put("vnp_OrderType", "other");
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_ReturnUrl", returnUrl);
        vnp_Params.put("vnp_IpAddr", ipAddr);
        vnp_Params.put("vnp_CreateDate", createDate);

        StringBuilder queryBuilder = new StringBuilder();
        for(Map.Entry<String, String> entry : vnp_Params.entrySet()) {
            queryBuilder.append(entry.getKey()).append("=")
                    .append(URLEncoder.encode(entry.getValue(), "UTF-8")).append("&");
        }

        String query = queryBuilder.substring(0, queryBuilder.length() - 1);

        String signData = hmacSHA512(VNP_HASHSECRET, query);
        vnp_Params.put("vnp_SecureHash", signData);

        StringBuilder urlBuilder = new StringBuilder(VNP_URL);
        urlBuilder.append("?").append(query);
        return urlBuilder.toString();
    }

    private static String hmacSHA512(String key, String data) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {


        Mac sha512Hmac = Mac.getInstance("HmacSHA512");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA512");
        sha512Hmac.init(secretKey);

        byte[] hash = sha512Hmac.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
