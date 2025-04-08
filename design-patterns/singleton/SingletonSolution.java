public class SingletonSolution {
    public static void main(String[] args) {
        Database dbInstance = Database.getInstance();
        dbInstance.display();
    }
}

class Database {
    
    private static Database dbInstance;
    
    private Database() {
        // initialization 
    }

    public static Database getInstance() {
        if (dbInstance == null) {
            dbInstance = new Database();
        }
        return dbInstance;
    }

    public void display() {
        System.out.println("Database initialized");
    }
}