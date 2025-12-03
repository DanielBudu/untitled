package States;

import Thermostat.Thermostat;

public class TimerState implements ThermostatState {

    private final Thermostat context;
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

        if (minutesLeft <= 0) {
            context.logEvent("Se desactiva el modo Timer.");
            context.setState(new OffState(context));
        }
    }

    @Override
    public String screenInfo() {
        return context.getCurrentTemp() + " Modo Timer (faltan" + minutesLeft + "minutos) - Calefaccion "
                + (context.isHeaterOn() ? "encendida." : "apagada.");
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
        // TODO: ESTA TRANSICION DE ESTADO NO SE PUEDE HACER, HAY QUE O NO HACER NADA O HACER QUE PASE PRIMERO POR OFF O MANUAL Y LUEGO A PROGRAM
        context.setState(new ProgramState(context, temp));
    }
}
