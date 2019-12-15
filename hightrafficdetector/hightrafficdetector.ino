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

int threshold1 = 0;
int threshold2 = 5;
int threshold3 = 10;
int counter = 0;
int busy = 0;

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
  
}

void loop()
{

//  digitalWrite(trigPin, LOW);
//  delayMicroseconds(2);
//  digitalWrite(trigPin, HIGH);
//  delayMicroseconds(10);
//  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance= duration*0.034/2;

//  lcd.print("Distance: ");
//  lcd.print(distance);
//  lcd.print("cm");
//  delay(2000);
//  lcd.clear();

  lcd.print("Looking for cars...");
   if(counter < 6)
  {
    digitalWrite(greenLed,LOW);
    digitalWrite(redLed,HIGH);
    digitalWrite(yellowLed,LOW);
  }
  if(counter < 4)
  {
    digitalWrite(greenLed,LOW);
    digitalWrite(redLed,LOW);
    digitalWrite(yellowLed,HIGH);
  }
  if(counter < 2)
  {
    digitalWrite(greenLed,HIGH);
    digitalWrite(redLed,LOW);
    digitalWrite(yellowLed,LOW);
  }
  
 

  bool Detection = digitalRead(sensor);
  if(Detection==HIGH)
  {
    lcd.clear();
    lcd.print("Car detected ");
    lcd.print(counter);
    delay(500);
    counter = counter + 1;
  }
  if(Detection==LOW)
  {
    delay(500);
    counter = counter - 1;
  }

  if(counter > threshold1)
  {
    busy = 0;
  }
  if (counter > threshold2)
  {
    busy = 1;
  }
  if (counter > threshold2)
  {
    busy = 2;
  }
  
  delay(1000);
  lcd.clear();



  
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
