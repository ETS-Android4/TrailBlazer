package org.firstinspires.ftc.teamcode.gamepadex;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadEventName;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadEventType;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadListener;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadType;

import java.util.ArrayList;
import java.util.List;

public class GamepadEx {

    public Gamepad gamepad;
    public GamepadType type;

    public GamepadEx(Gamepad gamepad, GamepadType type) {
        this.gamepad = gamepad;
        this.type = type;
    }

    private List<GamepadListener> listeners = new ArrayList<>();
    private ElapsedTime elapsedTime;

    private final int BUTTONS_TO_COUNT = 15;
    private boolean[] buttonPastValues = new boolean[BUTTONS_TO_COUNT];
    private boolean[] buttonValues = new boolean[BUTTONS_TO_COUNT];
    private GamepadEventName[] eventNameList = GamepadEventName.values();

    public void addListener(GamepadListener listener) {
        listeners.add(listener);
    }

    public void update() {
        if (listeners.size() == 0) {
            return;
        }

        buttonValues[0] = gamepad.dpad_up;
        buttonValues[1] = gamepad.dpad_down;
        buttonValues[2] = gamepad.dpad_left;
        buttonValues[3] = gamepad.dpad_right;
        buttonValues[4] = gamepad.a;
        buttonValues[5] = gamepad.b;
        buttonValues[6] = gamepad.x;
        buttonValues[7] = gamepad.y;
        buttonValues[8] = gamepad.guide;
        buttonValues[9] = gamepad.start;
        buttonValues[10] = gamepad.back;
        buttonValues[11] = gamepad.left_bumper;
        buttonValues[12] = gamepad.right_bumper;
        buttonValues[13] = gamepad.left_stick_button;
        buttonValues[14] = gamepad.right_stick_button;

        for (int i = 0; i < BUTTONS_TO_COUNT; i++) {
            if (buttonValues[i] && !buttonPastValues[i]) {
                for (GamepadListener listener : listeners) {
                    listener.actionPerformed(eventNameList[i], GamepadEventType.BUTTON_PRESSED, type);
                }

                buttonPastValues[i] = true;
            } else if (!buttonValues[i] && buttonPastValues[i]) {
                for (GamepadListener listener : listeners) {
                    listener.actionPerformed(eventNameList[i], GamepadEventType.BUTTON_RELEASED, type);
                }

                buttonPastValues[i] = false;
            }





        }
    }
}
