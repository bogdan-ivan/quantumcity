export default class GlobalVariables {
    constructor(){
        this.temperature = 0;
        this.vreauSaParchez = 0;
        this.sound = 5;
    }
}

exports.default = GlobalVariables;

var five = require("johnny-five");
var board = new five.Board({
    //baudrate: 9600,
    port: "COM13"
});

board.on("ready", function () {

    // LCD
    const rs = 1, en = 2, d4 = 4, d5 = 5, d6 = 6, d7 = 7;
    var lcd = new five.LCD({
        // LCD pin name  RS  EN  DB4 DB5 DB6 DB7
        pins: [rs, en, d4, d5, d6, d7],
        controller: "HD44780"
    });



    // RedLED
    var led = new five.Led(30);



    // Movement
    var motion = new five.Motion(50);

    motion.on("calibrated", function () {
        console.log("\n### MOTION ###");
        console.log("calibrated");
        // lcd.clear();
        lcd.print("CALB");
    });
    motion.on("motionstart", function () {
        console.log("\n### MOTION ###");
        console.log("motion-start");
        //lcd.clear();
        lcd.print("STRT");
        led.on();
    });
    motion.on("motionend", function () {
        console.log("\n### MOTION ###");
        console.log("motion-end");
        //lcd.clear();
        lcd.print("END");
        led.off();
    });



    // Proximity
    var proximity = new five.Proximity({
        controller: "HCSR04",
        pin: 51
    });
    proximity.on("change", function () {
        console.log("\n### PROX ###");
        console.log("cm: ", this.cm);
    });



    // Pressure & Temperature
    var multi = new five.Multi({
        controller: "BMP085"
    });
    multi.on("change", function () {
        console.log("\n### BAR ###");
        console.log("Thermometer");
        console.log("  celsius      : ", this.thermometer.celsius);
        console.log("  fahrenheit   : ", this.thermometer.fahrenheit);
        console.log("  kelvin       : ", this.thermometer.kelvin);
        console.log("--------------------------------------");

        console.log("Barometer");
        console.log("  pressure     : ", this.barometer.pressure);
        console.log("--------------------------------------");
    });



    // Gas
    var gas = new five.Sensor("A0");
    gas.on("change", function () {
        console.log("\n### GAS ###");
        console.log(this.scaleTo(0, 128));
    });



    // Sound
    var sound = new five.Sensor("A1");
    sound.on("change", function () {
        console.log("\n### SOUND ###");
        console.log(this.scaleTo(0, 1023));
    });



    board.on("exit", () => {
        led.off();
        lcd.clear();
    });
});