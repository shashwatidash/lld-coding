class Desktop {
    public String motherboard;
    public String processor;
    public String graphicsCard;
    public String memory;
    public String storage;

    public String getMotherboard() {
        return motherboard;
    }

    public String getProcessor() {
        return processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getMemory() {
        return memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void display() {
        System.out.println("Motherboard: " + motherboard + "\n" +
            "Processor: " + processor + "\n" +
            "Motherboard: " + motherboard + "\n" +
            "GraphicsCard: " + graphicsCard + "\n" +
            "Memory: " + memory);
    }
}

abstract class DesktopBuilder {
    protected Desktop desktop = new Desktop();

    public Desktop getDesktop() {
        return desktop;
    }

    public abstract void buildMotherboard();
    public abstract void buildProcessor();
    public abstract void buildMemory();
    public abstract void buildStorage();
    public abstract void buildGraphicsCard();
}


class DellDesktopBuilder extends DesktopBuilder {
    @Override
    public void buildMotherboard() {
        desktop.setMotherboard("Dell Motherboard");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("Dell Processor");
    }

    @Override
    public void buildMemory() {
        desktop.setMemory("32 GB DDR4 RAM");
    }

    @Override
    public void buildStorage() {
        desktop.setStorage("1TB SSD + 2TB HDD");
    }

    @Override
    public void buildGraphicsCard() {
        desktop.setGraphicsCard("NVIDIA RTX");
    }
}

class DesktopDirector {
    public Desktop buildDesktop(DesktopBuilder desktopBuilder) {
        desktopBuilder.buildMotherboard();
        desktopBuilder.buildProcessor();
        desktopBuilder.buildMemory();
        desktopBuilder.buildStorage();
        desktopBuilder.buildGraphicsCard();

        return desktopBuilder.getDesktop();
    }
}

public class DesktopSolution {
    public static void main(String[] args) {
        DesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();
        DesktopDirector director = new DesktopDirector();
        Desktop dellDesktop = director.buildDesktop(dellDesktopBuilder);
        dellDesktop.display();
    }
}