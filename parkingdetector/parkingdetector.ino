// LCD
#include <LiquidCrystal.h>
const int rs = 1, en = 2, d4 = 4, d5 = 5, d6 = 6, d7 = 7;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

// LEDs
int redLed = 33;
int yellowLed = 32;
int greenLed = 30;

// movement
const int sensor = 50;

// proximity
const int trigPin = 51;
const int echoPin = 52;
long duration;
int distance;

int capacity = 5;
int occupied = 0;
int freeSpace = capacity;

void setup()
{
  // lcd
  lcd.begin(16,2);

  // Leds
  pinMode(redLed, OUTPUT);
  pinMode(yellowLed, OUTPUT);
  pinMode(greenLed, OUTPUT);
  
  // movement
  pinMode(sensor, INPUT);

  // proximity
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);

  // weather
  //bmp.begin();
}

void loop()
{

  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance= duration*0.034/2;

  lcd.print("Distance: ");
  lcd.print(distance);
  lcd.print("cm");
  delay(2000);
  lcd.clear();

  if(distance < 6)
  {
    digitalWrite(yellowLed, HIGH);
    lcd.print("Free spaces: ");
    lcd.print(freeSpace);
    delay(2000);
    lcd.clear();
    digitalWrite(yellowLed, LOW);
    if(freeSpace>0)
    {
      digitalWrite(greenLed, HIGH);
      lcd.print("Access granted !");
      delay(2000);
      lcd.clear();
      occupied = occupied + 1;
      freeSpace = capacity - occupied;
      digitalWrite(greenLed, LOW);
    }
    else
    {
      digitalWrite(redLed, HIGH);
      lcd.print("There is no space !");
      delay(2000);
      lcd.clear();
      digitalWrite(redLed, LOW);
    }
  }

//  lcd.print("Temperature: ");
//  lcd.print(bmp.readTemperature()); // *C
//  lcd.print("C")
//  delay(2000);
//  lcd.clear();
//  lcd.print("Presure: ");
//  lcd.print(bmp.readPressure(); // Pa
//  lcd.print("Pa");
//  lcd.delay(2000);
//  lcd.clear();
//  lcd.print("Altitude: ");
//  lcd.print(bmp.readAltitude()); // meters
//  lcd.print("m");
//  delay(2000);
//  lcd.clear();



  
//  bool Detection = digitalRead(sensor);
//  if(Detection==HIGH)
//  {
//    lcd.print("MOTION");
//  }
//  if(Detection==LOW)
//  {
//   lcd.print("CLEAR");
//  }
//  delay(2000);
//  lcd.clear();



  
//  lcd.print("Hackathon 2019");
//  delay(3000);
//  
//  lcd.setCursor(2,1);
//  lcd.print("Quantum team");
//  delay(3000);
//  
//  lcd.clear();
//  
//  lcd.blink();
//  delay(3000);
//  lcd.setCursor(7,1);
//  delay(3000);
//  lcd.noBlink();
//  
//  lcd.cursor();
//  delay(3000);
//  lcd.noCursor();
//  
//  lcd.clear();
}
