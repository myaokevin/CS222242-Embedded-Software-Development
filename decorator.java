import java.util.HashMap;
import java.util.Map;

class Database {
    private Map<Integer, String> db = new HashMap<>();
    // singleton creational design pattern
    private static Database instance = new Database();
    private static int id = 0;

    private Database() {
    }

    public static Database getDatabaseInstance() {
        return instance;
    }

    public void addToDatabase(String str) {
        id++;
        System.out.println("Added [ key = "+id+" : value = "+str+"] to the database");
        db.put(id, str);

    }

}

interface Stream {
    void action(String str);
}

class CloudStream implements Stream {
    
    public void writeToDB(String str) {
        Database database = Database.getDatabaseInstance();
        database.addToDatabase(str);
    }
    @Override
    public void action(String str){
        writeToDB(str);
    };
}
abstract class StreamDecorator implements Stream{
    private final Stream streamToBeDecorated;

    StreamDecorator(Stream streamToBeDecorated){
        this.streamToBeDecorated =streamToBeDecorated;

    }
    @Override
    public void action(String str) {
        streamToBeDecorated.action(str);
    }
}
class EncryptedStream extends StreamDecorator {
    
    EncryptedStream(Stream streamToBeDecorated) {
        super(streamToBeDecorated);
    }

    public void action(String str) {
        str = "Encrypted(" + str + ")";
        super.action(str);
        
    }
}
class CompressedStream extends StreamDecorator {
   
    CompressedStream(Stream streamToBeDecorated) {
        super(streamToBeDecorated);
    }

    public void action(String str) {
        str = "Compressed(" + str + ")";
        super.action(str);
    }
}

public class decorator {
    public static void main(String[] args) {
        Stream stream = new CloudStream();
        stream.action("Name");

        Stream encryptedStream = new EncryptedStream(stream);
        encryptedStream.action("password");

        Stream compressedStream = new CompressedStream(stream);
        compressedStream.action("abcdefghijklmnopqrstuvwxyz");

        Stream ce_Stream = new CompressedStream(new EncryptedStream(stream));
        ce_Stream.action("...COMPRESS&thenENCRYPT");
        Stream ec_Stream = new EncryptedStream(new CompressedStream(stream));
        ec_Stream.action("...ENCRYPT&thenCOMPRESS");
        

    }
}
