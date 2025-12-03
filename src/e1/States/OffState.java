package e1.States;

import e1.Thermostat.Thermostat;

public class OffState implements ThermostatState {

    private final Thermostat context;

    public OffState(Thermostat context) {
        this.context = context;
        context.setHeaterOn(false);
        context.logEvent("Se activa el modo Off.");
    }

    @Override
    public void newTemperature(float temp) {
        context.setHeaterOn(false);
    }

    @Override
    public String screenInfo() {
        return context.getCurrentTemp() + " Modo Off - Calefacción apagada.";
    }

    @Override
    public void toOff() {
        // ya en off
    }

    @Override
    public void toManual() {
        context.setState(new ManualState(context));
    }

    @Override
    public void toTimer(int min) {
        context.setState(new TimerState(context, min));
    }

    @Override
    public void toProgram(float targetTemp) {
        context.setState(new ProgramState(context, targetTemp));
    }
}
