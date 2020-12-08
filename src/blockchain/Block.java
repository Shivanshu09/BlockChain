package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	
	private int index;
	private Date Timestamp;
	private String currentHash;
	private String previousHash;
	private String data; 
	
	public Block(Date timestamp, String data) {
		//this.index = index;
		this.Timestamp = timestamp;
		this.data = data;
		//this.previousHash = previousHash;
		this.currentHash = generateHash();
	}
	
	public String generateHash() {
		String forHash = "Block " + this.index + this.data + this.Timestamp + this.previousHash;
		String newHash = generateHashcode(forHash);
		return newHash;
	}
	
	public String generateHashcode( String forHash) {
		MessageDigest digest;
		String encoded = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(forHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.currentHash = encoded;
		return encoded;
	
	}
	
	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}
	
	public String getPreviousHash() {
		return previousHash;
	}
	
	public void setPreviousHash( String previousHash ) {
		this.previousHash = previousHash;
	}
	
	public String getHash() {
		return currentHash;
	}

	public void setHash(String hash) {
		this.currentHash = hash;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
