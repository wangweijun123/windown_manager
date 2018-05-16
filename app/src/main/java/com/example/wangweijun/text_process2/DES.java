package com.example.wangweijun.text_process2;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static com.example.wangweijun.text_process2.Base64.*;

public class DES {
    private static byte[] iv = {1,2,3,4,5,6,7,8};
    public static byte[] defaultKeyBit = {2,8,4,6,7,9,1,3};
    public static String defaultKeyStr = "++B%)(&D";
    /**
     * @param encryptString
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String encryptDES(String encryptString, String encryptKey) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return encode(encryptedData);
    }
    
    public static String encryptDES(String encryptString, byte[] encryptKey) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(encryptKey, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return encode(encryptedData);
    }

    /**
     * @param decryptString
     * @param decryptKey
     * @return
     * @throws Exception
     */
    @SuppressWarnings("static-access")
	public static String decryptDES(String decryptString, String decryptKey) throws Exception {
        byte[] byteMi = new Base64().decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData);
    }

    @SuppressWarnings("static-access")
	public static String decryptDES(String decryptString, byte[] decryptKey) throws Exception {
        byte[] byteMi = new Base64().decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(decryptKey, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData);
    }


    /**
     * @param encryptString
     * @return
     * @throws Exception
     */
    public static String encryptDES(String encryptString) throws Exception {
        return encryptDES(encryptString, defaultKeyStr);
    }


    /**
     * @param decryptString
     * @return
     * @throws Exception
     */
    public static String decryptDES(String decryptString) throws Exception {
        return decryptDES(decryptString, defaultKeyStr);
    }
    
    public static void main() throws Exception {
    	String test1 = "aabbccddeeffggxxxx";
        String encryptDES = DES.encryptDES(test1);
    	System.out.println("encryptDES:"+encryptDES);
        System.out.println(DES.decryptDES(encryptDES));

        System.out.println("################");
    	//ugd4LpMo6vRqHDGlEfl7qg==
		String t = "iHdzVBiLX4fTOyP+GMBvTQ==";
		System.out.println(DES.decryptDES(t,DES.defaultKeyBit));
		String rt ="qFzz33vfRuA9cYuExpeFS1yY0EsoSSsBQ4U/Ue1i5ClZVHhwFb0VWjYnBS+d P0Lrizs8iikDel8VRVZ2mqwrXjwFxvhe03PzKVQpG3fpU2QvqKS7d/9DZX/W UyL/bDubCCPHKAy8lfUWk12LDqp8vvKbc61oO7Bv1haTrUS1l3haH+74ttso B005Q0g/0FPMj8bUmY2hbjO8x+vhIG8RhfyIUI7t2oLZbEsvNSiVIWzZi3Ym owOe99LrplSZu17wQKoQH4wI82f2x+Q+s6DcQ3/ah/PkXwJXxl2bCabFh9Uz Cvw/Xbx3pAYB4W2YtiROcnhNo9BZlzr2ne6FYJcoQNyfhU3RqMAVQp5gmhU6 HVP0jI6heFVDCUCSsZXIlo4SQaqprUoGwgf9uZtEN2pg6InrXSJynUlHqzeE J78G8+PN9s1FKaXvTY5Vw6mvMiYUouEhfB6+xOQ3t6n52pTym/jtTfEG/VQj TOIaUiwkVYTMQYpIBD2eDPrtdGp2gaQiQdCs/enBoQLHIXKjWjnEDpzsJBq4 RnuxPoRoh07619BuRd9RpcQcNoLLv+mWcbX4scqRYbYHPJw5TwnfHGnJI/uG jBW98NmeYvNdClPOTAaLa5iUjqcdGnuArg08W745Dx1KR7OGys9F+PhMgNaY vn6iAGZ1H4WzErcdVAfc3zI=";
		System.out.println(DES.decryptDES(rt,DES.defaultKeyBit));



    }
	
}  