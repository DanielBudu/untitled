package States;

import Thermostat.Thermostat;

public class TimerState implements ThermostatState {

    private Thermostat context;
    private int minutesLeft; // tiempo restante

    public TimerState(Thermostat context, int minutes) {
        this.context = context;
        this.minutesLeft = minutes;
        context.setHeaterOn(true);
        context.logEvent("Se activa el modo Timer " + minutes + " minutos.");
    }

    @Override
    public void newTemperature(float temp) {
        // Siempre ON
        context.setHeaterOn(true);

        // Cada llamada = pasan 5 min
        minutesLeft -= 5;

        context.logEvent("Timer: quedan " + minutesLeft + " minutos.");

        if (minutesLeft <= 0) {
            context.logEvent("Timer finalizado. Se pasa a OFF.");
            context.setState(new OffState(context));
        }
    }

    @Override
    public String screenInfo() {
        return context.getCurrentTemp() +
                " ON T(" + minutesLeft + ")";
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
        // Reprogramar el temporizador
        this.minutesLeft = minutes;
        context.logEvent("Timer reconfigurado a " + minutes + " minutos.");
    }

    @Override
    public void toProgram(float temp) {
        context.setState(new ProgramState(context, temp));
    }
}
