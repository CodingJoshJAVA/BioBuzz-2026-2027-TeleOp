package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Console {
    private final Telemetry telemetry;
    private static final String COLOR_INFO = "#abd5ff";
    private static final String COLOR_WARN = "#ffb700";
    private static final String COLOR_ERROR = "#b80000";

    public Console(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void log(String value) {
        telemetry.addLine(value);
    }

    public void log(String key, String value) {
        telemetry.addData(key, value);
    }

    public void info(String value) {
        log(formatHtml(COLOR_INFO, value));
    }

    public void info(String key, String value) {
        log(formatHtml(COLOR_INFO, key), formatHtml(COLOR_INFO, value));
    }

    public void warn(String value) {
        log(formatHtml(COLOR_WARN, value));
    }

    public void warn(String key, String value) {
        log(formatHtml(COLOR_WARN, key), formatHtml(COLOR_WARN, value));
    }

    public void error(String value) {
        log(formatHtml(COLOR_ERROR, value));
    }

    public void error(String key, String value) {
        log(formatHtml(COLOR_ERROR, key), formatHtml(COLOR_ERROR, value));
    }

    public void h1(String text, String Color) {
        log("<font color=\"" + Color + "\"><h1>" + text + "</h1></font>");
    }

    private String formatHtml(String color, String text) {
        return "<font color='" + color + "'>" + text + "</font>";
    }
}
