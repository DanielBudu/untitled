package States;

import Thermostat.Thermostat;

public class ProgramState implements ThermostatState {

    private final Thermostat context;
    private float targetTemp;

    public ProgramState(Thermostat context, float targetTemp) {
        this.context = context;
        this.targetTemp = targetTemp;
        context.logEvent("Se activa el modo Program a " + targetTemp + " grados.");
    }

    @Override
    public void newTemperature(float temp) {
        if (temp < targetTemp) {
            context.setHeaterOn(true);
        } else {
            context.setHeaterOn(false);
        }
    }

    @Override
    public String screenInfo() {
        return context.getCurrentTemp() +
                (context.isHeaterOn() ? " ON" : " OFF") +
                " P(" + targetTemp + ")";
    }

    @Override
    public void toOff() {
        context.setState(new OffState(context));
    }

    @Override
    public void toManual() {
        context.setState(new ManualState(context));
    }

    @Override
    public void toTimer(int minutes) {
        // Timer desde Program generalmente permitido excepto si el profesor dice lo contrario
        context.setState(new TimerState(context, minutes));
    }

    @Override
    public void toProgram(float temp) {
        // Reconfigurar consigna
        this.targetTemp = temp;
        context.logEvent("Cambio de consigna Program a " + temp);
    }
}
