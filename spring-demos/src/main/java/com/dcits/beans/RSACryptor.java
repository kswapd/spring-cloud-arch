package com.dcits.beans;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class RSACryptor {

  public static final String DEFAULT_PUBLIC_KEY_STRING = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALgnDkt8m6URm6Zd9lB7CRSb8vkj3ZLTJ6XzaYd69vUJnZQ9czCCzG89QDRnkgIPgntMJZs2VgXQqaMgIsrJpssCAwEAAQ==";
  private static final String algorithm = "RSA";
  private static final String DEFAULT_PRIVATE_KEY_STRING = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAuCcOS3ybpRGbpl32UHsJFJvy+SPdktMnpfNph3r29QmdlD1zMILMbz1ANGeSAg+Ce0wlmzZWBdCpoyAiysmmywIDAQABAkEAq88Ebzkana8H4PfZTsz7c9brobXsi4elfhbTZis7LPDqbFbh53csUvVNTQWp4UXtveLuiF+FePpA3YHjUGUFgQIhAPpLIMdyfBCkI0mwQllS3rJAcoiEGBdJH1FQg6YDMEbJAiEAvFnjKvZK+tre4JFDTeQUYWnXHdSBXWqICc/nRxP/xvMCIFz93q7bZSbVpNqy5uPC+0Rk12jLExxLqZwPeuoKEzypAiABFV9KKvqJcOLhVdSWSR6Y5Nv47vUDjY5UyB5jeUj6YwIhAPAUSSMzWbbse/ScvxwRxQuVerxGQSfRMGMpDBQOjVkv";
  private static Logger logger = LoggerFactory.getLogger(RSACryptor.class);
  private static PublicKey publicKey = getPublicKey(DEFAULT_PUBLIC_KEY_STRING);
  private static PrivateKey privateKey = getPrivateKey(DEFAULT_PRIVATE_KEY_STRING);

  public static String encrypt(String plain) {
    try {
      return encrypt(privateKey, plain);
    } catch (Exception e) {
      return null;
    }
  }

  protected static String encrypt(PrivateKey privateKey, String plainText) throws Exception {
    Cipher cipher = Cipher.getInstance(algorithm);
    try {
      cipher.init(Cipher.ENCRYPT_MODE, privateKey);
    } catch (InvalidKeyException e) {
      //For IBM JDK, 原因请看解密方法中的说明
      RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
      RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(rsaPrivateKey.getModulus(), rsaPrivateKey.getPrivateExponent());
      Key fakePublicKey = KeyFactory.getInstance(algorithm).generatePublic(publicKeySpec);
      cipher = Cipher.getInstance(algorithm);
      cipher.init(Cipher.ENCRYPT_MODE, fakePublicKey);
    }

    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
    String encryptedString = Base64.byteArrayToBase64(encryptedBytes);

    return encryptedString;
  }

  public static String decrypt(String cipher) {
    try {
      return decrypt(publicKey, cipher);
    } catch (Exception e) {
      return null;
    }
  }

  protected static String decrypt(PublicKey publicKey, String cipherText)
      throws Exception {
    Cipher cipher = Cipher.getInstance(algorithm);
    try {
      cipher.init(Cipher.DECRYPT_MODE, publicKey);
    } catch (InvalidKeyException e) {
      // 因为 IBM JDK 不支持私钥加密, 公钥解密, 所以要反转公私钥
      // 也就是说对于解密, 可以通过公钥的参数伪造一个私钥对象欺骗 IBM JDK
      RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
      RSAPrivateKeySpec spec = new RSAPrivateKeySpec(rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
      Key fakePrivateKey = KeyFactory.getInstance(algorithm).generatePrivate(spec);
      cipher = Cipher.getInstance(algorithm); //It is a stateful object. so we need to get new one.
      cipher.init(Cipher.DECRYPT_MODE, fakePrivateKey);
    }

    if (cipherText == null || cipherText.length() == 0) {
      return cipherText;
    }

    byte[] cipherBytes = Base64.base64ToByteArray(cipherText);
    byte[] plainBytes = cipher.doFinal(cipherBytes);

    return new String(plainBytes);
  }

  protected static PublicKey getPublicKey(String publicKeyText) {
    try {
      byte[] publicKeyBytes = Base64.base64ToByteArray(publicKeyText);
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(
          publicKeyBytes);

      KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
      return keyFactory.generatePublic(x509KeySpec);
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to get public key", e);
    }
  }

  public static PublicKey getPublicKeyByPublicKeyFile(String publicKeyFile) {
    if (publicKeyFile == null || publicKeyFile.length() == 0) {
      return getPublicKey(null);
    }

    try (FileInputStream in = new FileInputStream(publicKeyFile)) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int len = 0;
      byte[] b = new byte[512 / 8];
      while ((len = in.read(b)) != -1) {
        out.write(b, 0, len);
      }

      byte[] publicKeyBytes = out.toByteArray();
      X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyBytes);
      KeyFactory factory = KeyFactory.getInstance(algorithm);
      return factory.generatePublic(spec);
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to get public key", e);
    }
  }

  public static PublicKey getPublicKeyByX509(String x509File) {
    if (x509File == null || x509File.length() == 0) {
      return getPublicKey(null);
    }

    try (FileInputStream in = new FileInputStream(x509File)) {
      CertificateFactory factory = CertificateFactory
          .getInstance("X.509");
      Certificate cer = factory.generateCertificate(in);
      return cer.getPublicKey();
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to get public key", e);
    }
  }

  public static PrivateKey getPrivateKey(String privateKeyText) {
    byte[] keyBytes = Base64.base64ToByteArray(privateKeyText);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    try {
      KeyFactory factory = KeyFactory.getInstance(algorithm);
      return factory.generatePrivate(spec);
    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
      throw new IllegalArgumentException("Failed to get private key", e);
    }
  }

}
