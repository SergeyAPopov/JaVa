
public class Notebook{
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private int price;
    private String color;

public Notebook(String model, int ram, int hdd, String os, int price, String color){
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.price = price;
        this.color = color;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + ram;
    result = prime * result + hdd;
    result = prime * result + ((os == null) ? 0 : os.hashCode());
    result = prime * result + price;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
            return true;
    if (obj == null)
            return false;
    if (getClass() != obj.getClass())
            return false;
    Notebook other = (Notebook) obj;
    if (model == null) {
            if (other.model != null)
                    return false;
    } else if (!model.equals(other.model))
            return false;
    if (ram != other.ram)
            return false;
    if (hdd != other.hdd)
            return false;
    if (os == null) {
            if (other.os != null)
                    return false;
    } else if (!os.equals(other.os))
            return false;
    if (price != other.price)
            return false;
    if (color == null) {
            if (other.color != null)
                    return false;
    } else if (!color.equals(other.color))
            return false;
    return true;
}

@Override
public String toString() {
    return "Notebook [model=" + model + ", ram=" + ram + ", hdd=" + hdd + ", os=" + os + ", price=" + price
                    + ", color=" + color + "]";
}
    
    public String getmodel() {
            return model;
    }
    public void setmodel(String model) {
            this.model = model;
    }

    public int getram() {
            return ram;
    }
    public void setram(int ram) {
            this.ram = ram;
    }
    public int gethdd() {
            return hdd;
    }
    public void sethdd(int hdd) {
            this.hdd = hdd;
    }
    public String getos() {
            return os;
    }
    public void setos(String os) {
            this.os= os;
    }
    public int getprice() {
            return price;
    }
    public void setprice(int price) {
            this.price = price;
    }
    public String getcolor() {
            return color;
    }
    public void setcolor(String color) {
            this.color= color;
}
}
