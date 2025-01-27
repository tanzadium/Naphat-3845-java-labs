package phadungkit.naphat.lab7;

public class AppleWatch extends MobileDevice {
    private String modelName;

    public AppleWatch(String color, double price, String modelName) {
        setColor(color);
        setPrice(price);
        setModelName(modelName);
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelName() {
        return modelName;
    }

    @Override
    public boolean isWatch() {
        return true;
    }

    @Override
    public String toString() {
        return "AppleWatch [" + "color=" + getColor() + ", price=" 
                + getPrice() + ", modelName=" + modelName + "]";
    }
}
