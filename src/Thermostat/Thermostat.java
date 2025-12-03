package Thermostat;

import Logger.EventLogger;
import States.OffState;
import States.ThermostatState;


public class Thermostat {

    private ThermostatState state;
    private float currentTemp;
    private boolean heaterOn;
    private EventLogger log;

    public Thermostat() {
        this.state = new OffState(this);
        this.log = new EventLogger();
    }

    public void setState(ThermostatState newState) {
        this.state = newState;
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
        log.write(msg);
    }
}
