package org.firstinspires.ftc.teamcode.gamepadex;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadListener;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadType;

public class DriverInterface {

    public GamepadEx driver;

    public DriverInterface(Gamepad driver) {
        this.driver = new GamepadEx(driver, GamepadType.DRIVER);
    }

    public DriverInterface(Gamepad driver, GamepadListener listener) {
        this.driver = new GamepadEx(driver, GamepadType.DRIVER);

        this.driver.addListener(listener);

    }
    public void update() {
        this.driver.update();

    }

    public void addListener(GamepadListener listener) {
        this.driver.addListener(listener);

    }

}
