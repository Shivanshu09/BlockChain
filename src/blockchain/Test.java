package blockchain;

public class Test {

	public static void main(String[] args) {
			
			MainChain mC = new MainChain();
			
			Block a = new Block(new java.util.Date(), "<transactions>");
			Block b = new Block(new java.util.Date(), "<transactions>");
			Block c = new Block(new java.util.Date(), "<transactions>");
			
			mC.newBlock(a);
			mC.newBlock(b);
			mC.newBlock(c);
			
			//mC.getLatestBlock().setPreviousHash("ABCDEFG");
			
			mC.displayChain();
			
			

	}
}

