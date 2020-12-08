package blockchain;

import blockchain.Block;
//import blockchain.Test;
import java.util.ArrayList;
import java.util.List;


public class MainChain {
	
	private List<Block> mainChain;
	
	public MainChain() {
		mainChain = new ArrayList<Block>();
		mainChain.add(getFirstBlock());
	}
	
	private Block getFirstBlock() {
		Block b = new Block(new java.util.Date(), "<transactions>");
		b.setPreviousHash(null);
		b.generateHash();
		return b;
	}
	
	public void newBlock(Block bl) {
		Block b = bl;
		b.setPreviousHash(mainChain.get(mainChain.size()-1).getHash());
		b.generateHash();
		this.mainChain.add(b);
	}
	
	public void displayChain() {
			
			for(int i=0; i<mainChain.size(); i++) {
				System.out.println("Block: " + i);
				System.out.println("Timestamp: " + mainChain.get(i).getTimestamp());
				System.out.println("PreviousHash: " + mainChain.get(i).getPreviousHash());
				System.out.println("Hash: " + mainChain.get(i).getHash());
				System.out.println();
			}
			
		}

}
