public class DocumentDemo {
    public class void main(String[] args) {
        Document document = new Document();
        ActionListener openDocumentListener = new ActionOpenDoc();
        ActionListener saveDocumentListener = new ActionSaveDoc();

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

// Command Inteface 
interface ActionListener {
    void execute();
}

// Concrete Command
class ActionOpenDoc implements ActionListener {
    
    private Document document;

    @Override
    public void execute() {
        document.openDoc();
    }
}

// Concrete Command
class ActionSaveDoc implements ActionListener {
    
    private Document document;

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
        this.listenerOpenDoc = openDoc;
        this.saveDoc = saveDoc;
    }

    // logic decides which listener's execute action is to be invoked
    public void clickOpen() {
        listenerOpenDoc.execute();
    }

    public void clickSave() {
        listenerSaveDoc.execute();
    }
}