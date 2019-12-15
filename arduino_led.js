var five = require("johnny-five");
var board = new five.Board({
    //baudrate: 9600,
    port: "COM13"
});

// Keyboard Input
var keypress = require("keypress");
keypress(process.stdin);

// Parking
const parkingMinCm = 5;
var parkingStatus = 2;// 0=denied,1=accepted,2=neutru




board.on("ready", function () {

    // Keyboard
    process.stdin.resume();
    process.stdin.setEncoding("utf8");
    process.stdin.setRawMode(true);
    process.stdin.on("keypress", function (ch, key) {
        if (!key) {
            return;
        }

        if (key.name == "up") {
            parkingStatus = 1;
        }
        else if (key.name == "down") {
            parkingStatus = 0;
        }
    });



    // LCD
    const rs = 1, en = 2, d4 = 4, d5 = 5, d6 = 6, d7 = 7;
    var lcd = new five.LCD({
        // LCD pin name  RS  EN  DB4 DB5 DB6 DB7
        pins: [rs, en, d4, d5, d6, d7],
        controller: "HD44780"
    });



    // LEDs
    var redLed = new five.Led(33);
    var yellowLed = new five.Led(32);
    var greenLed = new five.Led(30);


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
    });
    motion.on("motionend", function () {
        console.log("\n### MOTION ###");
        console.log("motion-end");
        //lcd.clear();
        lcd.print("END");
    });



    // Proximity
    var proximity = new five.Proximity({
        controller: "HCSR04",
        pin: 51
    });
    proximity.on("change", function () {
        console.log("\n### PROX ###");
        console.log("cm: ", this.cm);

        if (this.cm <= parkingMinCm) {
            yellowLed.on();
            if (parkingStatus === 1) {
                greenLed.on();
            }
            else if (parkingStatus === 0) {
                redLed.on();
            }
        }
        else {
            yellowLed.off();
            redLed.off();
            greenLed.off();
            parkingStatus = 2;
        }
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



    // Exit
    board.on("exit", () => {
        redLed.off();
        greenLed.off();
        yellowLed.off();
        lcd.clear();
    });
});