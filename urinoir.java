public class urinoir {

    boolean filled;
    double heatmap;
    int bufferR;
    int bufferL;

    public urinoir() {
        this.filled = false;
        this.heatmap = 0;
    }

    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
        if (this.filled == true){
            this.heatmap = 999999999;
        }
    }

    public double getHeatmap() {
        return heatmap;
    }

    public void setHeatmap(double heatmap) {
        this.heatmap = heatmap;
    }

    public void setBufferR(int buffer) {
        this.bufferR = buffer;
    }

    public int getBufferR() {
        return bufferR;
    }

    public void setBufferL(int buffer) {
        this.bufferL = buffer;
    }

    public int getBufferL() {
        return bufferL;
    }
}
