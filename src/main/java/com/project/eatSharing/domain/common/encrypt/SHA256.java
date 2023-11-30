package com.project.eatSharing.domain.common.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest maketext = MessageDigest.getInstance("SHA-256");
        maketext.update(text.getBytes());
        return bytesToHex(maketext.digest());
    }

    // 바이트 배열을 16진수 문자열로 변환하는 메서드
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            // 바이트 값을 16진수 문자열로 변환하여 StringBuilder에 추가
            builder.append(String.format("%02x", b));
        }
        // StringBuilder의 내용을 문자열로 반환
        return builder.toString();
    }}
