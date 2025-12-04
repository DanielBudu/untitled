package e1.Thermostat;

import e1.Logger.EventLogger;

public class Thermostat {

    private ThermostatState state;
    private float currentTemp;
    private boolean heaterOn;

    public Thermostat() {
        this.state = new OffState(this);
    }

    void setState(ThermostatState newState) {
        this.state = newState;
    }

    public ThermostatState getState() {
        return state;
    }

    public void newTemperature(float temp) {
        this.currentTemp = temp;
        state.newTemperature(temp);
    }

    public String screenInfo() {
        return state.screenInfo();
    }

    public float getCurrentTemp() {
        return currentTemp;
    }

    public void setHeaterOn(boolean heaterOn) {
        this.heaterOn = heaterOn;
    }

    public boolean isHeaterOn() {
        return heaterOn;
    }

    public void toOff() {
        state.toOff();
    }

    public void toManual() {
        state.toManual();
    }

    public void toTimer(int min) {
        state.toTimer(min);
    }

    public void toProgram(float targetTemp) {
        state.toProgram(targetTemp);
    }

    public void logEvent(String msg) {
        EventLogger.write(msg);
    }
}
