package MyBlockChain;

public class Block {
    private BlockData data;

    public Block(String _prevHash, String _payload){
        this.data = new BlockData(_prevHash, _payload); //_prevHash;
        //this.payload = _payload;
    }

}
