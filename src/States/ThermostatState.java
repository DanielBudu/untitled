package States;

public interface ThermostatState {


        void newTemperature(float currentTemp);
        String screenInfo();

        void toOff();
        void toManual();
        void toTimer(int min);
        void toProgram(float temp);
}
