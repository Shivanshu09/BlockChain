package blockchain;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	
	private int index;
	private long timestamp;
	private String currentHash;
	private String previousHash;
	private String data; 
	
	public Block( int index, long timestamp, String data, String previousHash) {
		this.index = index;
		this.timestamp = timestamp;
		this.data = data;
		this.previousHash = previousHash;
		this.currentHash = generateHash();
	}
	
	public String generateHash() {
		String forHash = "Block{ " + Integer.toString(this.index) + this.data + Long.toString(this.timestamp) + this.previousHash + "}";
		newHash = generateHash(forHash);
		return newHash;
	}
	
	public String generateHash( String forHash) {
		String hashed = Hashing.sha256().hashSting( forHash, Charstes.UTF_8).toString();
		return hashed;
	}
	

}
