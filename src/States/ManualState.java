package States;

import Thermostat.Thermostat;

public class ManualState implements ThermostatState {

    private Thermostat context;

    public ManualState(Thermostat context) {
        this.context = context;
        context.setHeaterOn(true); // En manual siempre encendida
        context.logEvent("Se activa el modo Manual.");
    }

    @Override
    public void newTemperature(float temp) {
        // En manual la calefacción siempre ON
        context.setHeaterOn(true);
    }

    @Override
    public String screenInfo() {
        return context.getCurrentTemp() + " ON M";
    }

    @Override
    public void toOff() {
        context.setState(new OffState(context));
    }

    @Override
    public void toManual() {
        // Ya estamos en manual
    }

    @Override
    public void toTimer(int minutes) {
        context.setState(new TimerState(context, minutes));
    }

    @Override
    public void toProgram(float targetTemp) {
        context.setState(new ProgramState(context, targetTemp));
    }
}
