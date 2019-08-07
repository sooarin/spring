package org.hello.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.hello.dao.UserDAO;
import org.hello.domain.UserVO;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
	@Inject
    private UserDAO dao;
    
    private String iv;
	private Key keySpec;

	/**
	 * 16�옄由ъ쓽 �궎媛믪쓣 �엯�젰�븯�뿬 媛앹껜瑜� �깮�꽦�븳�떎.
	 * 
	 * @param key
	 *            �븫/蹂듯샇�솕瑜� �쐞�븳 �궎媛�
	 * @throws UnsupportedEncodingException
	 *             �궎媛믪쓽 湲몄씠媛� 16�씠�븯�씪 寃쎌슦 諛쒖깮
	 */
	final static String key = "123456789012345678";

	public UserServiceImpl() throws UnsupportedEncodingException {
		this.iv = key.substring(0, 16);
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		this.keySpec = keySpec;
	} 
	//�븫�샇�솕
	public String encrypt(String str) throws NoSuchAlgorithmException,
	GeneralSecurityException, UnsupportedEncodingException {
Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
String enStr = new String(Base64.encodeBase64(encrypted));
return enStr;
}
	// 蹂듯샇�솕 
	public String decrypt(String str) throws NoSuchAlgorithmException,
	GeneralSecurityException, UnsupportedEncodingException {
Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
byte[] byteStr = Base64.decodeBase64(str.getBytes());
return new String(c.doFinal(byteStr), "UTF-8");
}
	
	
    @Override
    public void createUser(UserVO vo) throws Exception {
        dao.createUser(vo);
 
    }

    @Override

    public UserVO login(UserVO dto) throws Exception {
    	
    	String pw = encrypt(dto.getPw());        // 鍮꾨�踰덊샇 �븫�샇�솕 �뜲�씠�꽣 媛�怨듯븯湲� !!
    	
    	dto.setPw(pw);	

        return dao.login(dto);

    }

	@Override
	public void createUserencrpyt(UserVO vo) throws Exception {
	
	String pw = encrypt(vo.getPw());        // 鍮꾨�踰덊샇 �븫�샇�솕 �뜲�씠�꽣 媛�怨듯븯湲� !!
		vo.setPw(pw);
	dao.createUser(vo);
		
	}
	@Override
	public UserVO idCheck(String id) throws Exception {
		return dao.idCheck(id);
	}
	@Override
	   public void user(UserVO vo) throws Exception {
	      String pw = encrypt(vo.getPw());
	      vo.setPw(pw);
	      dao.user(vo);
	   }
	   @Override
	   public void withdrawal(UserVO vo) throws Exception {
		   dao.withdrawal(vo);
	   }
	 
}
