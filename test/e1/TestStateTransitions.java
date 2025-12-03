package e1;

import e1.Thermostat.Thermostat;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestStateTransitions {

    @Test
    public void stateOffTransitionsTest() {

        Thermostat thermostat = new Thermostat();
        thermostat.toOff();

        thermostat = new Thermostat();
        thermostat.toManual();

        thermostat = new Thermostat();
        thermostat.toProgram(23);

        thermostat = new Thermostat();
        thermostat.toTimer(20);
    }

    @Test
    public void stateManualTransitionsTest() {

        Thermostat thermostat = new Thermostat(); thermostat.toManual();
        thermostat.toOff();

        thermostat = new Thermostat(); thermostat.toManual();
        thermostat.toManual();

        thermostat = new Thermostat(); thermostat.toManual();
        thermostat.toProgram(23);

        thermostat = new Thermostat(); thermostat.toManual();
        thermostat.toTimer(20);
    }

    @Test
    public void stateProgramTransitionsTest() {

        Thermostat thermostat = new Thermostat(); thermostat.toProgram(23);
        thermostat.toOff();

        thermostat = new Thermostat(); thermostat.toProgram(23);
        thermostat.toManual();

        thermostat = new Thermostat(); thermostat.toProgram(23);
        thermostat.toProgram(23);

        thermostat = new Thermostat(); thermostat.toProgram(23);
        thermostat.toTimer(20);
    }

    @Test
    public void stateTimerTransitionsTest() {

        Thermostat thermostat = new Thermostat(); thermostat.toTimer(20);
        thermostat.toOff();

        thermostat = new Thermostat(); thermostat.toTimer(20);
        thermostat.toManual();

        thermostat = new Thermostat(); thermostat.toTimer(20);
        thermostat.toProgram(23);

        thermostat = new Thermostat(); thermostat.toTimer(20);
        thermostat.toTimer(20);
    }
}
