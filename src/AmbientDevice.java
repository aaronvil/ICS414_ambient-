import java.awt.Color;

/**
 * A virtual representation of an ambient device lamp.
 */
public class AmbientDevice {

    private EZCircle lamp;
    private float hue;
    private float saturation;
    private float brightness;
    private Color lampColor;

    /**
     * Constructor class of the Ambient Device
     * @param xPos X Coordinate position of the lamp. This is the center of device.
     * @param yPos Y Coordinate position of the lamp. This is the center of device.
     * @param Radius The radius of the lamp.
     */
    public AmbientDevice(int xPos, int yPos, int Radius) {
        hue = 180.0f;
        saturation = 1.0f;
        brightness = 1.0f;
        lampColor = Color.getHSBColor(hue, saturation, brightness);
        lamp = EZ.addCircle(xPos, yPos, Radius, Radius, lampColor, true);
    }

    /**
     * Getter for the lamp EZCircle Object of the ambient device
     * @return lamp
     */
    public EZCircle getLamp() {
        return this.lamp;
    }

    /**
     * Setter for the brightness of the lamp with a value between 0.0-100.0
     * @param value Brightness of lamp
     */
    public void setBrightness(float value) {
        if (value > 100.0f) value = 100.0f;
        if (value < 0.0f) value = 0.0f;
        this.brightness = value / 100;
        lampColor = Color.getHSBColor(hue, saturation, this.brightness);
        lamp.setColor(lampColor);
    }

    /**
     * Setter for the color of the lamp with a value between 0.0-100.0
     * @param value Color of lamp
     */
    public void setColor(float value) {
        if (value > 100.0f) value = 100.0f;
        if (value < 0.0f) value = 0.0f;
        this.hue = value / 100;
        lampColor = Color.getHSBColor(this.hue, saturation, brightness);
        lamp.setColor(lampColor);
    }

    public float getBrightness() {
        return brightness;
    }

    public float getHue() {
        return hue;
    }

}