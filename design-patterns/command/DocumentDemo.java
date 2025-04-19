public class DocumentDemo {
    public static void main(String[] args) {
        Document document = new Document();
        ActionListener openDocumentListener = new ActionOpenDoc(document);
        ActionListener saveDocumentListener = new ActionSaveDoc(document);

        MenuOptions menu = new MenuOptions(openDocumentListener, saveDocumentListener);
        menu.clickOpen();
        menu.clickSave();
    }
}

// Receiver
class Document {
    public void openDoc() {
        System.out.println("Opening document");
    }

    public void saveDoc() {
        System.out.println("Saving document");
    }
}

// Command Inteface x
interface ActionListener {
    void execute();
}

// Concrete Command
class ActionOpenDoc implements ActionListener {
    
    private Document document;

    public ActionOpenDoc(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.openDoc();
    }
}

// Concrete Command
class ActionSaveDoc implements ActionListener {
    
    private Document document;

    public ActionSaveDoc(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.saveDoc();
    }
}

// Invoker 
class MenuOptions {
    private ActionListener listenerOpenDoc;
    private ActionListener listenerSaveDoc;

    public MenuOptions(ActionListener listenerOpenDoc, ActionListener listenerSaveDoc) {
        this.listenerOpenDoc = listenerOpenDoc;
        this.listenerSaveDoc = listenerSaveDoc;
    }

    // logic decides which listener's execute action is to be invoked
    public void clickOpen() {
        listenerOpenDoc.execute();
    }

    public void clickSave() {
        listenerSaveDoc.execute();
    }
}